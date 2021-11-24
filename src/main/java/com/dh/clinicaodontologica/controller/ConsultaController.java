package com.dh.clinicaodontologica.controller;


import com.dh.clinicaodontologica.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;
}
