package com.emsiair.emsiaiirmarrakech;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.emsiair.emsiaiirmarrakech.Model.Voyage;
import com.emsiair.emsiaiirmarrakech.Repository.VoyageRepository;
import com.emsiair.emsiaiirmarrakech.Service.VoyageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class VoyageServiceTest {

    @Mock
    private VoyageRepository voyageRepository;

    @InjectMocks
    private VoyageServiceImpl voyageService;

    @Test
    public void testGetAllVoyages() {
        Voyage voyage1 = new Voyage("Paris", new Date(), 5, 500.0);
        Voyage voyage2 = new Voyage("New York", new Date(), 7, 1000.0);
        List<Voyage> voyages = Arrays.asList(voyage1, voyage2);

        when(voyageRepository.findAll()).thenReturn(voyages);

        List<Voyage> result = voyageService.getAllVoyages();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Paris", result.get(0).getDestination());
        assertEquals("New York", result.get(1).getDestination());

        verify(voyageRepository, times(1)).findAll();
    }

    @Test
    public void testAddVoyage() {
        Voyage voyage = new Voyage("Tokyo", new Date(), 10, 1500.0);

        when(voyageRepository.save(voyage)).thenReturn(voyage);

        Voyage result = voyageService.addVoyage(voyage);

        assertNotNull(result);
        assertEquals("Tokyo", result.getDestination());

        verify(voyageRepository, times(1)).save(voyage);
    }

}
