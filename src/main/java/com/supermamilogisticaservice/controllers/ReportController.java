package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.*;
import com.supermamilogisticaservice.interfaces.IOrdersByDealerList;
import com.supermamilogisticaservice.interfaces.IProductList;
import com.supermamilogisticaservice.interfaces.ITicketStatusByOffice;
import com.supermamilogisticaservice.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/logistica-service")
public class ReportController {
  @Autowired
  private ReportService reportService;

  // Top 10 de productos mas requeridos
  @GetMapping(value = {"/report-top-10", "/report-top-10/{office_id}", "/report-top-10/{date_from}/{date_to}", "/report-top-10/{office_id}/{date_from}/{date_to}"})
  public ResponseEntity getReport1(@PathVariable(required = false) Integer office_id, @PathVariable(required = false) String date_from, @PathVariable(required = false) String date_to) {
    ArrayList response = new ArrayList<>();

    try {
      // Search by office
      if (office_id != null && date_from == null && date_to == null) {
        List<IProductList> dataResponse = reportService.getTop10ProductsByOffice(office_id);
        for (IProductList item: dataResponse) {
          ProductDto product = new ProductDto(item.getCode(), item.getName(), item.getTotal(), item.getOffice());
          response.add(product);
        }
      }
      // Search by office and date
      else if (office_id != null && date_from != null && date_to != null) {
        List<IProductList> dataResponse = reportService.getTop10ProductsByOfficeAndDate(office_id, date_from, date_to);
        for (IProductList item: dataResponse) {
          ProductDto product = new ProductDto(item.getCode(), item.getName(), item.getTotal(), item.getOffice());
          response.add(product);
        }
      }
      // Search by date
      else if (office_id == null && date_from != null && date_to != null) {
        List<IProductList> dataResponse = reportService.getTop10ProductsByDate(date_from, date_to);
        for (IProductList item: dataResponse) {
          ProductDto product = new ProductDto(item.getCode(), item.getName(), item.getTotal(), item.getOffice());
          response.add(product);
        }
      } else {
        List<ProductListDto> dataResponse = reportService.getTop10Products();
        for (ProductListDto item: dataResponse) {
          ProductDto product = new ProductDto(item.getCode(), item.getName(), item.getTotal(), null);
          response.add(product);
        }
      }
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  // Cantidad de pedidos entregados por repartidor filtrados por sucursal o por fechas
  @GetMapping(value = {"/report-orders-delivered/{office_id}", "/report-orders-delivered/{date_from}/{date_to}", "/report-orders-delivered/{office_id}/{date_from}/{date_to}"})
  public ResponseEntity getReport2(@PathVariable(required = false) Integer office_id, @PathVariable(required = false) String date_from, @PathVariable(required = false) String date_to) {
    ArrayList response = new ArrayList<>();
    List<IOrdersByDealerList> dataResponse = new ArrayList<>();

    try {
      // Search by office
      if (office_id != null && date_from == null && date_to == null) {
        dataResponse = reportService.getOrdersByDealerByOffice(office_id);
      }
      // Search by office and date
      else if (office_id != null && date_from != null && date_to != null) {
        dataResponse = reportService.getOrdersByDealerByOfficeAndDate(office_id, date_from, date_to);
      }
      // Search by date
      else if (office_id == null && date_from != null && date_to != null) {
        dataResponse = reportService.getOrdersByDealerByDate(date_from, date_to);
      } else {
        return new ResponseEntity<>("Parameters missing", HttpStatus.NOT_FOUND);
      }

      for (IOrdersByDealerList item: dataResponse) {
        OrderListByDealerDto order = new OrderListByDealerDto(item.getFirstName(), item.getLastName(), item.getOffice(), item.getTotal());
        response.add(order);
      }

      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  // Estado de pedidos por sucursal filtrados por sucursal o por fechas
  @GetMapping(value = {"/report-ticket-status-by-office","/report-ticket-status-by-office/{office_id}", "/report-ticket-status-by-office/{date_from}/{date_to}", "/report-ticket-status-by-office/{office_id}/{date_from}/{date_to}"})
  public ResponseEntity getReport3(@PathVariable(required = false) Integer office_id, @PathVariable(required = false) String date_from, @PathVariable(required = false) String date_to) {
    ArrayList response = new ArrayList<>();
    List<ITicketStatusByOffice> dataResponse = new ArrayList<>();

    try {
      // Search by office
      if (office_id != null && date_from == null && date_to == null) {
        dataResponse = reportService.getTicketStatusByOfficeFilteredByOffice(office_id);
      }
      // Search by office and date
      else if (office_id != null && date_from != null && date_to != null) {
        dataResponse = reportService.getTicketStatusByOfficeFilteredByOfficeAndDate(office_id, date_from, date_to);
      }
      // Search by date
      else if (office_id == null && date_from != null && date_to != null) {
        dataResponse = reportService.getTicketStatusByOfficeFilteredByDate(date_from, date_to);
      } else {
        dataResponse = reportService.getAllTicketStatusByOffice();
      }

      for (ITicketStatusByOffice item: dataResponse) {
        TicketStatusByOfficeDto ticketStatus = new TicketStatusByOfficeDto(item.getOffice(), item.getStatus(), item.getTotal());
        response.add(ticketStatus);
      }

      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }
}
