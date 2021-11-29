package com.dh.clinicaodontologica.dto;

import com.dh.clinicaodontologica.persistence.entities.EnderecoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class EnderecoDTO {
    private Integer id;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;


    public EnderecoDTO(EnderecoEntity endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }
}
