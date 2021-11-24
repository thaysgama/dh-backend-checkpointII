package com.dh.clinicaodontologica.persistence.repository;

import com.dh.clinicaodontologica.persistence.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {
}
