package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.persistence.entities.EnderecoEntity;
import com.dh.clinicaodontologica.persistence.entities.PacienteEntity;
import com.dh.clinicaodontologica.persistence.repository.PacienteRepository;
import com.dh.clinicaodontologica.service.IOdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IOdontoService<PacienteEntity> {

    @Autowired
    private PacienteRepository pacienteRepository;
    private EnderecoServiceImpl enderecoService;

    @Override
    public PacienteEntity salvar(PacienteEntity paciente) {
        enderecoService.salvar(paciente.getEndereco());
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<PacienteEntity> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<PacienteEntity> buscarPorId(Integer id) {
        return pacienteRepository.findById(id);
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
    public PacienteEntity editar(PacienteEntity paciente) {
        enderecoService.editar(paciente.getEndereco());
        Optional<PacienteEntity> optionalPaciente = pacienteRepository.findById(paciente.getId());
        PacienteEntity pacienteAtualizado = optionalPaciente.orElse(null);
        if(pacienteAtualizado != null){
            if(!paciente.getNome().isEmpty())
                pacienteAtualizado.setNome(paciente.getNome());
            if(!paciente.getSobrenome().isEmpty())
                pacienteAtualizado.setSobrenome(paciente.getSobrenome());
            if(paciente.getDataDeAlta() != null)
                pacienteAtualizado.setDataDeAlta(paciente.getDataDeAlta());
            if(!paciente.getRg().isEmpty())
                pacienteAtualizado.setRg(paciente.getRg());
            return pacienteRepository.saveAndFlush(pacienteAtualizado);
        }
        return null;
    }
}
