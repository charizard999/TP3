
/**
 * Write a description of class ListaCategoria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaCategoria
{
    private NodoCategoria listaCategoria;
    /**
     * Constructor for objects of class ListaCategoria
     */
    public ListaCategoria()
    {
       this.listaCategoria = null;
    }
    
      public NodoCategoria getListaCategoria() {
        return listaCategoria;
    }
    public void setListaCategoria(NodoCategoria listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    public void insertarCategoria(Categoria categoria) {
        if(listaCategoria ==null) {
            listaCategoria = new NodoCategoria(categoria);
        }else {
            NodoCategoria actual = listaCategoria;
            NodoCategoria nuevo = new NodoCategoria(categoria);
            while(actual.getSig()!= null) {
                actual = actual.getSig();
            } 
            actual.setSig(nuevo);

        }

    }
    
    public void imprimir(){
        if(listaCategoria == null) {
            System.out.println("vacia");
        }
        else {
            NodoCategoria actual = listaCategoria;
            while(actual !=null) {
                System.out.println("Categoria :" + actual.getCategoria().getNombre());
                actual = actual.getSig();
            }

        }
    }
    

  
   
}
