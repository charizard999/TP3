import java.util.ArrayList;

/**
 * Write a description of class Categoteria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Categoria
{
   
    private String nombre;
    private ArrayList<Video> listaVideos;
    /**
     * Constructor for objects of class Categoteria
     */
    public Categoria(String nombre)
    {
        this.nombre = nombre;  
        listaVideos = new ArrayList<Video>();
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setListaVideo(ArrayList<Video> listaVideos){
        this.listaVideos = listaVideos;
    }
    public ArrayList<Video> getListaVideo(){
        return listaVideos;
    }

}
