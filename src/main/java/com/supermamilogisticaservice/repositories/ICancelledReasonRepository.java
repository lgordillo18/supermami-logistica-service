package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.CancelledReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICancelledReasonRepository extends JpaRepository<CancelledReason, Integer> {
}
