package sptech.projetojpa01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import sptech.projetojpa01.entidade.Salgadinho;
import sptech.projetojpa01.resposta.SalgadinhoSimplesResposta;

import java.util.List;

public interface SalgadinhoRepository extends JpaRepository<Salgadinho, Long> {
    /*
    A @Query aceita instruções na linguagem JPQL (Java Persistence Query Language)
    A diferença é que nela devemos usar os nomes das Entidades e não tabelas
     */
    @Query("select new sptech.projetojpa01.resposta.SalgadinhoSimplesResposta(s.codigo, s.nome) from Salgadinho s")
    List<SalgadinhoSimplesResposta> listaSimples();


    /*
    Caso a @Query contenha instrução que altere dados,
    precisamos também das anotações @Transactional e @Modifying
     */
    @Transactional // do pacote org.spring....
    @Modifying
    @Query(
            "update Salgadinho s set s.preco = ?2 where s.codigo = ?1")
    void atualizarPreco(long codigo, double novoPreco);

    @Transactional // do pacote org.spring....
    @Modifying
    @Query(
            "update Salgadinho s set s.preco = ?2, s.apimentado = ?3 " +
                    " where s.codigo = ?1")
    void atualizarPrecoApimentado(long codigo,
                                  double novoPreco,
                                  boolean apimentado);


    // DYNAMIC FINDERS
    List<Salgadinho> findByApimentado(boolean apimentado);

    int countByApimentado(boolean apimentado);

    List<Salgadinho> findByNivelSalLessThan(Integer nivelSal);

    List<Salgadinho> findByPrecoGreaterThanEqual(Double preco);
}
