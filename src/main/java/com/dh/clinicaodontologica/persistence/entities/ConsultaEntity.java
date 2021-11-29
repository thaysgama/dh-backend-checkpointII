package com.dh.clinicaodontologica.persistence.entities;

import com.dh.clinicaodontologica.dto.ConsultaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "consultas")
@NoArgsConstructor
public class ConsultaEntity {

    @Id
    @SequenceGenerator(name= "consulta_sequence", sequenceName = "consulta_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "dentista_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private DentistaEntity dentista;

    @JoinColumn(name = "paciente_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PacienteEntity paciente;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;


    public ConsultaEntity(ConsultaDTO consulta) {
        this.id = consulta.getId();
        this.dentista = new DentistaEntity(consulta.getDentista());
        this.paciente = new PacienteEntity(consulta.getPaciente());
        this.dataHora = consulta.getDataHora();
    }
}
