import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
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