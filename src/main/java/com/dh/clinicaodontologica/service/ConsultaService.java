package com.dh.clinicaodontologica.service;

import com.dh.clinicaodontologica.persistence.entities.ConsultaEntity;

import java.util.List;
import java.util.Optional;

public interface ConsultaService {
    ConsultaEntity salvar(ConsultaEntity consulta);
    List<ConsultaEntity> buscarTodos();
    Optional<ConsultaEntity> buscarPorId(Integer id);
    boolean deletar(Integer id);
    ConsultaEntity editar(ConsultaEntity consulta);
}
