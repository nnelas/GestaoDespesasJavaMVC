package pt.ulusofona.es.g5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nunonelas on 10/01/17.
 */

@Controller
@Transactional
public class AdminController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdmin() {
        return "admin";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String getPermDenied() {
        return "403";
    }
}
