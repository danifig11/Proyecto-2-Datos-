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