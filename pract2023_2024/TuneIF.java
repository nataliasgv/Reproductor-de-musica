package es.uned.lsi.eped.pract2023_2024;

/**
 * Representación de una canción.
 */
public interface TuneIF {
  
  /**
   * Devuelve el título de la canción.
   * @return el título de la canción.
   */
  String getTitle();
  
  /**
   * Devuelve el autor de la canción.
   * @return el autor de la canción.
   */
  String getAuthor();
  
  /**
   * Devuelve el género de la canción.
   * @return el género de la canción.
   */
  String getGenre();
  
  /**
   * Devuelve el álbum de la canción.
   * @return el álbum de la canción.
   */
  String GetAlbum();
  
  /**
   * Devuelve el año de la canción.
   * @return el año de la canción.
   */
  int GetYear();
  
  /**
   * Devuelve la duración de la canción.
   * @return la duración de la canción en segundos.
   */
  int getDuration();
  
  /**
   * Dado un objeto QueryIF conteniendo unos criterios de búsqueda, devuelve un valor de verdad indicando si la canción los cumple o no.
   * @param q un objeto QueryIF con unos criterios de búsqueda.
   * @return si la canción cumple TODOS los criterios, devolverá verdadero; si la canción incumple algún criterio, devolverá falso.
   */
  public boolean match(QueryIF q);
}
