package com.dh.clinicaodontologica.dto;

import com.dh.clinicaodontologica.persistence.entities.PacienteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PacienteDTO {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;
    private EnderecoDTO endereco;

    public PacienteDTO(PacienteEntity paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.email = paciente.getEmail();
        this.idade = paciente.getIdade();
        this.endereco = new EnderecoDTO(paciente.getEndereco());
    }

}
