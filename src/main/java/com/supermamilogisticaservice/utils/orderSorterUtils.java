package com.supermamilogisticaservice.utils;


import com.supermamilogisticaservice.models.OrderTicket;
import com.supermamilogisticaservice.repositories.IOrderTicketRepository;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.*;

public class orderSorterUtils {
   //Sorting tickets
   public static List<OrderTicket> getSortedList(Map<String, String> params, IOrderTicketRepository repository) throws NotFoundException {
      List<OrderTicket> sortedList = new ArrayList<>();
      String ticketNumber = params.get("tickernumber");
      String fecha = params.getOrDefault("numer", "");
      String ticketStatus = params.getOrDefault("ticketStatus", "");
      sortedList = getSortedListWithParams(repository, fecha, ticketNumber, ticketStatus);

      if(sortedList.size() == 0) throw new NotFoundException("404 Not Found");
      return sortedList;
   }

   private static List<OrderTicket> getSortedListWithParams(IOrderTicketRepository repository, String fecha, String ticketNumber, String ticketStatus){
      if(ticketNumber.equals("") && ticketStatus.equals("")) {
         return repository.findTicketByIdAsc(ticketNumber);
      }
      return getPendingTicketsByIdNumber(repository, fecha, ticketStatus, ticketNumber);

   }

   //mostrar el ultimo pedido cargado
   public static List<OrderTicket> getPendingTicketsByIdNumber(IOrderTicketRepository repository, String fecha, String ticket_status, String ticketNumber) {
      if (ticket_status.equals("2")) return repository.findTicketByIdDesc(ticketNumber);
      return repository.findTicketByIdAsc(ticketNumber);
   }

   private static List<OrderTicket> getSortedByStatus(Map<String, String> params, IOrderTicketRepository repository, String ticketNumber) throws IOException{
      if(params.size() == 0) return repository.findAll();

      String query = params.get("query");
      String ticket = params.getOrDefault("ticket", "1");

      switch(query){
         case "1":
            return repository.findTicketByIdDesc(ticketNumber);
         case "2":
         case "3":
            return repository.findTicketByIdAsc(ticketNumber);
         case "4":
         case "5":
            return repository.findAll();
      }
      return null;
   }

}
