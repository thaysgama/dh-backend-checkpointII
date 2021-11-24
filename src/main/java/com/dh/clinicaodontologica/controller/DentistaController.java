package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.persistence.entities.DentistaEntity;
import com.dh.clinicaodontologica.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping("/salvar")
    public ResponseEntity<DentistaEntity> salvarDentista(@RequestBody DentistaEntity dentista){
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<DentistaEntity>> buscarTodos(){
        return ResponseEntity.ok(dentistaService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<DentistaEntity>> buscarDentistaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(dentistaService.buscarPorId(id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarDentistaPorId(@PathVariable Integer id){
        boolean deletado = dentistaService.deletar(id);
        return deletado ? ResponseEntity.ok().body("Dentista deletado") : ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar/")
    public ResponseEntity<DentistaEntity> atualizarDentista(@RequestBody DentistaEntity dentista){
        return ResponseEntity.ok(dentistaService.editar(dentista));
    }

}
