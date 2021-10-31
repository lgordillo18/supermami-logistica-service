package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.AreaDto;
import com.supermamilogisticaservice.models.Area;
import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin

@RestController

@RequestMapping("/api/logistica-service/office")
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @GetMapping("/offices")
    private List<Office> getAllOffices(){
        return officeService.getAllOffices();
    }

    @PutMapping("/update")
    private Office update(@RequestBody Office office){
        officeService.saveOffice(office);
        return office;
    }

    @PostMapping("/save")
    private int save(@RequestBody Office office){
        officeService.saveOffice(office);
        return office.getId();
    }

    @DeleteMapping("/delete/{id}")
    private void deleteOffice(@PathVariable("id") int officeId){
        officeService.deleteOffice(officeId);
    }
}