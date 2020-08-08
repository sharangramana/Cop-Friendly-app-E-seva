package com.example.server.api;

import com.example.server.model.Violator;
import com.example.server.service.ViolatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/violator")
@RestController
public class ViolatorController {
    private final ViolatorService violatorService;

    @Autowired
    public ViolatorController(ViolatorService violatorService) {
        this.violatorService = violatorService;
    }

    @PostMapping(path = "{Police_Id}")
    public void addPerson(@Valid @NonNull @RequestBody Violator violator,
                          @PathVariable("Police_Id") Integer policeId) {
        violatorService.addviolatorPerson(violator, policeId);
    }

    @GetMapping
    public List<List<String>> getAllPeople() {
        return violatorService.getAllviolatorPeople();
    }

    @GetMapping(path = "{Violator_Id}") // it actually means get the ID from the path "/'id'"
    public Violator getPersonById(@PathVariable("Police_Id") Integer id) { //gets the userID from the path
        return violatorService.getviolatorPersonByID(id);
    }

    @DeleteMapping(path= "{Violator_Id}")
    public void deletePersonById( @PathVariable("Police_Id") Integer id) {
        violatorService.deleteviolatorPerson(id);
    }

    @PutMapping(path = "{Violator_Id}")
    public void updateDepartmentPerson(@PathVariable("Police_Id") Integer id, @RequestBody Violator ViolatorpersonToUpdate) {
        violatorService.updateviolatorPerson(id, ViolatorpersonToUpdate);
    }
}
