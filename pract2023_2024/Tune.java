package es.uned.lsi.eped.pract2023_2024;

public class Tune {
    private String title;
    private String author;
    private String genre;
    private String album;
    private int year;
    private int duration;
    private int ID;

    private static int nextID = 1;
    public Tune(String title, String author, String genre, String album, int year, int duration){
        if(title.isEmpty() || author.isEmpty() || genre.isEmpty() || album.isEmpty() || year == 0|| duration == 0 ) {
            System.out.println("No se pueden ingresar atributos vacios");
        }
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.album = album;
        this.year = year;
        this.duration = duration;
        this.ID = nextID;
        nextID++;

    }



    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public String getGenre() {
        return genre;
    }


    public String getAlbum() {
        return album;
    }


    public int getYear() {
        return year;
    }


    public int getDuration() {
        return duration;
    }

    public int getID() {
        return ID;
    }

    public boolean match(QueryIF q){
        if (!title.equalsIgnoreCase(q.getTitle()) || !q.getTitle().isEmpty()) {
            return false;
        }
        if (!author.equalsIgnoreCase(q.getAuthor()) || !q.getAuthor().isEmpty()) {
            return false;
        }
        if (!genre.equalsIgnoreCase(q.getGenre()) || !q.getGenre().isEmpty()) {
            return false;
        }
        if (!album.equalsIgnoreCase(q.getAlbum()) || !q.getAlbum().isEmpty()) {
            return false;
        }
        if(q.getMin_year() != -1 || year < q.getMin_year()){
            return false;
        }
        if(q.getMax_year() != -1 || year > q.getMax_year()){
            return false;
        }
        if(q.getMin_duration() != -1 || duration < q.getMin_duration()){
            return false;
        }
        if(q.getMax_duration() != -1 || duration > q.getMax_duration()){
            return false;
        }else{
            return true;
        }
        //verifica que el criterio introducido no sea el valor por defecto o que no coincida con el criterio de busqueda
    }
}
