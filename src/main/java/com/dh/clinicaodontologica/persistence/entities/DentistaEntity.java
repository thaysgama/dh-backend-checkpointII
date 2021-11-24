package com.dh.clinicaodontologica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Dentistas")
public class DentistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "numero_matricula")
    private Integer numMatricula;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @OneToMany(mappedBy = "dentista", fetch = FetchType.LAZY)
    Set<ConsultaEntity> consultas = new HashSet<>();

}
