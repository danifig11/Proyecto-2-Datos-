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
 