package com.sptech.projetojpa06.resposta;

public class ModeloSimplesResposta {

    // Atributos
    private Long codigo;
    private String modelo;
    private String fabricante;
    private String pais;

    // Contrutor
    public ModeloSimplesResposta(Long codigo, String modelo, String fabricante, String pais) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.pais = pais;
    }

    // Getter's
    public Long getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getPais() {
        return pais;
    }
}
