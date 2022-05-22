package sptech.projetojpa06.rest.racas;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "racas", url = "5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/racas")
public interface PetRaca {

    @GetMapping("{idRaca}")
    RacasResposta getRaca(@PathVariable long idRaca);
}
