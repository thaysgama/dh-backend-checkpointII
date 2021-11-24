package com.dh.clinicaodontologica.persistence.repository;

import com.dh.clinicaodontologica.persistence.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
}
