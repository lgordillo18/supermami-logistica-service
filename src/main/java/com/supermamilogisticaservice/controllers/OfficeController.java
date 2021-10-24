package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.OfficeDto;
import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/offices")
    public ResponseEntity<ArrayList<OfficeDto>> getAllOffices() {
        ArrayList<OfficeDto> offices = new ArrayList<OfficeDto>();
        try {
            Iterable<Office> arrayOffices = officeService.getAllOffices();
            for (Office office: arrayOffices) {
                OfficeDto newOfficeDto = new OfficeDto(office.getId(), office.getName());
                offices.add(newOfficeDto);
            }
            return new ResponseEntity<>(offices, HttpStatus.OK);
        }
        catch ( Exception e ) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  
    @DeleteMapping("/office/{id}")
    public void deleteOffice(@PathVariable int id) {
        officeService.deleteOffice(id);
    }
}


