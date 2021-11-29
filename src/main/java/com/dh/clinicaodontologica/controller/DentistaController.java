package com.dh.clinicaodontologica.controller;

import com.dh.clinicaodontologica.dto.DentistaDTO;
import com.dh.clinicaodontologica.service.impl.DentistaServiceImpl;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;
    private final Logger log = Logger.getLogger(DentistaController.class);

    @PostMapping("/salvar")
    public ResponseEntity<DentistaDTO> salvarDentista(@RequestBody DentistaDTO dentista){
        log.info("Registrando um novo dentista.");
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<DentistaDTO>> buscarTodosDentistas(){
        log.info("Listando todos os dentistas.");
        List<DentistaDTO> listaDentistas = dentistaService.buscarTodos();
        return ResponseEntity.ok(listaDentistas);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<DentistaDTO> buscarDentistaPorId(@PathVariable Integer id){
        DentistaDTO dentistaDTO = dentistaService.buscarPorId(id);
        log.info("Buscando dentista...");
        if(dentistaDTO != null)
            return ResponseEntity.ok(dentistaDTO);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarDentistaPorId(@PathVariable Integer id){
        log.info("Deletando dentista.");
        boolean deletado = dentistaService.deletar(id);
        return deletado ? ResponseEntity.ok().body("Dentista deletado") : ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar")
    public ResponseEntity<DentistaDTO> atualizarDentista(@RequestBody DentistaDTO dentista){
        log.info("Atualizando dentista.");
        if(dentistaService.buscarPorId(dentista.getId()) != null)
            return ResponseEntity.ok(dentistaService.editar(dentista));
        return ResponseEntity.notFound().build();
    }

}
