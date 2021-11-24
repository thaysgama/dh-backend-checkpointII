package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.persistence.entities.DentistaEntity;
import com.dh.clinicaodontologica.persistence.repository.DentistaRepository;
import com.dh.clinicaodontologica.service.IOdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistaServiceImpl implements IOdontoService<DentistaEntity> {

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public DentistaEntity salvar(DentistaEntity dentista) {
        return dentistaRepository.save(dentista);
    }

    @Override
    public List<DentistaEntity> buscarTodos() {
        return dentistaRepository.findAll();
    }

    @Override
    public Optional<DentistaEntity> buscarPorId(Integer id) {
        return dentistaRepository.findById(id);
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
    public DentistaEntity editar(DentistaEntity dentista) {
        Optional<DentistaEntity> optionalDentista = dentistaRepository.findById(dentista.getId());
        DentistaEntity dentistaAtualizado = optionalDentista.orElse(null);
        if(dentistaAtualizado != null){
            if(dentista.getNumMatricula()!=null)
                dentistaAtualizado.setNumMatricula(dentista.getNumMatricula());
            if(!dentista.getNome().isEmpty())
                dentistaAtualizado.setNome(dentista.getNome());
            if(!dentista.getSobrenome().isEmpty())
                dentistaAtualizado.setSobrenome(dentista.getSobrenome());
            return dentistaRepository.saveAndFlush(dentistaAtualizado);
        }
        return null;
    }
}
