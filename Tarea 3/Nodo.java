
/**
 * Write a description of class Nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nodo
{
    private Categoria categoria;
    private Nodo derecho;
    private Nodo izquierda;
    /**
     * Constructor for objects of class Nodo
     */
    public Nodo(Categoria categoria)
    {
        this.categoria = categoria;
        derecho = null;
        izquierda = null;
    }
    
     public Categoria getCategoria() {
        return categoria;
    }
     public void setCategoria() {
        this.categoria = categoria;
    }

     /**
     * Obtener nodo derecho.
     *
     * 
     * @return listaPersona (Nodo)
     */
    public Nodo getNodoDerecho() {
        return derecho;
    }
     /**
     * Setear nodo derecho.
     *
     * @param derecho (Nodo).
     * 
     */
    public void setNodoDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    
     /**
     * Obtener nodo izquierdo.
     *
     * 
     * @return listaPersona (Nodo)
     */
    public Nodo getNodoIzquierda() {
        return izquierda;
    }
     /**
     * Setear noddo izquierdo.
     *
     * @param izquierda (Nodo).
     * 
     */
    public void setNodoIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }
 
}
