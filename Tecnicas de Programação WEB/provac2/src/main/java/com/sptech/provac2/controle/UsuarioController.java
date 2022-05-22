package com.sptech.provac2.controle;

import com.sptech.provac2.entidade.Usuario;
import com.sptech.provac2.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity postUsuario(@RequestBody @Valid Usuario novoUsuario) {
        repository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticacao/{login}/{senha}")
    public ResponseEntity postAutenticado(@PathVariable String login, @PathVariable String senha) {
        for (Usuario usuario : repository.findAll()) {
            repository.atualizarAutenticacao(usuario.getLogin(), true);
            return ResponseEntity.status(200).body(usuario);
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping
    public ResponseEntity getUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    @DeleteMapping("/autenticacao/{login}")
    public ResponseEntity deleteUsuario(@PathVariable String login) {
        for (Usuario usuario : repository.findAll()) {
            repository.atualizarAutenticacao(usuario.getLogin(), false);
            return ResponseEntity.status(200).body(usuario);
        }
        return ResponseEntity.status(404).build();

    }

    /*
    Para a aplicação do exercicio F) Crie um EndPoint conforme sua criatividade que faça uso dos dados
     da API aqui descritos. Pode ser qualquer tipo de operação (cadastro, consulta, exclusão etc).
      Escreva um comentário de código acima do método explicando qual sua intenção com esse EndPoint

      Eu escolhi aplicar o metodo filtrarAutenticados, para usar dynamic finders e assim mostrar quantos
      usuarios foram autenticados
    */
    @GetMapping("/contagem-autenticados")
    public ResponseEntity<Integer> filtrarAutenticados() {
        return ResponseEntity.status(200).body(repository.countByAutenticado(true));
    }
}
