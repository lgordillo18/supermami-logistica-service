package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.Product;
import com.supermamilogisticaservice.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
  @Autowired
  private IProductRepository iProductRepository;

  public ArrayList<Product> getAllProducts(){
    return (ArrayList<Product>) iProductRepository.findAll();
  }
}
