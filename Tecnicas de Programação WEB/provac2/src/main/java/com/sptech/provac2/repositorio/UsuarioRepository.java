package com.sptech.provac2.repositorio;

import com.sptech.provac2.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Transactional
    @Modifying
    @Query(
            "update Usuario s set s.autenticado = ?2 where s.login = ?1")
    void atualizarAutenticacao(String login, Boolean autenticado);

    int countByAutenticado(boolean autenticado);
}
