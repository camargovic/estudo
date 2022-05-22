package com.sptech.projetojpa06.repositorio;

import com.sptech.projetojpa06.entidade.Modelo;
import com.sptech.projetojpa06.resposta.ModeloSimplesResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModeloRespository extends JpaRepository<Modelo, Long> {

    List<Modelo> findByFabricanteId(Long id);

    int countByFabricanteId(Long id);

    int countByFabricantePaisNomeContainsIgnoreCase(String nome);

    @Query("select new  m.id, m.nome, m.fabricante.nome, m.fabricante.pais.nome) from Modelo m where m.nome = ?1")
    List<ModeloSimplesResposta> listaSimples(String nomeModelo);
}
