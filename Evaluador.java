import java.util.*;

public class Evaluador {
    public static Object evaluar(Object expresion) {
        if (!(expresion instanceof List)) {
            return expresion;
        }

        List<Object> lista = (List<Object>) expresion;
        String operador = (String) lista.get(0);
        List<Object> operandos = lista.subList(1, lista.size());

        switch (operador) {
            case "+":
                return (int) evaluar(operandos.get(0)) + (int) evaluar(operandos.get(1));
            case "-":
                return (int) evaluar(operandos.get(0)) - (int) evaluar(operandos.get(1));
            case "*":
                return (int) evaluar(operandos.get(0)) * (int) evaluar(operandos.get(1));
            case "IMPRIMIR":
                Object resultado = evaluar(operandos.get(0));
                System.out.println("IMPRIMIR: " + resultado);
                return null;
            default:
                throw new RuntimeException("Error: Operador no reconocido " + operador);
        }
    }
}