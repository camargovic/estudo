import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LimiteUltrapasadoException extends Exception {
    String data;

    public LimiteUltrapasadoException(String s) {
        super(s);
        data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy " +
                "HH:mm:ss"));
    }
}
