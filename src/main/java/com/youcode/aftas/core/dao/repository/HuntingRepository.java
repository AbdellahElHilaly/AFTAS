package com.youcode.aftas.core.dao.repository;

import com.youcode.aftas.core.dao.model.entity.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface HuntingRepository extends JpaRepository<Hunting, UUID>, JpaSpecificationExecutor<Hunting> {
    /*
    example of us of JpaSpecificationExecutor

    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    List<Person> find(@Param("lastName") String lastName);

     */
}