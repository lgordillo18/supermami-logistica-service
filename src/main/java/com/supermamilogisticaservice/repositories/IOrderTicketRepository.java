package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.dtos.ProductListDto;
import com.supermamilogisticaservice.interfaces.IOrdersByDealerList;
import com.supermamilogisticaservice.interfaces.IProductList;
import com.supermamilogisticaservice.interfaces.ITicketStatusByOffice;
import com.supermamilogisticaservice.models.Employee;
import com.supermamilogisticaservice.models.Office;
import com.supermamilogisticaservice.models.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderTicketRepository extends JpaRepository<OrderTicket, Integer>{
  List<OrderTicket> findByEmployee(Optional<Employee> employee);

  @Query("SELECT new com.supermamilogisticaservice.dtos.ProductListDto(p.code, p.name, SUM(otd.quantity)) " +
          "FROM OrderTicketDetail otd JOIN Product p ON p.id = otd.product.id " +
          "GROUP BY p.code, p.name ORDER BY SUM(otd.quantity) DESC")
  List<ProductListDto> findTop10Products();

  @Query(value = "SELECT p.codigo AS code, p.nombre AS name, s.nombre AS office, SUM(otd.cantidad) AS total " +
          "FROM \"DetallePedidos\" otd " +
          "JOIN \"Productos\" p ON p.id = otd.product_id " +
          "JOIN \"Pedidos\" ot ON ot.id = otd.pedido_id " +
          "JOIN \"Sucursales\" s ON s.id = ot.office_id " +
          "WHERE ot.office_id = ?1 " +
          "GROUP BY p.codigo, p.nombre, s.nombre " +
          "ORDER BY SUM(otd.cantidad) DESC ",
          nativeQuery = true)
  List<IProductList> findTop10ProductsByOffice(int office_id);

  @Query(value = "SELECT p.codigo AS code, p.nombre AS name, s.nombre AS office, SUM(otd.cantidad) AS total " +
          "FROM \"DetallePedidos\" otd " +
          "JOIN \"Productos\" p ON p.id = otd.product_id " +
          "JOIN \"Pedidos\" ot ON ot.id = otd.pedido_id " +
          "JOIN \"Sucursales\" s ON s.id = ot.office_id " +
          "WHERE ot.office_id = ?1 " +
          "AND ot.fecha BETWEEN cast(?2 as date) AND cast(?3 as date) " +
          "GROUP BY p.codigo, p.nombre, s.nombre " +
          "ORDER BY SUM(otd.cantidad) DESC ",
          nativeQuery = true)
  List<IProductList> findTop10ProductsByOfficeAndDate(int office_id, String date_from, String date_to);

  @Query(value = "SELECT p.codigo AS code, p.nombre AS name, s.nombre AS office, SUM(otd.cantidad) AS total " +
          "FROM \"DetallePedidos\" otd " +
          "JOIN \"Productos\" p ON p.id = otd.product_id " +
          "JOIN \"Pedidos\" ot ON ot.id = otd.pedido_id " +
          "JOIN \"Sucursales\" s ON s.id = ot.office_id " +
          "WHERE ot.fecha BETWEEN cast(?1 as date) AND cast(?2 as date) " +
          "GROUP BY p.codigo, p.nombre, s.nombre " +
          "ORDER BY SUM(otd.cantidad) DESC ",
          nativeQuery = true)
  List<IProductList> findTop10ProductsByDate(String date_from, String date_to);

  @Query(value = "SELECT per.nombre as firstName, per.apellido as lastName, s.nombre as office, COUNT(p.id) as total " +
          "FROM \"Pedidos\" p " +
          "JOIN \"EstadoTickets\" et on et.id = p.ticket_status_id " +
          "JOIN \"Empleados\" e on e.id = p.assigned_employee_id " +
          "JOIN \"Personas\" per on per.id = e.id " +
          "JOIN \"Sucursales\" s on s.id = p.office_id " +
          "WHERE et.nombre = 'entregado' " +
          "AND p.office_id = ?1 " +
          "GROUP BY per.nombre, per.apellido, s.nombre " +
          "ORDER BY total DESC ",
          nativeQuery = true)
  List<IOrdersByDealerList> findOrdersByDealerByOffice(int office_id);

  @Query(value = "SELECT per.nombre as firstName, per.apellido as lastName, s.nombre as office, COUNT(p.id) as total " +
          "FROM \"Pedidos\" p " +
          "JOIN \"EstadoTickets\" et on et.id = p.ticket_status_id " +
          "JOIN \"Empleados\" e on e.id = p.assigned_employee_id " +
          "JOIN \"Personas\" per on per.id = e.id " +
          "JOIN \"Sucursales\" s on s.id = p.office_id " +
          "WHERE et.nombre = 'entregado' " +
          "AND p.office_id = ?1 " +
          "AND p.fecha BETWEEN cast(?2 as date) AND cast(?3 as date) " +
          "GROUP BY per.nombre, per.apellido, s.nombre " +
          "ORDER BY total DESC ",
          nativeQuery = true)
  List<IOrdersByDealerList> findOrdersByDealerByOfficeAndDate(int office_id, String date_from, String date_to);

  @Query(value = "SELECT per.nombre as firstName, per.apellido as lastName, s.nombre as office, COUNT(p.id) as total " +
          "FROM \"Pedidos\" p " +
          "JOIN \"EstadoTickets\" et on et.id = p.ticket_status_id " +
          "JOIN \"Empleados\" e on e.id = p.assigned_employee_id " +
          "JOIN \"Personas\" per on per.id = e.id " +
          "JOIN \"Sucursales\" s on s.id = p.office_id " +
          "WHERE et.nombre = 'entregado' " +
          "AND p.fecha BETWEEN cast(?1 as date) AND cast(?2 as date) " +
          "GROUP BY per.nombre, per.apellido, s.nombre " +
          "ORDER BY total DESC ",
          nativeQuery = true)
  List<IOrdersByDealerList> findOrdersByDealerByDate(String date_from, String date_to);

  @Query(value = "SELECT s.nombre AS office, et.nombre AS status, COUNT(p.id) AS total " +
          "FROM \"Pedidos\" p " +
          "JOIN \"EstadoTickets\" et on et.id = p.ticket_status_id " +
          "JOIN \"Sucursales\" s on s.id = p.office_id " +
          "GROUP BY s.nombre, et.nombre " +
          "ORDER BY s.nombre ASC, total DESC ",
          nativeQuery = true)
  List<ITicketStatusByOffice> findTicketStatusByOffice();

  @Query(value = "SELECT s.nombre AS office, et.nombre AS status, COUNT(p.id) AS total " +
          "FROM \"Pedidos\" p " +
          "JOIN \"EstadoTickets\" et on et.id = p.ticket_status_id " +
          "JOIN \"Sucursales\" s on s.id = p.office_id " +
          "WHERE p.office_id = ?1 " +
          "GROUP BY s.nombre, et.nombre " +
          "ORDER BY s.nombre ASC, total DESC ",
          nativeQuery = true)
  List<ITicketStatusByOffice> findTicketStatusByOfficeFilteredByOffice(int office_id);

  @Query(value = "SELECT s.nombre AS office, et.nombre AS status, COUNT(p.id) AS total " +
          "FROM \"Pedidos\" p " +
          "JOIN \"EstadoTickets\" et on et.id = p.ticket_status_id " +
          "JOIN \"Sucursales\" s on s.id = p.office_id " +
          "WHERE p.fecha BETWEEN cast(?1 as date) AND cast(?2 as date) " +
          "GROUP BY s.nombre, et.nombre " +
          "ORDER BY s.nombre ASC, total DESC ",
          nativeQuery = true)
  List<ITicketStatusByOffice> findTicketStatusByOfficeFilteredByDate(String date_from, String date_to);

  @Query(value = "SELECT s.nombre AS office, et.nombre AS status, COUNT(p.id) AS total " +
          "FROM \"Pedidos\" p " +
          "JOIN \"EstadoTickets\" et on et.id = p.ticket_status_id " +
          "JOIN \"Sucursales\" s on s.id = p.office_id " +
          "WHERE p.office_id = ?1 " +
          "AND p.fecha BETWEEN cast(?2 as date) AND cast(?3 as date) " +
          "GROUP BY s.nombre, et.nombre " +
          "ORDER BY s.nombre ASC, total DESC ",
          nativeQuery = true)
  List<ITicketStatusByOffice> findTicketStatusByOfficeFilteredByOfficeAndDate(int office_id, String date_from, String date_to);

  @Query("SELECT o FROM OrderTicket o JOIN Employee e ON e.id = o.assigned_employee.id WHERE o.assigned_employee = ?1")
  List<OrderTicket> findByAssigned_employee(Optional<Employee> assigned_employee);

  @Query("SELECT o FROM OrderTicket o WHERE o.ticket_status.id = ?1")
  List<OrderTicket> findAllByTicketStatusId(int ticket_status_id);

  /*@Query("SELECT o FROM OrderTicket o WHERE CAST(o.date as date) BETWEEN ?1 AND ?2")*/
  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.fecha BETWEEN cast(?1 as date) AND cast(?2 as date) ",
          nativeQuery = true)
  List<OrderTicket> findAllByDate(String date_from, String date_to);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.ticket_status_id = ?1 " +
          "AND p.fecha BETWEEN cast(?2 as date) AND cast(?3 as date) ",
          nativeQuery = true)
  List<OrderTicket> findAllByTicketStatusIdAndDate(int ticket_status_id, String date_from, String date_to);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.employee_id = ?1 " +
          "AND p.origin_office_id = ?2 ",
          nativeQuery = true)
  List<OrderTicket> findByEmployeeAndOfficeId(int employee_id, int origin_office_id);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.employee_id = ?1 " +
          "AND p.fecha BETWEEN cast(?1 as date) AND cast(?2 as date) ",
          nativeQuery = true)
  List<OrderTicket> findByEmployeeAndDate(int employee_id, String date_from, String date_to);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.employee_id = ?1 " +
          "AND p.origin_office_id = ?2 " +
          "AND p.fecha BETWEEN cast(?3 as date) AND cast(?4 as date) ",
          nativeQuery = true)
  List<OrderTicket> findByEmployeeAndOfficeIdAndDate(int employee_id, int origin_office_id, String date_from, String date_to);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.assigned_employee_id = ?1 " +
          "AND p.office_id = ?2 ",
          nativeQuery = true)
  List<OrderTicket> findByDealerAndOfficeId(int employee_id, int office_id);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.assigned_employee_id = ?1 " +
          "AND p.fecha BETWEEN cast(?1 as date) AND cast(?2 as date) ",
          nativeQuery = true)
  List<OrderTicket> findByDealerAndDate(int employee_id, String date_from, String date_to);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.assigned_employee_id = ?1 " +
          "AND p.office_id = ?2 " +
          "AND p.fecha BETWEEN cast(?3 as date) AND cast(?4 as date) ",
          nativeQuery = true)
  List<OrderTicket> findByDealerAndOfficeIdAndDate(int employee_id, int office_id, String date_from, String date_to);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.office_id = ?1 " +
          "AND p.origin_office_id = ?2 ",
          nativeQuery = true)
  List<OrderTicket> findByOfficeAndOriginOfficeId(int office_id, int origin_office_id);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.office_id = ?1 " +
          "AND p.fecha BETWEEN cast(?1 as date) AND cast(?2 as date) ",
          nativeQuery = true)
  List<OrderTicket> findByOfficeAndDate(int office_id, String date_from, String date_to);

  @Query(value = "SELECT * " +
          "FROM \"Pedidos\" p " +
          "WHERE p.office_id = ?1 " +
          "AND p.origin_office_id = ?2 " +
          "AND p.fecha BETWEEN cast(?3 as date) AND cast(?4 as date) ",
          nativeQuery = true)
  List<OrderTicket> findByOfficeAndOriginOfficeIdAndDate(int office_id, int origin_office_id, String date_from, String date_to);

  //TODO: crear endpoint ticket por sucursal
  List<OrderTicket> findByOffice(Optional<Office> office);
}