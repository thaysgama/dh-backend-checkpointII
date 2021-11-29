package com.dh.clinicaodontologica.persistence.entities;

import com.dh.clinicaodontologica.dto.DentistaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "dentistas")
@NoArgsConstructor
public class DentistaEntity {

    @Id
    @SequenceGenerator(name= "dentista_sequence", sequenceName = "dentista_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentista_sequence")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "numero_matricula")
    private Integer numMatricula;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @OneToMany(mappedBy = "dentista", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    Set<ConsultaEntity> consultas = new HashSet<>();

    public DentistaEntity(DentistaDTO dentista) {
        this.id = dentista.getId();
        this.numMatricula = dentista.getNumMatricula();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
    }

}
