package es.uned.lsi.eped.pract2023_2024;

/**
 * Representación del repositorio de canciones.
 */
public interface TuneCollectionIF {
  
  /**
   * Devuelve el tamaño de la colección de canciones.
   * @return un entero con el número de canciones almacenadas.
   */
  public int size();
  
  /**
   * Devuelve una canción a partir de su identificador.
   * @param ID un entero con el identificador de la canción a recuperar.
   * @implNote 0 <= ID < this.size().
   * @return un objeto TuneIF con la canción con el identificador recibido.
   */
  public TuneIF getTune(int ID);
}
