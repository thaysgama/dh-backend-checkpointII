package com.dh.clinicaodontologica.service;

import com.dh.clinicaodontologica.persistence.entities.PacienteEntity;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    PacienteEntity salvar(PacienteEntity paciente);
    List<PacienteEntity> buscarTodos();
    Optional<PacienteEntity> buscarPorId(Integer id);
    boolean deletar(Integer id);
    PacienteEntity editar(PacienteEntity paciente);

}
