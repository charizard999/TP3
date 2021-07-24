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
        /**
     * Setear id.
     *
     * @param show_id (String).
     * 
     */

    public void setShow_id(String show_id){
        this.show_id = show_id;
    }
       /**
     * Obtener id.
     *
     * 
     * @return show_id (String )
     */
    public String getShow_id(){
        return show_id;
    }
         /**
     * Setear tipo.
     *
     * @param tipo (String).
     * 
     */

      public void setTipo(String tipo){
        this.tipo = tipo;
    }
          /**
     * Obtener tipo.
     *
     * 
     * @return tipo (String)
     */
    public String getTipo(){
        return tipo;
    }    
           /**
     * Setear título.
     *
     * @param título (String).
     * 
     */

      public void setTitulo(String título){
        this.titulo = título;
    }
           /**
     * Obtener titulo.
     *
     * 
     * @return titulo (String)
     */
    public String getTitulo(){
        return titulo;
    }    
             /**
     * Setear pais.
     *
     * @param pais (String).
     * 
     */
          public void setPais(String pais){
        this.pais = pais;
    }
               /**
     * Obtener pais.
     *
     * 
     * @return pais (String)
     */
    public String getPais(){
        return pais;
    }  
             /**
     * Setear fecha de agregacion.
     *
     * @param fecha_agregacion (String).
     * 
     */
         public void setFecha_agregacion(String fecha_agregacion){
        this.fecha_agregacion = fecha_agregacion;
    }
                  /**
     * Obtener fecha de agregacion.
     *
     * 
     * @return fecha_agregacion (String)
     */
    public String getFecha_agregacion(){
        return fecha_agregacion;
    }   
                /**
     * Setear audiencia.
     *
     * @param audiencia (String).
     * 
     */
         public void setAudiencia(String audiencia){
        this.audiencia = audiencia;
    }
                  /**
     * Obtener audiencia.
     *
     * 
     * @return audiencia(String)
     */

    public String getAudiencia(){
        return audiencia;
    }   
                   /**
     * Setear duración.
     *
     * @param duración (String).
     * 
     */
         public void setDuracion(String duración){
        this.duracion = duración;
    }
                     /**
     * Obtener duracion.
     *
     * 
     * @return duracion(String)
     */

    public String getDuracion(){
        return duracion;
    }  
                    /**
     * Setear descripcion.
     *
     * @param descripcion (String).
     * 
     */
         public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
                         /**
     * Obtener descripcion.
     *
     * 
     * @return descripcion(String)
     */

    public String getDescripcion(){
        return descripcion;
    } 
                        /**
     * Setear director.
     *
     * @param director (String).
     * 
     */
         public void setDirector(String director){
        this.director = director;
    }
                           /**
     * Obtener director.
     *
     * 
     * @return director(String)
     */
    public String getDirector(){
        return director;
    }  
                            /**
     * Setear categoria.
     *
     * @param categoria (String).
     * 
     */
        public void setCategoria(String categoria){
        this.categoria = categoria;
    }
                               /**
     * Obtener categoria.
     *
     * 
     * @return categoria(String)
     */
    public String getCategoria(){
        return categoria;
    }  
                                /**
     * Setear Año de produccion.
     *
     * @param año_produccion (String).
     * 
     */
        public void setAño_produccion(String año_produccion){
        this.año_produccion = año_produccion;
    }
                                  /**
     * Obtener Año de produccion.
     *
     * 
     * @return año_produccion(String)
     */
    public String getAño_produccion(){
        return año_produccion;
    }  
                                    /**
     * Setear casting.
     *
     * @param casting(String).
     * 
     */
       public void setCasting(String casting){
        this.casting = casting;
    }
                                      /**
     * Obtener casting.
     *
     * 
     * @return casting(String)
     */
    public String getCasting(){
        return casting;
    }  
    
    


   
}
