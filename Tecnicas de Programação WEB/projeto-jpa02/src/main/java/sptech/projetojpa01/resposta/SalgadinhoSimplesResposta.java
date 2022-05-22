package sptech.projetojpa01.resposta;

import sptech.projetojpa01.entidade.Salgadinho;

/*
Esta classe é uma classe do tipo DTO
Data Transfer Object
 */
public class SalgadinhoSimplesResposta {

    private Long codigo; // ou Integer
    private String nome;

    public SalgadinhoSimplesResposta(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    // criar somente getters SEM setters
    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
