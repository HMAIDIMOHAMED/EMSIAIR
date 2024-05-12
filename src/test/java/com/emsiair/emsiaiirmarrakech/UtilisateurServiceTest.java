package com.emsiair.emsiaiirmarrakech;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.emsiair.emsiaiirmarrakech.Model.Utilisateur;
import com.emsiair.emsiaiirmarrakech.Repository.UtilisateurRepository;
import com.emsiair.emsiaiirmarrakech.Service.UtilisateurService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

@SpringBootTest
public class UtilisateurServiceTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurService utilisateurService;

    @Test
    public void testGetUserById() {

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setNom("HMAIDI MOHAMED");
        utilisateur.setEmail("Mohamed@example.com");
        utilisateur.setMotDePasse("123");


        when(utilisateurRepository.findById(1L)).thenReturn(Optional.of(utilisateur));


        Utilisateur result = utilisateurService.getUserById(1L);


        assertNotNull(result);
        assertEquals("HMAIDI MOHAMED", result.getNom());
        assertEquals("Mohamed@example.com", result.getEmail());
        assertEquals("123", result.getMotDePasse());

        verify(utilisateurRepository, times(1)).findById(1L);
    }
    @Test
    public void testInscription_EmailAlreadyExists() {
        Utilisateur existingUser = new Utilisateur();
        existingUser.setEmail("Adnane@example.com");

        when(utilisateurRepository.findByEmail("Adnane@example.com")).thenReturn(existingUser);

        Utilisateur newUser = new Utilisateur();
        newUser.setEmail("Adnane@example.com");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> utilisateurService.inscription(newUser));

        assertEquals("Email déjà utilisé !", exception.getMessage());

        verify(utilisateurRepository, times(1)).findByEmail("Adnane@example.com");
    }

    @Test
    public void testConnexion_IncorrectCredentials() {
        Utilisateur user = new Utilisateur();
        user.setEmail("Adnane@example.com");
        user.setMotDePasse("Ijjane");

        when(utilisateurRepository.findByEmail("Adnane@example.com")).thenReturn(user);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> utilisateurService.connexion("Adnane@example.com", "HMAIDI"));

        assertEquals("Email ou mot de passe incorrect !", exception.getMessage());

        verify(utilisateurRepository, times(1)).findByEmail("Adnane@example.com");
    }

}

