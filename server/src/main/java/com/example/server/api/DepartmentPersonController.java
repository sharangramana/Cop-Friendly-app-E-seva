package com.example.server.api;

import com.example.server.model.Department_member;
import com.example.server.service.DepartmentPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@RequestMapping("api/department")
@RestController
public class DepartmentPersonController {
    private final DepartmentPersonService departmentPersonService;

    @Autowired
    public DepartmentPersonController(DepartmentPersonService departmentPersonService) {
        this.departmentPersonService = departmentPersonService;
    }

    @CrossOrigin
    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Department_member departmentperson) {
        departmentPersonService.addDepartmentPerson(departmentperson);
    }

    @GetMapping
    public List<Department_member> getAllPeople() {
        return departmentPersonService.getAllDepartmentPeople();
    }

    @GetMapping(path = "{Police_Id}") // it actually means get the ID from the path "/'id'"
    public Department_member getPersonById(@PathVariable("Police_Id") Integer id) { //gets the userID from the path
        return departmentPersonService.getDepartmentPersonByID(id);
    }

    @DeleteMapping(path= "{Police_Id}")
    public void deletePersonById( @PathVariable("Police_Id") Integer id) {
        departmentPersonService.deleteDepartmentPerson(id);
    }

    @PutMapping(path = "{Police_Id}")
    public void updateDepartmentPerson(@PathVariable("Police_Id") Integer id, @RequestBody Department_member DepartmentpersonToUpdate) {
        departmentPersonService.updateDepartmentPerson(id, DepartmentpersonToUpdate);
    }
}
