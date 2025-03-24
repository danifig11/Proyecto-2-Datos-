/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Departamento de Ciencia de la Computación
 * Autores: 
 *  - Daniel Figueroa 24073
 *  - Oliver Cifuentes 241021
 *  - Saul Castillo 24915
 * Fecha: Marzo 2025
 * 
 * Main: Clase principal que ejecuta el intérprete LISP.
 * - Recibe una expresión en LISP ingresada por el usuario.
 * - Tokeniza la entrada y la convierte en una estructura procesable.
 * - Evalúa la expresión y muestra el resultado en pantalla.
 */

 import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner escaner = new Scanner(System.in)) {
            System.out.println("Ingresa una expresión en LISP:");

            String entrada = escaner.nextLine();
            List<String> tokens = Tokenizador.dividirEnTokens(entrada);
            System.out.println("Tokens: " + tokens);

            Object expresionConvertida = Convertir.convertir(tokens);
            Object resultado = Evaluador.evaluar(expresionConvertida);

            if (resultado != null) {
                System.out.println("Resultado: " + resultado);
            }
        }
    }
}