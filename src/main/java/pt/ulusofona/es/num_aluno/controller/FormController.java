package pt.ulusofona.es.num_aluno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pt.ulusofona.es.num_aluno.data.Utilizador;
import pt.ulusofona.es.num_aluno.form.UserForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class FormController {

    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(ModelMap model) {

        // obtem lista de utilizadores da BD

        // adiciona ao model

        return "list";
    }


    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(ModelMap model) {
        model.put("userForm", new UserForm());
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm,
                             BindingResult bindingResult,
                             ModelMap model) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        Utilizador utilizador = new Utilizador();

        // faz set das propriedades do utilizador

        em.persist(utilizador);

        model.addAttribute("message", "Sucesso! O utilizador " + utilizador.getName() +
                " foi gravado na BD e foi-lhe atribuído o id " + utilizador.getId());
        return "result";
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String getInfo(ModelMap model, @PathVariable("id") Long id) {

        Utilizador utilizador = em.find(Utilizador.class, id);

        model.put("utilizador", utilizador);

        return "info";
    }


}

