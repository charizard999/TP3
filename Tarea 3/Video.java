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
    private String título;
    private String director;
    private String casting; // hacer get y set
    private String país;
    private String fecha_agregacion;
    private String año_produccion;
    private String audiencia;
    private String duración;
    private String categoría;
    private String descripción;
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
      public void setTítulo(String título){
        this.título = título;
    }
    public String getTítulo(){
        return título;
    }    
          public void setPaís(String país){
        this.país = país;
    }
    public String getPaís(){
        return país;
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
         public void setDuración(String duración){
        this.duración = duración;
    }
    public String getDuración(){
        return duración;
    }  
         public void setDescripción(String descripción){
        this.descripción = descripción;
    }
    public String getDescripción(){
        return descripción;
    } 
         public void setDirector(String director){
        this.director = director;
    }
    public String getDirector(){
        return director;
    }  
        public void setCategoría(String categoría){
        this.categoría = categoría;
    }
    public String getCategoríar(){
        return categoría;
    }  
        public void setAño_produccion(String año_produccion){
        this.año_produccion = año_produccion;
    }
    public String getAño_produccion(){
        return año_produccion;
    }  


   
}
