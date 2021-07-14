
/**
 * Write a description of class ListaVideo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaVideo
{
    private NodoVideo listaVideo;
    
    /**
     * Constructor for objects of class ListaVideo
     */
    public ListaVideo()
    {
       this.listaVideo = null;
    }
    
    public NodoVideo getListaVideo() {
        return listaVideo;
    }
    public void setListaVideo(NodoVideo listaVideo) {
        this.listaVideo = listaVideo;
    }
    
    public void insertarVideo(Video video) {
        if(listaVideo ==null) {
            listaVideo = new NodoVideo(video);
        }else {
            NodoVideo actual = listaVideo;
            NodoVideo nuevo = new NodoVideo(video);
            while(actual.getSig()!= null) {
                actual = actual.getSig();
            } 
            actual.setSig(nuevo);

        }

    }
    
    
    
}
