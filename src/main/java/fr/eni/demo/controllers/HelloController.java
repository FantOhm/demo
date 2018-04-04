package fr.eni.demo.controllers;

import fr.eni.demo.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"personne"})
public class HelloController {

    @Autowired
    private Personne personne;

    @GetMapping("/hello")
    public String sayHello() {
        personne.setFirstName("Jonathan");
        personne.setLastName("DESERT");
        return personne.toString();
    }

    @RequestMapping("/welcome")
    public String doGreetings(Model model) {
        personne.setLastName("Desert");
        personne.setFirstName("Jonathan");
        model.addAttribute("personne", personne);
        return "welcome";
    }
}
