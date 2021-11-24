package com.dh.clinicaodontologica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "Pacientes")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rg")
    private String rg;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "data_hora")
    private LocalDate dataDeAlta;

    @JoinColumn(name = "endereco_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    Set<ConsultaEntity> consultas = new HashSet<>();
}
