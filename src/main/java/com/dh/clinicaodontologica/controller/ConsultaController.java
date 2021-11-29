package com.dh.clinicaodontologica.controller;


import com.dh.clinicaodontologica.dto.ConsultaDTO;
import com.dh.clinicaodontologica.service.impl.ConsultaServiceImpl;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;
    private final Logger log = Logger.getLogger(ConsultaController.class);


    @PostMapping("/salvar")
    public ResponseEntity<ConsultaDTO> salvarConsulta(@RequestBody ConsultaDTO consultaDTO){
        log.info("Registrando uma nova consulta.");
        return ResponseEntity.ok(consultaService.salvar(consultaDTO));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<ConsultaDTO>> buscarTodasConsultas(){
        log.info("Listando todas as consultas.");
        List<ConsultaDTO> listaConsultas = consultaService.buscarTodos();
        return ResponseEntity.ok(listaConsultas);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ConsultaDTO> buscarConsultaPorId(@PathVariable Integer id){
        ConsultaDTO consultaDTO = consultaService.buscarPorId(id);
        log.info("Buscando consulta...");
        if(consultaDTO != null)
            return ResponseEntity.ok(consultaDTO);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarConsultaPorId(@PathVariable Integer id){
        log.info("Deletando consulta.");
        boolean deletado = consultaService.deletar(id);
        return deletado ? ResponseEntity.ok().body("Consulta deletada") : ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ConsultaDTO> atualizarConsulta(@RequestBody ConsultaDTO consulta){
        log.info("Atualizando consulta.");
        if(consultaService.buscarPorId(consulta.getId()) != null)
            return ResponseEntity.ok(consultaService.editar(consulta));
        return ResponseEntity.notFound().build();
    }

}
