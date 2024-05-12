package com.emsiair.emsiaiirmarrakech.Controller;

import com.emsiair.emsiaiirmarrakech.Model.Utilisateur;
import com.emsiair.emsiaiirmarrakech.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connexion")
public class ConnexionController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public Utilisateur connexion(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.connexion(utilisateur.getEmail(), utilisateur.getMotDePasse());
    }
}
