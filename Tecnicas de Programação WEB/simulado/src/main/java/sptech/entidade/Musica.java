package sptech.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class Musica {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMusica;

    @NotBlank
    private String cantor;

    @NotBlank
    private String nome;

    @Max(100)
    @NotNull
    private Integer posicaoTopGlobal;

    @PastOrPresent
    private LocalDate dataLancamento;

    public Long getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(Long idMusica) {
        this.idMusica = idMusica;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPosicaoTopGlobal() {
        return posicaoTopGlobal;
    }

    public void setPosicaoTopGlobal(Integer posicaoTopGlobal) {
        this.posicaoTopGlobal = posicaoTopGlobal;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
