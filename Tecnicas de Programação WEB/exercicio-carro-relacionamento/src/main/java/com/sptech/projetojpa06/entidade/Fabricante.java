package com.sptech.projetojpa06.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Fabricante {

    // Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @NotNull
    private Pais pais;

    // Getter's and Setter's
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
