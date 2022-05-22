package sptech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.entidade.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

//    @Query("select count(m) from Musica m")
//    Integer contagem();
//    }
}