package com.supermamilogisticaservice.services;


import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.repositories.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Service
public class OfficeService {
    @Autowired
    private IOfficeRepository iOfficeRepository;

    public void saveOffice(Office office){
         iOfficeRepository.save(office);
    }

    public ArrayList<Office> getAllOffices(){
        return (ArrayList<Office>) iOfficeRepository.findAll();
    }
  
    public void deleteOffice(int id) { iOfficeRepository.deleteById(id); }

    public Optional<Office> getOffice (Integer id){
        return iOfficeRepository.findById(id);
    }
}

