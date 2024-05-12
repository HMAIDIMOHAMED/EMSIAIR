package com.emsiair.emsiaiirmarrakech;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.emsiair.emsiaiirmarrakech.Model.Activité;
import com.emsiair.emsiaiirmarrakech.Repository.ActivitéRepository;
import com.emsiair.emsiaiirmarrakech.Service.ActivitéService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ActivitéServiceTest {

    @Mock
    private ActivitéRepository activitéRepository;

    @InjectMocks
    private ActivitéService activitéService;

    @Test
    public void testGetAllActivités() {
        List<Activité> activités = new ArrayList<>();
        activités.add(new Activité("Visite du Louvre", "Découvrez l'un des plus grands musées du monde", 20.0));
        activités.add(new Activité("Croisière sur la Seine", "Profitez d'une croisière sur la Seine", 30.0));

        when(activitéRepository.findAll()).thenReturn(activités);

        List<Activité> result = activitéService.getAllActivités();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(activités, result);

        verify(activitéRepository, times(1)).findAll();
    }

    @Test
    public void testGetActivitéById() {
        Activité activité = new Activité("Visite du Louvre", "Découvrez l'un des plus grands musées du monde", 20.0);

        when(activitéRepository.findById(1L)).thenReturn(Optional.of(activité));

        Activité result = activitéService.getActivitéById(1L);

        assertNotNull(result);
        assertEquals(activité, result);

        verify(activitéRepository, times(1)).findById(1L);
    }
    @Test
    public void testAddActivité() {
        Activité activité = new Activité("Visite du Louvre", "Découvrez l'un des plus grands musées du monde", 20.0);

        when(activitéRepository.save(activité)).thenReturn(activité);

        Activité result = activitéService.addActivité(activité);

        assertNotNull(result);
        assertEquals(activité, result);

        verify(activitéRepository, times(1)).save(activité);
    }

    @Test
    public void testUpdateActivité() {
        Activité activité = new Activité("Visite du Louvre", "Découvrez l'un des plus grands musées du monde", 20.0);

        when(activitéRepository.findById(1L)).thenReturn(Optional.of(activité));

        Activité updatedActivité = new Activité("Nouvelle activité", "Description mise à jour", 30.0);

        Activité result = activitéService.updateActivité(1L, updatedActivité);

        assertNotNull(result);
        assertEquals(updatedActivité, result);

        verify(activitéRepository, times(1)).findById(1L);

        verify(activitéRepository, times(1)).save(activité);
    }

    @Test
    public void testDeleteActivité() {
        activitéService.deleteActivité(1L);

        verify(activitéRepository, times(1)).deleteById(1L);
    }


}
