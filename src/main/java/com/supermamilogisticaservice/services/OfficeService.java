package com.supermamilogisticaservice.services;


import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.repositories.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {
    @Autowired
    private IOfficeRepository iOfficeRepository;
    public Office saveOffice(Office office){
        return  iOfficeRepository.save(office);
    }
}

