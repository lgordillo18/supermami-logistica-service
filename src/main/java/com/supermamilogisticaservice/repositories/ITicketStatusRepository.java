package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketStatusRepository extends JpaRepository<TicketStatus, Integer> {

}
