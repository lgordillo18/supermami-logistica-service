package com.supermamilogisticaservice.repositories;

        import com.supermamilogisticaservice.models.VehicleStatus;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;


@Repository
public interface IStatusRepository extends JpaRepository<VehicleStatus, Integer> {
}