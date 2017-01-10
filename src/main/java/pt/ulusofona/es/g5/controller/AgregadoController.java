package pt.ulusofona.es.g5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by nunonelas on 10/01/17.
 */

@Controller
@Transactional
public class AgregadoController {

    @PersistenceContext
    private EntityManager em;


}
