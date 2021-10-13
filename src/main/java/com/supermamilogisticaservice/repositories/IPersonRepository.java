package com.supermamilogisticaservice.repositories;

import com.supermamilogisticaservice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
}