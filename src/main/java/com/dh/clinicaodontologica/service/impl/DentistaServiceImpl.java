package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.DentistaDTO;
import com.dh.clinicaodontologica.persistence.entities.DentistaEntity;
import com.dh.clinicaodontologica.persistence.repository.DentistaRepository;
import com.dh.clinicaodontologica.service.IOdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistaServiceImpl implements IOdontoService<DentistaDTO> {

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public DentistaDTO salvar(DentistaDTO dentista) {
        return new DentistaDTO(dentistaRepository.save(new DentistaEntity(dentista)));
    }

    @Override
    public List<DentistaDTO> buscarTodos() {
        return dentistaRepository.findAll()
                .stream()
                .map(DentistaDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public DentistaDTO buscarPorId(Integer id) {
        DentistaEntity dentista = dentistaRepository.findById(id).orElse(null);
        return dentista !=null ? new DentistaDTO(dentista) : null;
    }

    @Override
    public boolean deletar(Integer id) {
        if(dentistaRepository.findById(id).isPresent()){
            dentistaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public DentistaDTO editar(DentistaDTO dentista) {
        DentistaEntity dentistaAtualizado = dentistaRepository.findById(dentista.getId()).orElse(null);
        if(dentistaAtualizado != null){
            if(dentista.getNumMatricula()!=null)
                dentistaAtualizado.setNumMatricula(dentista.getNumMatricula());
            if(!dentista.getNome().isEmpty())
                dentistaAtualizado.setNome(dentista.getNome());
            if(!dentista.getSobrenome().isEmpty())
                dentistaAtualizado.setSobrenome(dentista.getSobrenome());
            return new DentistaDTO(dentistaRepository.saveAndFlush(dentistaAtualizado));
        }
        return null;
    }
}
