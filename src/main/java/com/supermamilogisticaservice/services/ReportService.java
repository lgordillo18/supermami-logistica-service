package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.dtos.ProductListDto;
import com.supermamilogisticaservice.interfaces.IOrdersByDealerList;
import com.supermamilogisticaservice.interfaces.IProductList;
import com.supermamilogisticaservice.interfaces.ITicketStatusByOffice;
import com.supermamilogisticaservice.repositories.IOrderTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
  @Autowired
  private IOrderTicketRepository iOrderTicketRepository;

  public List<ProductListDto> getTop10Products() {
    return (List<ProductListDto>) iOrderTicketRepository.findTop10Products();
  }

  public List<IProductList> getTop10ProductsByOffice(int office_id) {
    return (List<IProductList>) iOrderTicketRepository.findTop10ProductsByOffice(office_id);
  }

  public List<IProductList> getTop10ProductsByDate(String date_from, String date_to) {
    return (List<IProductList>) iOrderTicketRepository.findTop10ProductsByDate(date_from, date_to);
  }

  public List<IProductList> getTop10ProductsByOfficeAndDate(int office_id, String date_from, String date_to) {
    return (List<IProductList>) iOrderTicketRepository.findTop10ProductsByOfficeAndDate(office_id, date_from, date_to);
  }

  public List<IOrdersByDealerList> getOrdersByDealerByOffice(int office_id) {
    return (List<IOrdersByDealerList>) iOrderTicketRepository.findOrdersByDealerByOffice(office_id);
  }

  public List<IOrdersByDealerList> getOrdersByDealerByOfficeAndDate(int office_id, String date_from, String date_to) {
    return (List<IOrdersByDealerList>) iOrderTicketRepository.findOrdersByDealerByOfficeAndDate(office_id, date_from, date_to);
  }

  public List<IOrdersByDealerList> getOrdersByDealerByDate(String date_from, String date_to) {
    return (List<IOrdersByDealerList>) iOrderTicketRepository.findOrdersByDealerByDate(date_from, date_to);
  }

  public List<ITicketStatusByOffice> getAllTicketStatusByOffice() {
    return (List<ITicketStatusByOffice>) iOrderTicketRepository.findTicketStatusByOffice();
  }

  public List<ITicketStatusByOffice> getTicketStatusByOfficeFilteredByOffice(int office_id) {
    return (List<ITicketStatusByOffice>) iOrderTicketRepository.findTicketStatusByOfficeFilteredByOffice(office_id);
  }

  public List<ITicketStatusByOffice> getTicketStatusByOfficeFilteredByDate(String date_from, String date_to) {
    return (List<ITicketStatusByOffice>) iOrderTicketRepository.findTicketStatusByOfficeFilteredByDate(date_from, date_to);
  }

  public List<ITicketStatusByOffice> getTicketStatusByOfficeFilteredByOfficeAndDate(int office_id, String date_from, String date_to) {
    return (List<ITicketStatusByOffice>) iOrderTicketRepository.findTicketStatusByOfficeFilteredByOfficeAndDate(office_id, date_from, date_to);
  }
}
