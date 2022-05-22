package com.sptech.projeto04.entidade;

public class Linha {

    // Atributos
    private String nomeIda;
    private String nomeVolta;
    private Double extensao;
    private Integer veiculos;
    private Boolean funciona24H;

    // Getter's and Setter's
    public String getNomeIda() {
        return nomeIda;
    }

    public void setNomeIda(String nomeIda) {
        this.nomeIda = nomeIda;
    }

    public String getNomeVolta() {
        return nomeVolta;
    }

    public void setNomeVolta(String nomeVolta) {
        this.nomeVolta = nomeVolta;
    }

    public Double getExtensao() {
        return extensao;
    }

    public void setExtensao(Double extensao) {
        this.extensao = extensao;
    }

    public Integer getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Integer veiculos) {
        this.veiculos = veiculos;
    }

    public Boolean getFunciona24H() {
        return funciona24H;
    }

    public void setFunciona24H(Boolean funciona24H) {
        this.funciona24H = funciona24H;
    }
}
