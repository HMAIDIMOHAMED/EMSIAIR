package com.emsiair.emsiaiirmarrakech.Controller;

import com.emsiair.emsiaiirmarrakech.Model.Utilisateur;
import com.emsiair.emsiaiirmarrakech.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin(origins = "http://localhost:3000")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Endpoint pour l'inscription d'un utilisateur
    @PostMapping("/inscription")
    public Utilisateur inscription(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.inscription(utilisateur);
    }

    @PostMapping("/connexion")
    public Utilisateur connexion(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.connexion(utilisateur.getEmail(), utilisateur.getMotDePasse());
    }

    // Endpoint pour la mise à jour d'un utilisateur
    @PutMapping("/{userId}")
    public Utilisateur updateUser(@PathVariable Long userId, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.updateUser(userId, utilisateur);
    }
    @GetMapping("/{userId}")
    public Utilisateur getUserById(@PathVariable Long userId) {
        return utilisateurService.getUserById(userId);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        utilisateurService.deleteUser(userId);
    }
    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

}
