package com.example.server.api;

import com.example.server.model.Repeater;
import com.example.server.service.RepeaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/violator/record")
@RestController
public class RepeaterRecordsController {

    private final RepeaterService repeaterService;

    @Autowired
    public RepeaterRecordsController(RepeaterService repeaterService) {
        this.repeaterService = repeaterService;
    }

    @PostMapping(path = "{License_number}")
    public void addRecords(@RequestBody Repeater repeater, @PathVariable("License_number") String License_number) {
        repeaterService.addRepeaterRecord(repeater, License_number);
    }

    @GetMapping(path= "{License_number}")
    public List<List<String>> selectRecordsByID(@PathVariable("License_number") String License_number) {
        return repeaterService.getAllRecordsByID(License_number);
    }
}
