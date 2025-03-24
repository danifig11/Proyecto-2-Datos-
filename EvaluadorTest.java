/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Departamento de Ciencia de la Computación
 * Autores: 
 *  - Daniel Figueroa 24073
 *  - Oliver Cifuentes 241021
 *  - Saul Castillo 24915
 * Fecha: Marzo 2025
 * 
 * Pruebas unitarias en JUnit para el intérprete LISP.
 */

 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;
 import java.util.Arrays;
 import java.util.List;
 
 public class EvaluadorTest {
 
     @Test
     void testSuma() {
         List<Object> expresion = Arrays.asList("+", 2, 3);
         assertEquals(5.0, Evaluador.evaluar(expresion));
     }
 
     @Test
     void testResta() {
         List<Object> expresion = Arrays.asList("-", 10, 4);
         assertEquals(6.0, Evaluador.evaluar(expresion));
     }
 
     @Test
     void testMultiplicacion() {
         List<Object> expresion = Arrays.asList("*", 3, 4);
         assertEquals(12.0, Evaluador.evaluar(expresion));
     }
 
     @Test
     void testDivision() {
         List<Object> expresion = Arrays.asList("/", 10, 2);
         assertEquals(5.0, Evaluador.evaluar(expresion));
     }

     @Test
     void testRaizCuadrada() {
         List<Object> expresion = Arrays.asList("SQRT", 16);
         assertEquals(4.0, Evaluador.evaluar(expresion));
     }
 
     @Test
     void testSetq() {
         List<Object> expresion = Arrays.asList("SETQ", "x", 42);
         Evaluador.evaluar(expresion);
         assertEquals(42, Evaluador.evaluar("x"));
     }
 
     @Test
     void testEqual() {
         List<Object> expresion = Arrays.asList("EQUAL", 5, 5);
         assertTrue((Boolean) Evaluador.evaluar(expresion));
     }

     @Test
     void testQuote() {
         List<Object> expresion = Arrays.asList("QUOTE", Arrays.asList(1, 2, 3));
         assertEquals(Arrays.asList(1, 2, 3), Evaluador.evaluar(expresion));
     }
 
     @Test
     void testDefunYUso() {
         List<Object> defFuncion = Arrays.asList("DEFUN", "doblar", Arrays.asList("x"), Arrays.asList("*", "x", 2));
         Evaluador.evaluar(defFuncion);
         List<Object> llamadaFuncion = Arrays.asList("doblar", 5);
         assertEquals(10.0, Evaluador.evaluar(llamadaFuncion));
     }
 
     @Test
     void testCond() {
         List<Object> expresion = Arrays.asList("COND",
                 Arrays.asList(Arrays.asList("EQUAL", 5, 5), 100),
                 Arrays.asList(Arrays.asList("EQUAL", 5, 6), 200)
         );
         assertEquals(100, Evaluador.evaluar(expresion));
     }
 
     @Test
     void testDivisionPorCero() {
         List<Object> expresion = Arrays.asList("/", 10, 0);
         Exception exception = assertThrows(ArithmeticException.class, () -> Evaluador.evaluar(expresion));
         assertEquals("División por cero no permitida.", exception.getMessage());
     }
 
     @Test
     void testOperacionDesconocida() {
         List<Object> expresion = Arrays.asList("OPERACION_INVALIDA", 5, 5);
         Exception exception = assertThrows(RuntimeException.class, () -> Evaluador.evaluar(expresion));
         assertTrue(exception.getMessage().contains("Error: operador o función no encontrada"));
     }
 
     @Test
     void testParametrosIncorrectosEnDefun() {
         List<Object> expresion = Arrays.asList("DEFUN", "mal", "x", Arrays.asList("+", "x", 1));
         Exception exception = assertThrows(RuntimeException.class, () -> Evaluador.evaluar(expresion));
         assertEquals("Error en DEFUN", exception.getMessage());
     }
 }