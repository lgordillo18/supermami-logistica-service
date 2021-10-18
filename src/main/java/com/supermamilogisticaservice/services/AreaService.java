package com.supermamilogisticaservice.services;


import com.supermamilogisticaservice.models.Area;
import com.supermamilogisticaservice.repositories.IAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AreaService {
    @Autowired
    IAreaRepository iAreaRepository;

    public ArrayList<Area> getAllAreas(){
        return (ArrayList<Area>) iAreaRepository.findAll();
    }
}
