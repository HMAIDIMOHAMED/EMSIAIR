package com.emsiair.emsiaiirmarrakech.Controller;

import com.emsiair.emsiaiirmarrakech.Model.Utilisateur;
import com.emsiair.emsiaiirmarrakech.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public Utilisateur inscription(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.inscription(utilisateur);
    }
}
