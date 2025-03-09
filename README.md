En este proyecto, se está diseñando un reproductor de música que permite gestionar una colección de canciones, listas de reproducción, una cola de reproducción y las últimas canciones reproducidas. La implementación del reproductor está compuesta por varios componentes interactuando entre sí, como el Repository, PlayListManager, PlayBackQueue y RecentlyPlayed, cada uno con responsabilidades específicas.

El objetivo principal es gestionar de forma eficiente la información sobre las canciones y permitir acciones como:

- Organizar y acceder a la colección de canciones.
- Gestionar listas de reproducción.
- Crear y organizar una cola de canciones a reproducir.
- Realizar consultas sobre las canciones reproducidas recientemente.
## Diseño
### Componentes Principales:
1. Repository: Es el repositorio de canciones. Cada canción tiene metadatos como título, autor, género, álbum, año de publicación y duración. Este repositorio es inmutable, es decir, no se pueden agregar ni eliminar canciones una vez creado.
2. PlayListManager: Se encarga de gestionar las listas de reproducción. Cada lista se compone de canciones provenientes del Repository. Un identificador único permite acceder a las listas de reproducción, y las canciones pueden aparecer más de una vez.
3. PlayBackQueue: Representa la cola de reproducción, que almacena las canciones a ser reproducidas. Se puede construir a partir de canciones del Repository o de listas de reproducción.
4. RecentlyPlayed: Almacena las últimas canciones reproducidas. Cuando una canción se reproduce, se elimina de PlayBackQueue y se agrega a RecentlyPlayed. Si el número de canciones almacenadas en RecentlyPlayed alcanza el límite, la canción menos reciente se elimina.
### Relación entre los Componentes:
- El Repository contiene todas las canciones.
- El PlayListManager gestiona las listas de reproducción formadas por canciones del Repository.
- La PlayBackQueue contiene las canciones que se reproducirán, provenientes tanto del Repository como de las listas de reproducción.
- RecentlyPlayed guarda las últimas canciones reproducidas extraídas de PlayBackQueue.
## TAD (Tipo Abstracto de Datos) en el Proyecto
1. Player
El TAD Player representa el reproductor de música e interactúa con los otros componentes descritos:

- Operaciones de creación: Permite crear un reproductor de música a partir de una colección de canciones.
- Operaciones de consulta: Consulta las listas de reproducción, la cola de reproducción y las últimas canciones reproducidas.
- Operaciones de modificación: Permite crear y gestionar listas de reproducción, añadir canciones a la cola de reproducción, y reproducir la siguiente canción.
- Operaciones de borrado: No se contempla borrar el reproductor.
2. TuneCollection
El TAD TuneCollection representa la colección de canciones del Repository. Cada canción tiene un identificador único y proporciona operaciones para consultar y obtener canciones.

3. Tune
El TAD Tune representa una canción individual con metadatos: título, autor, género, álbum, año de publicación y duración.

- Operaciones de creación: Permite crear una canción a partir de sus atributos.
- Operaciones de consulta: Permite buscar canciones según criterios como título, autor, año, etc.
- Operaciones de modificación: No se permite modificar una canción una vez creada.
- Operaciones de borrado: No se permite eliminar una canción.
4. PlayListManager
El TAD PlayListManager gestiona las listas de reproducción, donde cada lista tiene un identificador único y puede contener varias canciones.

- Operaciones de creación: Permite crear listas de reproducción.
- Operaciones de consulta: Permite consultar la existencia de listas de reproducción y obtener las canciones de una lista específica.
- Operaciones de modificación: Permite añadir y eliminar canciones de listas de reproducción.
5. PlayList
El TAD PlayList representa una lista de reproducción. Almacena identificadores de canciones y permite añadir o eliminar canciones de la lista.

6. Query
El TAD Query permite crear criterios de búsqueda para encontrar canciones en el Repository. Los criterios pueden ser:

- Título
- Autor
- Género
- Álbum
- Año mínimo y máximo
- Duración mínima y máxima.
7. PlayBackQueue
El TAD PlayBackQueue es la cola de reproducción que contiene las canciones que se reproducirán en orden.

8. RecentlyPlayed
El TAD RecentlyPlayed guarda las últimas canciones reproducidas, con un tamaño limitado.
