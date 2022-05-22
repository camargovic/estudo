package com.sptech.projetojpa03.repositorio;

import com.sptech.projetojpa03.entidade.AnimalEstimacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalEstimacaoRepository extends JpaRepository<AnimalEstimacao, Long> {

    @Query("Select a from AnimalEstimacao a where a.nome = ?1 and a.castrado = ?2")
    List<AnimalEstimacao> filtroNomeCastrado(String nome, boolean castrado);

    @Query("Select a from AnimalEstimacao a where a.nome = ?1")
    List<AnimalEstimacao> filtroNome(String nome);


    /*
     Abaixo usamos o DYNAMIC FINDERS
    */
    List<AnimalEstimacao> findByNome(String nome);

    List<AnimalEstimacao> findByNomeAndCastrado(String nome, boolean castrado);

    List<AnimalEstimacao> findByCastrado(boolean castrado);

    int countByCastrado(boolean castrado);


}

