package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.RejectedReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRejectedReasonRepository extends JpaRepository<RejectedReason, Integer> {
}
