package com.dh.clinicaodontologica.service;

import com.dh.clinicaodontologica.persistence.entities.DentistaEntity;

import java.util.List;
import java.util.Optional;

public interface DentistaService {
    DentistaEntity salvar(DentistaEntity dentista);
    List<DentistaEntity> buscarTodos();
    Optional<DentistaEntity> buscarPorId(Integer id);
    boolean deletar(Integer id);
    DentistaEntity editar(DentistaEntity dentista);
}
