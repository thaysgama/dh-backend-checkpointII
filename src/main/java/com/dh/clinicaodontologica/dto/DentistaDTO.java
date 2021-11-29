package com.dh.clinicaodontologica.dto;

import com.dh.clinicaodontologica.persistence.entities.DentistaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DentistaDTO {
    private Integer id;
    private Integer numMatricula;
    private String nome;
    private String sobrenome;


    public DentistaDTO(DentistaEntity dentista) {
        this.id = dentista.getId();
        this.numMatricula = dentista.getNumMatricula();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
    }
}
