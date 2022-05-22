package sptech.correcao01.entidade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {

    private String login;
    private String senha;
    private String nome;
    private boolean autenticado;
    private LocalDate nascimento;
    private LocalDateTime ultimoLogon;

    public boolean autenticar(String login, String senha) {
        autenticado = login.equals(this.login) && senha.equals(this.senha);
        if (autenticado) {
            // LocalDateTime.now() - retorna a data e hora atual
            ultimoLogon = LocalDateTime.now();
        }
        return autenticado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDateTime getUltimoLogon() {
        return ultimoLogon;
    }

    public void setUltimoLogon(LocalDateTime ultimoLogon) {
        this.ultimoLogon = ultimoLogon;
    }
}
