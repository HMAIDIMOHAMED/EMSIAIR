package com.emsiair.emsiaiirmarrakech.Service;

import com.emsiair.emsiaiirmarrakech.Model.Utilisateur;
import com.emsiair.emsiaiirmarrakech.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur inscription(Utilisateur utilisateur) {
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()) != null) {
            throw new RuntimeException("Email déjà utilisé !");
        }
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur connexion(String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);

        if (utilisateur == null || !utilisateur.getMotDePasse().equals(motDePasse)) {
            throw new RuntimeException("Email ou mot de passe incorrect !");
        }
        return utilisateur;
    }

    public Utilisateur updateUser(Long userId, Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUser = utilisateurRepository.findById(userId);
        if (optionalUser.isPresent()) {
            Utilisateur existingUser = optionalUser.get();
            // Mettre à jour les informations de l'utilisateur
            existingUser.setNom(utilisateur.getNom());
            existingUser.setEmail(utilisateur.getEmail());
            existingUser.setMotDePasse(utilisateur.getMotDePasse());
            return utilisateurRepository.save(existingUser);
        } else {
            throw new RuntimeException("Utilisateur non trouvé avec l'ID : " + userId);
        }
    }
    public Utilisateur getUserById(Long userId) {
        return utilisateurRepository.findById(userId).orElse(null);
    }
    public void deleteUser(Long userId) {
        Utilisateur existingUser = utilisateurRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + userId));

        utilisateurRepository.delete(existingUser);
    }
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

}
