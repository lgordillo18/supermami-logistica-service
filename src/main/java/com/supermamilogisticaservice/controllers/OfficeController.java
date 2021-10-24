package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/logistica-service")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @PostMapping("/office")
    public Office createOffice(@Validated @RequestBody Office office) {
        return officeService.saveOffice(office);
    }

    @DeleteMapping("/office/{id}")
    public void deleteOffice(@PathVariable int id) {
        officeService.deleteOffice(id);
    }
}


