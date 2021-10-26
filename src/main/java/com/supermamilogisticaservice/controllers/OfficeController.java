package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.OfficeDto;
import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/logistica-service")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @PostMapping("/office")
    public ResponseEntity createOffice(@Validated @RequestBody Office office) {
        try {
            Office newOffice = officeService.saveOffice(office);
            return new ResponseEntity<>(newOffice, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error Message");
        }
    }

    @GetMapping("/offices")
    public ResponseEntity getAllOffices() {
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
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error Message");
        }
    }
  
    @DeleteMapping("/office/{id}")
    public void deleteOffice(@PathVariable int id) {
        officeService.deleteOffice(id);
    }
}


