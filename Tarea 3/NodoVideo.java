
/**
 * Write a description of class NodoVideo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoVideo
{
     private Video video;
     private NodoVideo sig;
    /**
     * Constructor for objects of class NodoVideo
     */
    public NodoVideo(Video video)
    {
      this.video = video;
      this.sig = null;
    }
    public Video getVideo(){
        return video;
    }
    public void setVideo(Video video){
        this.video = video;
    }
    public NodoVideo getSig() {
        return sig;
    }
      public void setSig(NodoVideo sig) {
        this.sig = sig;
    }
}
