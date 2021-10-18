package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.models.Area;
import com.supermamilogisticaservice.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/logistica-service")
public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping("/areas")
    public ArrayList<Area> getAllAreas(){
        return  areaService.getAllAreas();
    }
}
