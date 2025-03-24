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