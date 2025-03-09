package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.ListIF;

/**
 * Interfaz que define la funcionalidad de una cola de reproducción.
 */
public interface PlayBackQueueIF {
  
  /**
   * Devuelve una lista con los identificadores de las canciones contenidas en la cola de reproducción.
   * @return una lista de enteros con los identificadores de las canciones que están en la cola de reproducción,
   * conservando el orden en el que fueron originalmente introducidos.
   */
  public ListIF<Integer> getContent();
  
  /**
   * Devuelve un booleano indicando si la cola de reproducción es vacía o no.
   * @return true si la cola de reproducción está vacía, false de lo contrario.
   */
  public boolean isEmpty();
  
  /**
   * Devuelve un entero con el identificador de la primera canción que está en la cola de reproducción.
   * @return el identificador de la primera canción en la cola de reproducción.
   * @implNote La cola de reproducción no debe estar vacía cuando se invoca este método.
   */
  public int getFirstTune();
  
  /**
   * Extrae la primera canción que se encuentre en la cola de reproducción.
   * @implNote La cola de reproducción no debe estar vacía cuando se invoca este método.
   */
  public void extractFirstTune();
  
  /**
   * Añade una lista de identificadores de canciones a la cola de reproducción.
   * @param lT una lista de enteros con los identificadores de las canciones que se desea añadir a la lista de reproducción.
   * @implNote Todos los elementos de la lista deben ser identificadores de canciones que existen dentro del repositorio.
   */
  public void addTunes(ListIF<Integer> lT);
  
  /**
   * Vacía el contenido de la cola de reproducción.
   */
  public void clear();
}


