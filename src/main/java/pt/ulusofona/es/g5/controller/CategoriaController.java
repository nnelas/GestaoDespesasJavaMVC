package pt.ulusofona.es.g5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pt.ulusofona.es.g5.data.Categoria;
import pt.ulusofona.es.g5.form.CategoriaForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * Created by nunonelas on 09/01/17.
 */

@Controller
@Transactional
public class CategoriaController {

    String Str1 = "Transportes";
    String Str2 = "Alimentação";
    String Str3 = "Propinas";
    String Str4 = "Renda";

    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value = "/categoria", method = RequestMethod.GET)
    public String getCategoria(ModelMap model) {
        List<Categoria> categorias = em.createQuery("select c from Categoria c", Categoria.class).getResultList();
        model.put("categorias", categorias);
        model.put("categoriaForm", new CategoriaForm());
        return "categoria";
    }

    @RequestMapping(value = "/categoria", method = RequestMethod.POST)
    public String submitCategoria(@Valid @ModelAttribute("categoriaForm") CategoriaForm categoriaForm,
                                  BindingResult bindingResult,
                                  ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "categoria";
        }

        if(Str1.equalsIgnoreCase(categoriaForm.getCategoria()) || Str2.equalsIgnoreCase(categoriaForm.getCategoria()) || Str3.equalsIgnoreCase(categoriaForm.getCategoria()) || Str4.equalsIgnoreCase(categoriaForm.getCategoria())){
            model.addAttribute("message", "A categoria " + categoriaForm.getCategoria() + " já existe e pertence ao grupo de categorias predefinidas");
        } else {
            Categoria categoria;
            if (categoriaForm.getId() != null) {
                categoria = em.find(Categoria.class, categoriaForm.getId());
            } else {
                categoria = new Categoria();
            }

            categoria.setCategoria(categoriaForm.getCategoria());
            em.persist(categoria);

            model.addAttribute("message", "Sucesso! A categoria " + categoria.getCategoria() + " foi gravada na BD e foi-lhe atribuído o ID " + categoria.getId());
        }
        return "adminCatResult";
    }

    @RequestMapping(value = "/categoriaEdit/{id}", method = RequestMethod.GET)
    public String editCategoria(ModelMap model, @PathVariable("id") Long id) {
        Categoria categoria = em.find(Categoria.class, id);
        CategoriaForm categoriaForm = new CategoriaForm();
        categoriaForm.setId(categoria.getId());
        categoriaForm.setCategoria(categoria.getCategoria());

        model.put("categoriaForm", categoriaForm);

        return "categoria";
    }

    @RequestMapping(value = "/categoriaDelete/{id}", method = RequestMethod.POST)
    public String deleteCategoria(ModelMap model, @PathVariable("id") Long id) {

        Categoria categoria = em.find(Categoria.class, id);

        em.remove(categoria);

        model.addAttribute("message", "Sucesso! A categoria " + categoria.getCategoria() + " foi eliminada");

        return "adminCatResult";
    }
}