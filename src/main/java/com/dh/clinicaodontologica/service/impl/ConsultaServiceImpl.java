package com.dh.clinicaodontologica.service.impl;

import com.dh.clinicaodontologica.dto.ConsultaDTO;
import com.dh.clinicaodontologica.dto.DentistaDTO;
import com.dh.clinicaodontologica.dto.PacienteDTO;
import com.dh.clinicaodontologica.persistence.entities.ConsultaEntity;
import com.dh.clinicaodontologica.persistence.entities.DentistaEntity;
import com.dh.clinicaodontologica.persistence.entities.PacienteEntity;
import com.dh.clinicaodontologica.persistence.repository.ConsultaRepository;
import com.dh.clinicaodontologica.service.IOdontoService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ConsultaServiceImpl implements IOdontoService<ConsultaDTO> {

    @Autowired
    private ConsultaRepository consultaRepository;
    Logger log = Logger.getLogger(ConsultaServiceImpl.class);

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Override
    public ConsultaDTO salvar(ConsultaDTO consultaDTO) {
        log.info("Registrando uma nova consulta.");
        DentistaDTO dentistaDTO = dentistaService.buscarPorId(consultaDTO.getDentista().getId());
        PacienteDTO pacienteDTO = pacienteService.buscarPorId(consultaDTO.getPaciente().getId());
        consultaDTO.setDentista(dentistaDTO);
        consultaDTO.setPaciente(pacienteDTO);
        ConsultaEntity consultaEntity = new ConsultaEntity(consultaDTO);
        return new ConsultaDTO(consultaRepository.saveAndFlush(consultaEntity));
    }

    @Override
    public List<ConsultaDTO> buscarTodos() {
        log.info("Listando todas as consultas.");
        return consultaRepository.findAll()
                .stream()
                .map(ConsultaDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultaDTO buscarPorId(Integer id) {
        log.info("Buscando consulta...");
        ConsultaEntity consulta = consultaRepository.findById(id).orElse(null);
        return consulta !=null ? new ConsultaDTO(consulta) : null;
    }

    @Override
    public boolean deletar(Integer id) {
        log.info("Deletando consulta.");
        if(consultaRepository.findById(id).isPresent()){
            consultaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ConsultaDTO editar(ConsultaDTO consulta) {
        log.info("Atualizando consulta.");
        ConsultaEntity consultaAtualizada = consultaRepository.findById(consulta.getId()).orElse(null);
        if(consultaAtualizada!=null){
            DentistaDTO dentistaDTO = dentistaService.buscarPorId(consulta.getDentista().getId());
            PacienteDTO pacienteDTO = pacienteService.buscarPorId(consulta.getPaciente().getId());
            if(pacienteDTO != null && dentistaDTO!=null && consulta.getDataHora()!=null){
                if(!consultaAtualizada.getDentista().getId().equals(consulta.getDentista().getId())){
                    consultaAtualizada.setDentista(new DentistaEntity(dentistaDTO));
                }
                if(!consultaAtualizada.getPaciente().getId().equals(consulta.getPaciente().getId())){
                    consultaAtualizada.setPaciente(new PacienteEntity(pacienteDTO));
                }
                if(!consultaAtualizada.getDataHora().equals(consulta.getDataHora())){
                    consultaAtualizada.setDataHora(consulta.getDataHora());
                }
                return new ConsultaDTO(consultaRepository.saveAndFlush(consultaAtualizada));
            }
        }
        return null;
    }
}
