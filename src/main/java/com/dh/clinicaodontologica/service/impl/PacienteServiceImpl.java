package com.dh.clinicaodontologica.service.impl;


import com.dh.clinicaodontologica.dto.PacienteDTO;
import com.dh.clinicaodontologica.persistence.entities.EnderecoEntity;
import com.dh.clinicaodontologica.persistence.entities.PacienteEntity;
import com.dh.clinicaodontologica.persistence.repository.EnderecoRepository;
import com.dh.clinicaodontologica.persistence.repository.PacienteRepository;
import com.dh.clinicaodontologica.service.IOdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PacienteServiceImpl implements IOdontoService<PacienteDTO> {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public PacienteDTO salvar(PacienteDTO paciente) {
        PacienteEntity pacienteEntity = new PacienteEntity(paciente);
        pacienteEntity.setEndereco(enderecoRepository.saveAndFlush(pacienteEntity.getEndereco()));
        return new PacienteDTO(pacienteRepository.save(pacienteEntity));
    }

    @Override
    public List<PacienteDTO> buscarTodos() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public PacienteDTO buscarPorId(Integer id) {
        return new PacienteDTO(pacienteRepository.findById(id).orElse(null));

    }

    @Override
    public boolean deletar(Integer id) {
        if(pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return true;
        };
        return false;
    }

    @Override
    public PacienteDTO editar(PacienteDTO paciente) {
        EnderecoEntity enderecoAtualizado = enderecoRepository.findById(paciente.getEndereco().getId()).orElse(null);
        if(enderecoAtualizado != null){
            if(!paciente.getEndereco().getRua().isEmpty())
                enderecoAtualizado.setRua(paciente.getEndereco().getRua());
            if(paciente.getEndereco().getNumero() != null)
                enderecoAtualizado.setNumero(paciente.getEndereco().getNumero());
            if(!paciente.getEndereco().getCidade().isEmpty())
                enderecoAtualizado.setCidade(paciente.getEndereco().getCidade());
            if(!paciente.getEndereco().getEstado().isEmpty())
                enderecoAtualizado.setEstado(paciente.getEndereco().getEstado());
            enderecoRepository.saveAndFlush(enderecoAtualizado);
        }

        PacienteEntity pacienteAtualizado = pacienteRepository.findById(paciente.getId()).orElse(null);
        if(pacienteAtualizado != null){
            if(!paciente.getNome().isEmpty())
                pacienteAtualizado.setNome(paciente.getNome());
            if(!paciente.getSobrenome().isEmpty())
                pacienteAtualizado.setSobrenome(paciente.getSobrenome());
            if(!paciente.getEmail().isEmpty())
                pacienteAtualizado.setEmail(paciente.getEmail());
            if(paciente.getIdade() !=null)
                pacienteAtualizado.setIdade(paciente.getIdade());
            return new PacienteDTO(pacienteRepository.saveAndFlush(pacienteAtualizado));
        }
        return null;
    }

}
