package com.dh.clinicaodontologica.persistence.entities;

import com.dh.clinicaodontologica.dto.PacienteDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "pacientes")
@NoArgsConstructor
public class PacienteEntity {

    @Id
    @SequenceGenerator(name= "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "email")
    private String email;

    @Column(name = "idade")
    private Integer idade;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    Set<ConsultaEntity> consultas = new HashSet<>();


    public PacienteEntity(PacienteDTO paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.email = paciente.getEmail();
        this.idade = paciente.getIdade();
        this.endereco = new EnderecoEntity(paciente.getEndereco());
    }

}
