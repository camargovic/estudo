package sptech.correcao01.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.correcao01.entidade.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public ResponseEntity postUsuario(@RequestBody Usuario novoUsuario) {
        usuarios.add(novoUsuario);
        // retornando uma resposta...
        // de statur 201 (criado)
        // e sem corpo de resposta (porque não precisa!) - .build()
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticacao/{login}/{senha}")
    public ResponseEntity logonUsuario(@PathVariable String login, @PathVariable String senha) {
        for (Usuario usuarioAtual : usuarios) {
            if (usuarioAtual.autenticar(login, senha)) {
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping
    public ResponseEntity getUsuarios() {
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(usuarios);
        }
    }

    @DeleteMapping("/autenticacao/{login}")
    public ResponseEntity logoffUsuario(@PathVariable String login) {
        for (Usuario usuarioAtual : usuarios) {
            if (usuarioAtual.getLogin().equals(login)) {
                if (usuarioAtual.isAutenticado()) {
                    usuarioAtual.setAutenticado(false);
                    return ResponseEntity.status(200).build();
                } else {
                    return ResponseEntity.status(401).build();
                }
            }
        }
        return ResponseEntity.status(404).build();
    }

    // EndPoints extras:

    @GetMapping("/autenticados")
    public ResponseEntity getUsuariosAutenticados() {
        List<Usuario> autenticados = usuarios.stream()
                .filter(Usuario::isAutenticado)
                .collect(Collectors.toList());

        if (autenticados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(autenticados);
    }

    @DeleteMapping("/autenticacao")
    public ResponseEntity logoffGeral() {
        for (Usuario login : usuarios) {
            login.setAutenticado(false);
        }
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/relatorio")
    public ResponseEntity getRelatorio() {
        long autenticados = usuarios.stream()
                                    .filter(Usuario::isAutenticado)
                                    .count();

        String relatorio = String.format(
                "Total de usuários: %s. Autenticados: %d. Não autenticados: %s",
                usuarios.size(), autenticados, usuarios.size() - autenticados
        );
        return ResponseEntity.status(200).body(relatorio);
    }
}

