package com.sptech.projetojpa06.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Modelo {

    // Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double potencia;

    @ManyToOne
    @NotNull
    private Fabricante fabricante;

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

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
