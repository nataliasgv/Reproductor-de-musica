package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.ListIF;

/**
 * Representación de un reproductor de música.
 */
public interface PlayerIF {
  
  /**
   * Devuelve los identificadores de todas las listas de reproducción existentes.
   * @return una lista con los identificadores de todas las listas de reproducción (no importa el orden).
   */
  public ListIF<String> getPlayListIDs();
  
  /**
   * Devuelve el contenido de una lista de reproducción.
   * @param playListID una cadena de caracteres no vacía con el identificador de la lista de reproducción de la que se quiere obtener su contenido.
   * @return si en el reproductor existe una lista de reproducción con ese identificador, se devolverá una lista con su contenido; en caso contrario, se devolverá una lista vacía.
   */
  public ListIF<Integer> getPlayListContent(String playListID);
  
  /**
   * Devuelve los identificadores de las canciones contenidas en la cola de reproducción.
   * @return una lista con los identificadores de las canciones que están en la cola de reproducción (ha de conservar el orden en el que se introdujeron las canciones).
   */
  public ListIF<Integer> getPlayBackQueue();
  
  /**
   * Devuelve los identificadores de las últimas canciones reproducidas que están almacenadas en RecentlyPlayed.
   * @return una lista con los identificadores de las últimas canciones reproducidas (en el orden inverso al que se reprodujeron).
   */
  public ListIF<Integer> getRecentlyPlayed();
  
  /**
   * Crea una nueva lista de reproducción a partir de su identificador.
   * @param playListID una cadena de caracteres no vacía con el identificador de la nueva lista de reproducción.
   * @implNote si no existe una lista de reproducción con ese identificador, se crea; en caso contrario, no se hace nada.
   */
  public void createPlayList(String playListID);
  
  /**
   * Elimina una lista de reproducción del reproductor a partir de su identificador.
   * @param playListID una cadena de caracteres no vacía con el identificador de la lista de reproducción a eliminar.
   * @implNote si existe una lista de reproducción con ese identificador, se elimina; en caso contrario, no se hace nada.
   */
  public void removePlayList(String playListID);
  
  /**
   * Añade una lista de identificadores de canciones del repositorio a una lista de reproducción.
   * @param playListID una cadena de caracteres no vacía con el identificador de la lista de reproducción a la que se van a añadir las canciones.
   * @param lT una lista de identificadores de canciones contenidas en el repositorio.
   * @implNote todos los elementos de la lista son identificadores de canciones que existen dentro del repositorio.
   */
  public void addListOfTunesToPlayList(String playListID, ListIF<Integer> lT);
  
  /**
   * Añade los identificadores de todas las canciones del repositorio que cumplan los criterios indicados a una lista de reproducción.
   * @param playListID una cadena de caracteres no vacía con el identificador de la lista de reproducción a la que se van a añadir las canciones.
   * @param t una cadena de caracteres con el título de la canción buscada.
   * @param a una cadena de caracteres con el autor de la canción buscada.
   * @param g una cadena de caracteres con el género de la canción buscada.
   * @param al una cadena de caracteres con el álbum al que pertenece la canción buscada.
   * @param min_y un entero con el primer año del intervalo en el que se publicó la canción a buscar.
   * @param max_y un entero con el último año del intervalo en el que se publicó la canción a buscar.
   * @param min_d un entero con la duración mínima de la canción a buscar.
   * @param max_d un entero con la duración máxima de la canción a buscar.
   * @implNote si existe una lista de reproducción con ese identificador, se añaden a ella los identificadores de todas las canciones del repositorio que cumplan todos los criterios indicados; en caso contrario, no se hace nada.
   */
  public void addSearchToPlayList(String playListID,
                                  String t, String a, String g, String al,
                                  int min_y, int max_y,
                                  int min_d, int max_d);
  
  /**
   * Elimina una canción de una lista de reproducción.
   * @param playListID una cadena de caracteres no vacía con el identificador de la lista de reproducción de la que se quiere eliminar la canción.
   * @param tuneID un entero con el identificador de la canción del repositorio que se quiere eliminar de dicha lista.
   * @implNote si existe una lista de reproducción con ese identificador, se elimina de dicha lista todas las apariciones del identificador de la canción del repositorio pasada como parámetro; en caso contrario, no se hace nada.
   */
  public void removeTuneFromPlayList(String playListID, int tuneID);
  
  /**
   * Añade una lista de identificadores de canciones del repositorio a la cola de reproducción.
   * @param lT una lista de identificadores de canciones contenidas en el repositorio.
   * @implNote todos los elementos de la lista son identificadores de canciones que existen dentro del repositorio. Se añaden a la cola de reproducción los identificadores de las canciones contenidos en la lista.
   */
  public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT);
  
  /**
   * Añade los identificadores de todas las canciones del repositorio que cumplan los criterios indicados a la cola de reproducción.
   * @param t una cadena de caracteres con el título de la canción buscada.
   * @param a una cadena de caracteres con el autor de la canción buscada.
   * @param g una cadena de caracteres con el género de la canción buscada.
   * @param al una cadena de caracteres con el álbum al que pertenece la canción buscada.
   * @param min_y un entero con el primer año del intervalo en el que se creó la canción a buscar.
   * @param max_y un entero con el último año del intervalo en el que se creó la canción a buscar.
   * @param min_d un entero con la duración mínima de la canción a buscar.
   * @param max_d un entero con la duración máxima de la canción a buscar.
   * @implNote se añaden a la cola de reproducción los identificadores de todas las canciones del repositorio que cumplan todos los criterios indicados.
   */
  public void addSearchToPlayBackQueue(String t, String a, String g, String al,
                                       int min_y, int max_y,
                                       int min_d, int max_d);
  
  /**
   * Añade el contenido de una lista de reproducción a la cola de reproducción.
   * @param playListID una cadena de caracteres no vacía con el identificador de la lista de reproducción cuyo contenido se desea añadir a la cola de reproducción.
   * @implNote si existe una lista de reproducción con ese identificador, se añade su contenido a la cola de reproducción; en caso contrario, no se hace nada.
   */
  public void addPlayListToPlayBackQueue(String playListID);
  
  /**
   * Vacía la cola de reproducción.
   * @implNote la cola de reproducción se vacía.
   */
  public void clearPlayBackQueue();
  
  /**
   * Reproduce la siguiente canción en la cola de reproducción.
   * @implNote si la cola de reproducción no es vacía, se elimina de ella el primer elemento, pasando éste a la estructura que almacena las últimas canciones reproducidas, sin sobrepasar su tamaño máximo; en caso contrario, no se hace nada.
   */
  public void play();
}
