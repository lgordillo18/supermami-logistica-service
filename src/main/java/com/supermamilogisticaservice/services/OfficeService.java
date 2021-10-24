package com.supermamilogisticaservice.services;


import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.repositories.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OfficeService {
    @Autowired
    private IOfficeRepository iOfficeRepository;

    public Office saveOffice(Office office){
        return iOfficeRepository.save(office);
    }

    public ArrayList<Office> getAllOffices(){
        return (ArrayList<Office>) iOfficeRepository.findAll();
    }
  
    public void deleteOffice(int id) { iOfficeRepository.deleteById(id); }
}

