/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Departamento de Ciencia de la Computación
 * Autores: 
 *  - Daniel Figueroa 24073
 *  - Oliver Cifuentes 241021
 *  - Saul Castillo 24915
 * Fecha: Marzo 2025
 * 
 * Evaluador: Clase que evalúa expresiones en LISP utilizando estructuras de datos en Java.
 * 
 * - Soporta operaciones básicas (+, -, *, /, SQRT).
 * - Permite definir variables con SETQ.
 * - Permite definir funciones con DEFUN.
 * - Evalúa condiciones con COND.
 */

 import java.util.*;

 public class Evaluador {
     private static final Map<String, Object> variables = new HashMap<>();
     private static final Map<String, List<Object>> funciones = new HashMap<>();
 
     public static Object evaluar(Object expresion) {
         if (!(expresion instanceof List)) {
             if (variables.containsKey(expresion)) {
                 return variables.get(expresion);
             }
             return expresion;
         }
 
         List<Object> lista = (List<Object>) expresion;
         String operador = (String) lista.get(0);
         List<Object> operandos = lista.subList(1, lista.size());
 
         switch (operador) {
             case "+":
                 double suma = 0;
                 for (Object operando : operandos) {
                     suma += ((Number) evaluar(operando)).doubleValue();
                 }
                 return suma;
             case "-":
                 return ((Number) evaluar(operandos.get(0))).doubleValue() - ((Number) evaluar(operandos.get(1))).doubleValue();
             case "*":
                 return ((Number) evaluar(operandos.get(0))).doubleValue() * ((Number) evaluar(operandos.get(1))).doubleValue();
             case "/":
                 double divisor = ((Number) evaluar(operandos.get(1))).doubleValue();
                 if (divisor == 0) throw new ArithmeticException("División por cero no permitida.");
                 return ((Number) evaluar(operandos.get(0))).doubleValue() / divisor;
             case "SQRT":
                 return Math.sqrt(((Number) evaluar(operandos.get(0))).doubleValue());
             case "IMPRIMIR":
                 Object resultado = evaluar(operandos.get(0));
                 System.out.println("IMPRIMIR: " + resultado);
                 return null;
             case "SETQ":
                 variables.put((String) operandos.get(0), evaluar(operandos.get(1)));
                 return variables.get(operandos.get(0));
             case "EQUAL":
                 return evaluar(operandos.get(0)).equals(evaluar(operandos.get(1)));