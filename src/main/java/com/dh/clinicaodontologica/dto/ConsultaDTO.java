package com.dh.clinicaodontologica.dto;


import com.dh.clinicaodontologica.persistence.entities.ConsultaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class ConsultaDTO {

    private Integer id;
    private DentistaDTO dentista;
    private PacienteDTO paciente;
    private LocalDateTime dataHora;


    public ConsultaDTO(ConsultaEntity consulta) {
        this.id = consulta.getId();
        this.dentista = new DentistaDTO(consulta.getDentista());
        this.paciente = new PacienteDTO(consulta.getPaciente());
        this.dataHora = consulta.getDataHora();
    }
}
