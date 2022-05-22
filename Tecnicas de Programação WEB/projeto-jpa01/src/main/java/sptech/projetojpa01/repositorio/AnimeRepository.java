package sptech.projetojpa01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.projetojpa01.entidade.Anime;

public interface AnimeRepository
        extends JpaRepository<Anime, Integer> {
}
