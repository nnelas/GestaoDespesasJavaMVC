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
import javax.persistence.Query;
import javax.validation.Valid;
import java.security.Principal;
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
    public String getAgregado(ModelMap model,
                              Principal user) {

        List<Agregado> agregados = em.createQuery("select a from Agregado a where a.agregado1 = '" + user.getName() + "'", Agregado.class).getResultList();
        Query query = em.createQuery("select a from Agregado a where a.agregado2 = '" + user.getName() + "'", Agregado.class);
        agregados.addAll(query.getResultList());

        model.put("agregados", agregados);
        model.put("agregadoForm", new AgregadoForm());

        return "agregado";
    }

    @RequestMapping(value = "/agregado", method = RequestMethod.POST)
    public String submitAgregado(@Valid @ModelAttribute("agregadoForm") AgregadoForm agregadoForm,
                                  BindingResult bindingResult,
                                  ModelMap model,
                                  Principal user) {

        if (bindingResult.hasErrors()) {
            return "agregado";
        }

        Agregado agregado;
        if (agregadoForm.getId() != null) {
            agregado = em.find(Agregado.class, agregadoForm.getId());
        } else {
            agregado = new Agregado();
        }

        agregado.setAgregado1(user.getName());
        agregado.setAgregado2(agregadoForm.getAgregado2());
        em.persist(agregado);

        model.addAttribute("message", "Sucesso! O utilizador " + agregado.getAgregado2() + " foi adicionado ao seu agregado familiar, foi gravado na BD e foi-lhe atribuído o ID " + agregado.getId());

        return "agregadoResult";

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

        model.addAttribute("message", "Sucesso! O utilizador " + agregado.getAgregado2() + " foi eliminado do seu agregado familiar");

        return "agregadoResult";
    }
}
