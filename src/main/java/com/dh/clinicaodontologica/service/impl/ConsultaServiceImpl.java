package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.persistence.entities.ConsultaEntity;
import com.dh.clinicaodontologica.persistence.repository.ConsultaRepository;
import com.dh.clinicaodontologica.service.IOdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IOdontoService<ConsultaEntity> {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public ConsultaEntity salvar(ConsultaEntity consulta) {
        return null;
    }

    @Override
    public List<ConsultaEntity> buscarTodos() {
        return null;
    }

    @Override
    public Optional<ConsultaEntity> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean deletar(Integer id) {
        return false;
    }

    @Override
    public ConsultaEntity editar(ConsultaEntity consulta) {
        return null;
    }
}
