package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.models.Product;
import com.supermamilogisticaservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/logistica-service")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/products")
  public ResponseEntity getAllProducts() {
    try {
      ArrayList<Product> products = productService.getAllProducts();
      return new ResponseEntity<>(products, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }
}
