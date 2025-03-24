/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Departamento de Ciencia de la Computación
 * Autores: 
 *  - Daniel Figueroa 24073
 *  - Oliver Cifuentes 241021
 *  - Saul Castillo 24915
 * Fecha: Marzo 2025
 * 
 * Tokenizador: Clase encargada de dividir una expresión en tokens para su procesamiento.
 */

 import java.util.ArrayList;
 import java.util.List;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 
 public class Tokenizador {
     public static List<String> dividirEnTokens(String entrada) {
         List<String> tokens = new ArrayList<>();
         Pattern patron = Pattern.compile("\\(|\\)|'?[a-zA-Z0-9+\\-*/=<>.]+|'");
         Matcher coincidencia = patron.matcher(entrada);
         while (coincidencia.find()) {
            tokens.add(coincidencia.group());
         
        }
        
        List<String> tokensCorregidos = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals("'") && i + 1 < tokens.size()) {
                tokensCorregidos.add("QUOTE");
            } else {
                tokensCorregidos.add(tokens.get(i));
            }
        }

        return tokensCorregidos;
    }
}
