
/**
 * Write a description of class Categoteria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Categoria
{
   
    private String nombre;
    private ListaVideo listaVideos;
    /**
     * Constructor for objects of class Categoteria
     */
    public Categoria(String nombre)
    {
        this.nombre = nombre;   
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setListaVideo(ListaVideo listaVideos){
        this.listaVideos = listaVideos;
    }
    public ListaVideo getListaVideo(){
        return listaVideos;
    }

}
