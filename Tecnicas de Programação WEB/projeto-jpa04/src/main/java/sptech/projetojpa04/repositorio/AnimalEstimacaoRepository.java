package sptech.projetojpa04.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.projetojpa04.entidade.AnimalEstimacao;

import java.util.List;

public interface AnimalEstimacaoRepository
                        extends JpaRepository<AnimalEstimacao, Long> {

    // podemos usar JPQL para retornar diretamente uma entidade
    @Query("select a from AnimalEstimacao a where a.nome = ?1 and a.castrado = ?2")
    List<AnimalEstimacao> filtroNomeCastrado(String nome, boolean castrado);

    @Query("select a from AnimalEstimacao a where a.nome = ?1")
    List<AnimalEstimacao> filtroNome(String nome);

    /*
Abaixo usamos os DYNAMIC FINDERS
     */
    List<AnimalEstimacao> findByNome(String nome);
    List<AnimalEstimacao> findByNomeAndCastrado(String nome, boolean castrado);

}
