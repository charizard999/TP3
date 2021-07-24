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
    
         /**
     * Setear nombre.
     *
     * @param nombre (String).
     * 
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
     /**
     * Obtener nombre.
     *
     * 
     * @return nombre (String)
     */
    public String getNombre(){
        return nombre;
    }
       
    /**
     * Setear listaVideos.
     *
     * @param listaVideos (ArrayList<Video>).
     * 
     */
    public void setListaVideo(ArrayList<Video> listaVideos){
        this.listaVideos = listaVideos;
    }
     /**
     * Obtener ListaVideo.
     *
     * 
     * @return listaVideos (ArrayList<Video>)
     */
    public ArrayList<Video> getListaVideo(){
        return listaVideos;
    }
      /**
     * Obtener toString.
     *
     * 
     * @return nombre (String)
     */
    public String toString(){
        return this.nombre;
    }

}
