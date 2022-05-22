package sptech.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoFilme;

    @NotBlank
    @Size(min = 2, max = 30)
    private String nome;

    @PastOrPresent
    private LocalDate anoLancamento;

    @NotNull
    @PositiveOrZero
    @Max(5)
    private Double nota;

    public Long getCodigoFilme() {
        return codigoFilme;
    }

    public void setCodigoFilme(Long codigoFilme) {
        this.codigoFilme = codigoFilme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(LocalDate anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
