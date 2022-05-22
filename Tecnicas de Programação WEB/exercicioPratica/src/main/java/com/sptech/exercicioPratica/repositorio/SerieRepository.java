package com.sptech.exercicioPratica.repositorio;

import com.sptech.exercicioPratica.entidade.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    @Transactional
    @Modifying
    @Query("update Serie s set s.qntTemporadas = ?2 where s.codigo = ?1")
    void atualizarTemporadas(long codigo, int qntTemporadas);

}
