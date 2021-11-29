package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.PacienteDTO;
import com.dh.clinicaodontologica.service.impl.PacienteServiceImpl;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;
    private final Logger log = Logger.getLogger(PacienteController.class);

    @PostMapping("/salvar")
    public ResponseEntity<PacienteDTO> salvarPaciente(@RequestBody PacienteDTO paciente){
        log.info("Registrando um novo paciente.");
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<PacienteDTO>> buscarTodosPacientes(){
        log.info("Listando todos os pacientes.");
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PacienteDTO> buscarPacientePorId(@PathVariable Integer id){
        log.info("Buscando paciente...");
        return ResponseEntity.ok(pacienteService.buscarPorId(id));

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPacientePorId(@PathVariable Integer id){
        log.info("Deletando paciente.");
        boolean deletado = pacienteService.deletar(id);
        return deletado ? ResponseEntity.ok().body("Paciente deletado") : ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar")
    public ResponseEntity<PacienteDTO> atualizarPaciente (@RequestBody PacienteDTO paciente){
        log.info("Atualizando paciente.");
        return ResponseEntity.ok(pacienteService.editar(paciente));
    }
}
