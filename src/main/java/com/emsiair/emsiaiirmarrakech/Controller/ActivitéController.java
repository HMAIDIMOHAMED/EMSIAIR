package com.emsiair.emsiaiirmarrakech.Controller;

import com.emsiair.emsiaiirmarrakech.Model.Activité;
import com.emsiair.emsiaiirmarrakech.Service.ActivitéService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/activités")
public class ActivitéController {

    @Autowired
    private ActivitéService activitéService;

    @GetMapping
    public List<Activité> getAllActivités() {
        return activitéService.getAllActivités();
    }

    @GetMapping("/{id}")
    public Activité getActivitéById(@PathVariable Long id) {
        return activitéService.getActivitéById(id);
    }

    @PostMapping
    public Activité addActivité(@RequestBody Activité activité) {
        return activitéService.addActivité(activité);
    }

    @PutMapping("/{id}")
    public Activité updateActivité(@PathVariable Long id, @RequestBody Activité activité) {
        return activitéService.updateActivité(id, activité);
    }

    @DeleteMapping("/{id}")
    public void deleteActivité(@PathVariable Long id) {
        activitéService.deleteActivité(id);
    }
}
