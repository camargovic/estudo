package sptech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.entidade.Filme;

public interface FilmeRepository
        extends JpaRepository <Filme, Long> {

    @Query("select count(f) from Filme f")
    Integer contagem();
}
