import java.util.Date;

/**
 * Write a description of class Video here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Video
{
    
    private String show_id;
    private String tipo;
    private String titulo;
    private String director;
    private String casting; // hacer get y set
    private String pais;
    private String fecha_agregacion;
    private String año_produccion;
    private String audiencia;
    private String duracion;
    private String categoria;
    private String descripcion;
    /**
     * Constructor for objects of class Video
     */
    public Video()
    {

    }
      
    public void setShow_id(String show_id){
        this.show_id = show_id;
    }
    public String getShow_id(){
        return show_id;
    }
    
      public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }    
      public void setTitulo(String título){
        this.titulo = título;
    }
    public String getTitulo(){
        return titulo;
    }    
          public void setPais(String pais){
        this.pais = pais;
    }
    public String getPais(){
        return pais;
    }  
         public void setFecha_agregacion(String fecha_agregacion){
        this.fecha_agregacion = fecha_agregacion;
    }
    public String getFecha_agregacion(){
        return fecha_agregacion;
    }   
         public void setAudiencia(String audiencia){
        this.audiencia = audiencia;
    }
    public String getAudiencia(){
        return audiencia;
    }   
         public void setDuracion(String duración){
        this.duracion = duración;
    }
    public String getDuracion(){
        return duracion;
    }  
         public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    } 
         public void setDirector(String director){
        this.director = director;
    }
    public String getDirector(){
        return director;
    }  
        public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public String getCategoria(){
        return categoria;
    }  
        public void setAño_produccion(String año_produccion){
        this.año_produccion = año_produccion;
    }
    public String getAño_produccion(){
        return año_produccion;
    }  
       public void setCasting(String casting){
        this.casting = casting;
    }
    public String getCasting(){
        return casting;
    }  
    
    


   
}
