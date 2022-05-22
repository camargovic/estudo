package com.sptech.provac1.controle;

import com.sptech.provac1.entidade.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @PostMapping
    public String postUsuario(@RequestBody Usuario novoUsuario) {
        usuarios.add(novoUsuario);
        return "Usuario " + novoUsuario.getNome() + " cadastrado no sistema";
    }


    @PostMapping("/autenticacao/{login}/{senha}")
    public void autenticacaoUsuario(@PathVariable String login, @PathVariable String senha) {
        Boolean autenticado = false;
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                System.out.println("Usuario " + u.getNome() + " agora está autenticado");
               u.setAutenticado(true);
            } else {
                System.out.println("Usuario " + u.getLogin() + " não encontrado");
            }
        }
    }

    @DeleteMapping("/autenticacao/{login}")
    public void removerPorLogin(@PathVariable int login){
        Boolean autenticado = true;
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login)) {
                System.out.println("Usuario " + u.getNome() + " agora está autenticado");
                u.setAutenticado(false);
            } else {
                System.out.println("Usuario " + u.getLogin() + " não encontrado");
            }
        }
    }
}
