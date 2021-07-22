
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
                return elementoEncontrado;
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
    
    public Nodo buscarNodo(String categoria){
        Nodo aux = raiz;
        while(aux != null){
            
            if(aux.getCategoria().getNombre().toUpperCase().trim().equals(categoria.toUpperCase().trim())){ 
                System.out.println(aux.getCategoria().getNombre().toUpperCase() +"  "+categoria.toUpperCase());
                return aux;
            }else{
                if( aux.getCategoria().getNombre().charAt(0) < categoria.charAt(0)){
                    aux = aux.getNodoDerecho();
                }else{
                    aux = aux.getNodoIzquierda();
                }
            }
        }
        return null;
    }

    
    public void agregarVideo(Video video){
        boolean elementoEncontrado = false;
        if(!arbolVacio()){
            Nodo aux  = raiz;
            while ( aux != null && !elementoEncontrado){
                if(aux.getCategoria().getNombre().equals(video.getCategoria())){
                    elementoEncontrado = true;
                    aux.getCategoria().getListaVideo().add(video);
                }else{
                    if( aux.getCategoria().getNombre().charAt(0)< video.getCategoria().charAt(0)){
                        aux = aux.getNodoDerecho();
                    }else{
                        aux = aux.getNodoIzquierda();
                    }
                }
            }   
        }
    }

    public void inOrder(Nodo n) {
        if (n != null) {
            inOrder(n.getNodoIzquierda());
            System.out.println("Categoria "+n.getCategoria().getNombre());
            for(Video v : n.getCategoria().getListaVideo()){
                System.out.println("Nombre: " + v.getTitulo());
                System.out.println("Descripcion: " + v.getDescripcion());
                System.out.println("Categoria: " + v.getCategoria());
            }
            inOrder(n.getNodoDerecho());
        }
    }

    
    public void insertar(Categoria dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(Nodo padre, Categoria dato) {
       
            if (dato.getNombre().charAt(0) > padre.getCategoria().getNombre().charAt(0)) {
                if (padre.getNodoDerecho() == null) {
                    padre.setNodoDerecho(new Nodo(dato));
                } else {
                    this.insertar(padre.getNodoDerecho(), dato);
                }
            } else {
                if (padre.getNodoIzquierda() == null) {
                    padre.setNodoIzquierda(new Nodo(dato));
                } else {
                    this.insertar(padre.getNodoIzquierda(), dato);
                }
            }
        
    }

    
}
