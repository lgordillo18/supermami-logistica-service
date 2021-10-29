package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.AreaDto;
import com.supermamilogisticaservice.models.Area;
import com.supermamilogisticaservice.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/logistica-service")
public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping("/areas")
    public ResponseEntity getAllAreas() {
        ArrayList<AreaDto> areas = new ArrayList<AreaDto>();
        try {
            Iterable<Area> arrayAreas = areaService.getAllAreas();
            for (Area area: arrayAreas) {
                AreaDto newAreaDto = new AreaDto(area.getId(), area.getName());
                areas.add(newAreaDto);
            }
            return new ResponseEntity<>(areas, HttpStatus.OK);
        }
        catch ( Exception e ) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error Message");
        }
    }
}