package com.dh.clinicaodontologica.persistence.entities;

import com.dh.clinicaodontologica.dto.EnderecoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "enderecos")
@NoArgsConstructor
public class EnderecoEntity {

    @Id
    @SequenceGenerator(name= "endereco_sequence", sequenceName = "endereco_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;


    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
    }

}
