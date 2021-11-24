package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.persistence.entities.EnderecoEntity;
import com.dh.clinicaodontologica.persistence.repository.EnderecoRepository;
import com.dh.clinicaodontologica.service.IOdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements IOdontoService<EnderecoEntity> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoEntity salvar(EnderecoEntity endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public List<EnderecoEntity> buscarTodos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Optional<EnderecoEntity> buscarPorId(Integer id) {
        return enderecoRepository.findById(id);
    }

    @Override
    public boolean deletar(Integer id) {
        if(enderecoRepository.findById(id).isPresent()){
            enderecoRepository.deleteById(id);
            return true;
        };
        return false;
    }

    @Override
    public EnderecoEntity editar(EnderecoEntity endereco) {
        Optional<EnderecoEntity> optionalEndereco = enderecoRepository.findById(endereco.getId());
        EnderecoEntity enderecoAtualizado = optionalEndereco.orElse(null);
        if(enderecoAtualizado != null){
            if(!endereco.getRua().isEmpty())
                enderecoAtualizado.setRua(endereco.getRua());
            if(endereco.getNumero() != null)
                enderecoAtualizado.setNumero(endereco.getNumero());
            if(!endereco.getCidade().isEmpty())
                enderecoAtualizado.setCidade(endereco.getCidade());
            if(!endereco.getEstado().isEmpty())
                enderecoAtualizado.setEstado(endereco.getEstado());
            return enderecoRepository.saveAndFlush(enderecoAtualizado);
        }
        return null;
    }
}
