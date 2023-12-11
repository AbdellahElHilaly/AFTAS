package com.youcode.aftas.core.dao.repository;

import com.youcode.aftas.core.dao.model.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, UUID>  {

//JpaSpecificationExecutor we use it to make a dynamic query with the help of Specification class
//    like orderBy, where, groupBy, having, join, etc.
}
