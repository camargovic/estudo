package com.sptech.exercicioPratica.repositorio;

import com.sptech.exercicioPratica.entidade.Novela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface NovelaRepository extends JpaRepository<Novela, Long> {

    @Transactional
    @Modifying
    @Query("update Novela n set n.qntEpisodios = ?2 where n.codigo = ?1")
    void atualizarEpisodios(long codigo, int qntEpisodios);
}
