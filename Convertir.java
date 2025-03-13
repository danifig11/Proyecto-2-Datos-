import java.util.*;

public class Convertir {
    public static Object convertir(List<String> tokens) {
        if (tokens.isEmpty()) {
            throw new RuntimeException("Error dejaste la expresion vacía :(");
        }

        String token = tokens.remove(0);
        if ("(".equals(token)) {
            List<Object> lista = new ArrayList<>();
            while (!tokens.get(0).equals(")")) {
                lista.add(convertir(tokens));
            }
            tokens.remove(0);
            return lista;
        } else if (")".equals(token)) {
            throw new RuntimeException("Error te faltan paréntesis :(");
        } else {
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                return token;
            }
        }
    }
}