import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizador {
    public static List<String> dividirEnTokens(String entrada) {
        List<String> tokens = new ArrayList<>();
        Pattern patron = Pattern.compile("\\(|\\)|[a-zA-Z0-9+\\-*/=<>]+|'");
        Matcher coincidencia = patron.matcher(entrada);

        while (coincidencia.find()) {
            tokens.add(coincidencia.group());
        }
        return tokens;
    }
}