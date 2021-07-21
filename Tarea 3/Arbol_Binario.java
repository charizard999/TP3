
/**
 * Write a description of class Arbol_Binario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbol_Binario
{
    private Nodo raiz;
     
    public boolean arbolVacio(){
        return raiz == null;
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    public boolean buscarElemento(String categoria){
        boolean elementoEncontrado = false;
        Nodo aux = raiz;
        while(aux != null && !elementoEncontrado){
            if(aux.getCategoria().getNombre().equals( categoria)){
                elementoEncontrado = true;  
            }else{
                if( aux.getCategoria().getNombre().charAt(0) < categoria.charAt(0)){
                    aux = aux.getNodoDerecho();
                }else{
                    aux = aux.getNodoIzquierda();
                }
            }
        }
        return elementoEncontrado;
    }
    

    
    public void agregarVideo(Video video){
        boolean elementoEncontrado = false;
        if(!arbolVacio()){
            Nodo aux  = raiz;
            while ( aux != null && !elementoEncontrado){
                if(aux.getCategoria().getNombre().equals(video.getCategoría())){
                    elementoEncontrado = true;
                    aux.getCategoria().getListaVideo().add(video);
                }else{
                    if( aux.getCategoria().getNombre().charAt(0)< video.getCategoría().charAt(0)){
                        aux = aux.getNodoDerecho();
                    }else{
                        aux = aux.getNodoIzquierda();
                    }
                }
            }   
        }
    }
    
    public void inOrder(Nodo auxiliar){
        if(  auxiliar != null){
            inOrder(auxiliar.getNodoIzquierda());
            System.out.println("Categoria "+auxiliar.getCategoria().getNombre());
            //auxiliar.getListaVideo().imprimir();
            inOrder(auxiliar.getNodoDerecho());
        }
    }
    
    public void agregarNodo(Categoria categoria){
        Nodo auxiliar = new Nodo(categoria);
        if(arbolVacio()){
            raiz = auxiliar;
        }else{
            Nodo actual = raiz;
            Nodo anterior = raiz;
            //se busca que no exista la profesion y se agrega
            if( ! buscarElemento(categoria.getNombre()) ){
                while(actual != null){
                    if(auxiliar.getCategoria().getNombre().charAt(0)< categoria.getNombre().charAt(0)){
                        anterior = actual;
                        actual = actual.getNodoIzquierda();
                    }else{
                        anterior = actual;
                        actual = actual.getNodoDerecho();
                    }
                }
                if( categoria.getNombre().charAt(0) < anterior.getCategoria().getNombre().charAt(0) )
                    anterior.setNodoIzquierda(auxiliar);
                else{
                     anterior.setNodoDerecho(auxiliar);
                }
            }
        }
    }
}
