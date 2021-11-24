package com.dh.clinicaodontologica.persistence.repository;

import com.dh.clinicaodontologica.persistence.entities.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<DentistaEntity, Integer> {
}
