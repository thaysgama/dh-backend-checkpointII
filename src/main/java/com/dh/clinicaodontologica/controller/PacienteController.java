package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.persistence.entities.PacienteEntity;
import com.dh.clinicaodontologica.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping("/salvar")
    public ResponseEntity<PacienteEntity> salvarPaciente(@RequestBody PacienteEntity paciente){
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<PacienteEntity>> buscarTodosPacientes(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<PacienteEntity>> buscarPacientePorId(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPacientePorId(@PathVariable Integer id){
        boolean deletado = pacienteService.deletar(id);
        return deletado ? ResponseEntity.ok().body("Paciente deletado") : ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar/")
    public ResponseEntity<PacienteEntity> atualizarPaciente (@RequestBody PacienteEntity paciente){
        return ResponseEntity.ok(pacienteService.editar(paciente));
    }
}
