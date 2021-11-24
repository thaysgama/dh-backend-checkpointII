package com.dh.clinicaodontologica.service;

import com.dh.clinicaodontologica.persistence.entities.EnderecoEntity;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {
    EnderecoEntity salvar(EnderecoEntity endereco);
    List<EnderecoEntity> buscarTodos();
    Optional<EnderecoEntity> buscarPorId(Integer id);
    boolean deletar(Integer id);
    EnderecoEntity editar(EnderecoEntity endereco);
}
