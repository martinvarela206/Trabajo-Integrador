package src;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Ronda {
   public String numero;
   public Partido[] partido;
   public int cantidadPartidos;

   public Ronda(String numero){
      // Abre el archivo resultados.csv y obtiene todas las lineas
      // la cantidad de lineas es la cantidad de partidos
      // Segun el numero de partidos, genera el arreglo partidos y pasa la info de cada partido
      cantidadPartidos = contarPartidos("csv\\resultados.csv");
      partido = new Partido[cantidadPartidos];
      try {
         int i = 0;
         for (String linea : Files.readAllLines(Paths.get("csv\\resultados.csv")))
            if (!linea.trim().isEmpty()){
               i++;
               partido[i]= new Partido(linea.split(";"));
            }
         } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
      }
   }

   public int puntos() {
      // WTF?
      return 0;
   }

   private int contarPartidos(String pathArchivo) {
      int conta = 0;
      try {
         for (String linea : Files.readAllLines(Paths.get(pathArchivo)))
            if (!linea.trim().isEmpty())
               conta++;
      } catch (IOException e) {
         System.err.println("Error al leer el archivo: " + e.getMessage());
         conta = -1;
      }
      return conta;
   }
}
