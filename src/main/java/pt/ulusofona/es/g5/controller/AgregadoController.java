package pt.ulusofona.es.g5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pt.ulusofona.es.g5.data.Agregado;
import pt.ulusofona.es.g5.form.AgregadoForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by nunonelas on 10/01/17.
 */

@Controller
@Transactional
public class AgregadoController {

    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value = "/agregado", method = RequestMethod.GET)
    public String getAgregado(ModelMap model) {
        List<Agregado> agregados = em.createQuery("select a from Agregado a", Agregado.class).getResultList();
        model.put("agregados", agregados);
        model.put("agregadoForm", new AgregadoForm());
        return "agregado";
    }

    @RequestMapping(value = "/agregado", method = RequestMethod.POST)
    public String submitAgregado(@Valid @ModelAttribute("agregadoForm") AgregadoForm agregadoForm,
                                  BindingResult bindingResult,
                                  ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "agregado";
        }

        Agregado agregado;
        if (agregadoForm.getId() != null) {
            agregado = em.find(Agregado.class, agregadoForm.getId());
        } else {
            agregado = new Agregado();
        }

        agregado.setAgregado1(agregadoForm.getAgregado1());
        agregado.setAgregado2(agregadoForm.getAgregado2());
        em.persist(agregado);

        model.addAttribute("message", "Sucesso! O agregado '" + agregado.getAgregado1() + " + " + agregado.getAgregado2() + "' foi gravado na BD e foi-lhe atribuído o ID " + agregado.getId());
        return "adminAgrResult";

    }

    @RequestMapping(value = "/agregadoEdit/{id}", method = RequestMethod.GET)
    public String editCategoria(ModelMap model, @PathVariable("id") Long id) {
        Agregado agregado = em.find(Agregado.class, id);
        AgregadoForm agregadoForm = new AgregadoForm();
        agregadoForm.setId(agregado.getId());
        agregadoForm.setAgregado1(agregado.getAgregado1());
        agregadoForm.setAgregado2(agregado.getAgregado2());

        model.put("agregadoForm", agregadoForm);

        return "agregado";
    }

    @RequestMapping(value = "/agregadoDelete/{id}", method = RequestMethod.POST)
    public String deleteAgregado(ModelMap model, @PathVariable("id") Long id) {

        Agregado agregado = em.find(Agregado.class, id);

        em.remove(agregado);

        model.addAttribute("message", "Sucesso! O agregado " + agregado.getAgregado1() + " + " + agregado.getAgregado2() + " foi eliminada");

        return "adminAgrResult";
    }
}
