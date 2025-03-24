/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Departamento de Ciencia de la Computación
 * Autores: 
 *  - Daniel Figueroa 24073
 *  - Oliver Cifuentes 241021
 *  - Saul Castillo 24915
 * Fecha: Marzo 2025
 * 
 * Convertir: Clase que convierte una lista de tokens en una estructura de datos procesable.
 */

 import java.util.*;

 public class Convertir {
     public static Object convertir(List<String> tokens) {
         if (tokens.isEmpty()) {
             throw new RuntimeException("Error: expresión incompleta, faltan paréntesis.");
         }
         
         String token = tokens.remove(0);
        if ("(".equals(token)) {
            List<Object> lista = new ArrayList<>();
            while (!tokens.isEmpty() && !tokens.get(0).equals(")")) {
                lista.add(convertir(tokens));
            }
            if (tokens.isEmpty()) {
                throw new RuntimeException("Error: falta un paréntesis de cierre.");
            }
            tokens.remove(0);
            return lista;
        } else if (")".equals(token)) {
            throw new RuntimeException("Error: paréntesis de cierre inesperado.");
        } else if ("QUOTE".equals(token)) {
            return Arrays.asList("QUOTE", convertir(tokens));
        } else {
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                try {
                    return Double.parseDouble(token);
                } catch (NumberFormatException ex) {
                    return token;
                }
            }
        }
    }
}