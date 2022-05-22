package sptech.projetojpa01.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Salgadinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank // do javax.validation
    private String nome;

    @NotNull // do javax.validation
    private Integer nivelSal;

    @Positive
    private Double preco;

    private Boolean apimentado;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivelSal() {
        return nivelSal;
    }

    public void setNivelSal(Integer nivelSal) {
        this.nivelSal = nivelSal;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getApimentado() {
        return apimentado;
    }

    public void setApimentado(Boolean apimentado) {
        this.apimentado = apimentado;
    }


}
