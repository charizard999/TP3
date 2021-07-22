import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;


public class Controlador
{
    private VentanaPrincipal principal;
    List<String> data;
    String [] categorias = {"Action & Adventure","TV Drama","Dramas","International Movies","Comedies","Romantic Movies","Crime TV Shows",
            "International TV Shows","TV Mysteries","Independent Movies","Sports Movies","Thrillers","LGBTQ Movies",
            "Romantic TV Shows" , "Horror Movies", "Spanish-Language TV Shows", "Documentaries", "Sci-Fi & Fantasy","Stand-Up Comedy & Talk Shows",
            "Children & Family Movies", "Kids' TV","Reality TV","Docuseries","TV Comedies","Independent Movies", "British TV Shows",
            " Crime TV Shows", "Action & Adventure", "Stand-Up Comedy","Children & Family Movies", "Classic Movies", "Classic & Cult TV", 
            "TV Mysteries", "TV Thrillers","Music & Musicals" , "Faith & Spirituality","Anime Features" };
    private List<String[]> datos;
    private String separador=";";
    private String quote ="\"";
    private Arbol_Binario arbolCategorias;
    private List<Video> videos;

    public Controlador(){
        data = new ArrayList<String>();
        datos =new ArrayList<>();
        videos = new ArrayList<>();
        arbolCategorias = new Arbol_Binario();

    }

    private String[] removeTrailingQuotes(String[] fields) {

        String result[] = new String[fields.length];

        for (int i=0;i<result.length;i++){
            result[i] = fields[i].replaceAll("^"+quote, "").replaceAll(quote+"$", "");
        }
        return result;
    }

    public void leerCSV(){
        BufferedReader br = null;

        try {

            br =new BufferedReader(new FileReader("netflix_titles_dep.csv"));
            String line = br.readLine();
            while (null!=line) {
                //System.out.println("entra");
                if(line.replace(";","").equals(null) || line.replace(",","").equals("")){
                    System.out.println(line.replace(",", ""));
                    break;
                }else{
                    String [] fields = line.split(separador);
                    // System.out.println(Arrays.toString(fields));

                    fields = removeTrailingQuotes(fields);
                    // System.out.println(Arrays.toString(fields));
                    System.out.println(fields[0]);
                    datos.add(fields);
                    line = br.readLine();
                }
            }

            System.out.println(datos.size());

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (null!=br) {
                try
                {
                    br.close();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }

    }

    public VentanaPrincipal getVentanaPrincipal() {
        return principal;
    }
    public void setVentanaPrincipal(VentanaPrincipal principal) {
        this.principal = principal;

    }
    
    public Arbol_Binario getArbol() {
        return arbolCategorias;
    }
    public void setArbol(Arbol_Binario arbolCategorias) {
        this.arbolCategorias = arbolCategorias;

    }

    
    public List<Video> getListaVideo() {
        return videos;
    }
    public void setListaVideo(List<Video> videos) {
        this.videos = videos;

    }

    public void readExcelFile()  throws Exception{
        FileInputStream input_document = new FileInputStream(new File("netflix_movies.xls")); 
        HSSFWorkbook workbook = new HSSFWorkbook(input_document);
        HSSFSheet hoja = workbook.getSheetAt(0);
        for( Row row: hoja){
            for(int cn=0; cn<row.getLastCellNum(); cn++) {
                Cell cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if( cell.toString().isEmpty()){
                    data.add("vacío");
                }else{
                    data.add(cell.toString());
                }

            }
        }
    }

    public void llenarCategorias(){
        for(int i=0; i<categorias.length; i++){
            Categoria categoria = new Categoria(categorias[i]);
            arbolCategorias.insertar(categoria);
            
        }
    }

    public void imprimirLista(){
        llenarCategorias();

    }

    public void ordenarDatos(){
        for(int i = 12; i< data.size(); i+=12){
            // objeto de video y llenarlo con los set
            Video video = new Video();
            video.setShow_id(data.get(i)); //show_id
            video.setTipo(data.get(i+1));
            video.setTitulo(data.get(i+2));
            video.setDirector(data.get(i+3));
            video.setCasting(data.get(i+4));
            video.setPais(data.get(i+5));
            video.setFecha_agregacion(data.get(i+6));
            video.setAño_produccion(data.get(i+7));
            video.setAudiencia(data.get(i+8));
            video.setDuracion(data.get(i+9));
            video.setCategoria(data.get(i+10));
            video.setDescripcion(data.get(i+11));
            videos.add(video);
        }
    }
    
    int index=0;
    public void insertarVideosCategorias(){
         for(int i=0; i<categorias.length; i++){
             index = i;
             List<Video> videosCategorias = videos.stream().filter(x -> x.getCategoria().contains(categorias[index])).collect(Collectors.toList());  
             // falta meterlos a lista de cada nodo;
             Nodo aux = arbolCategorias.buscarNodo(categorias[index]);
             aux.getCategoria().setListaVideo((ArrayList<Video>)videosCategorias);
        }
     
    }
}
