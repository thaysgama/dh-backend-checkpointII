package com.dh.clinicaodontologica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Consultas")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "dentista_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private DentistaEntity dentista;

    @JoinColumn(name = "paciente_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private PacienteEntity paciente;

    @Column(name = "data_hora")
    private LocalDateTime DataHora;

}
