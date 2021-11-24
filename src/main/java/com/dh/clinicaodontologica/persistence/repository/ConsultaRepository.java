package com.dh.clinicaodontologica.persistence.repository;

import com.dh.clinicaodontologica.persistence.entities.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Integer> {
}
