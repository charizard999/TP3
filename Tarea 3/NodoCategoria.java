
/**
 * Write a description of class NodoCategoria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoCategoria
{
    private Categoria categoria;
    private NodoCategoria sig;

    /**
     * Constructor for objects of class NodoCategoria
     */
    public NodoCategoria(Categoria categoria)
    {
        this.categoria = categoria;
      this.sig = null;
    }
     public Categoria getCategoria(){
        return categoria;
    }
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }
    public NodoCategoria getSig() {
        return sig;
    }
      public void setSig(NodoCategoria sig) {
        this.sig = sig;
    }
     
 }
