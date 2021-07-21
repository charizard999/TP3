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

public class Controlador
{
    private VentanaPrincipal principal;
    List<String> data;
    String [] categorias = {"Action & Adventure","TV Drama","Dramas","International Movies","Comedies","Romantic Movies","Crime TV Shows",
            "International TV Shows","TV Mysteries","Independent Movies","Sports Movies","Thrillers","LGBTQ Movies",
            "Romantic TV Shows"};
    private List<String[]> datos;
    private String separador=";";
    private String quote ="\"";

    public Controlador(){
        data = new ArrayList<String>();
        datos =new ArrayList<>();
          
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

    public void readExcelFile()  throws Exception{
        FileInputStream input_document = new FileInputStream(new File("Libro1.xls")); 
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
            // System.out.println(data.get(i));
           
        }
    }

    public void imprimirLista(){
        llenarCategorias();
        
    }

    public void ordenarDatos(){
        System.out.println("Datos ");
        List<Video> listaVideo = new ArrayList(); 
        
        int i=0;
        for(int m=4; m < datos.size(); m++){ //
                Video video = new Video();
                video.setShow_id(datos.get(m)[i]); //show_id
                video.setTipo(datos.get(m)[i+1]); // type
                video.setTítulo(datos.get(m)[i+2]); //titulo
                video.setDirector(datos.get(m)[i+3]); // director
                //falta casting
                int length = datos.get(m).length;
                video.setPaís(datos.get(m)[length-7]);
                video.setFecha_agregacion(datos.get(m)[length-6]);
                video.setAño_produccion(datos.get(m)[length-5]);
                video.setAudiencia(datos.get(m)[length-4]);
                video.setDuración(datos.get(m)[length-3]);
                video.setCategoría(datos.get(m)[length-2]);
                listaVideo.add(video);
        }
         
      
            for(int m=0; m < listaVideo.size(); m++){ //
              System.out.println(listaVideo.get(m).getTipo());
            }
     
     
      /* 
       * 
       * for(int i = 12; i< data.size(); i+=12){
            // objeto de video y llenarlo con los set
            video.setShow_id(data.get(i)); //show_id
            video.setTipo(data.get(1+1));
            video.setTítulo(data.get(1+2));
            video.setDirector(data.get(1+3));
            video.setCasting(data.get(1+4));
            video.setPaís(data.get(1+5));
            video.setFecha_agregacion(data.get(1+6));
            video.setAño_produccion(data.get(1+7));
            video.setAudiencia(data.get(1+8));
            video.setDuración(data.get(1+9));
            video.setAudiencia(data.get(1+10));
            video.setDescripción(data.get(1+11));
        }*/
    }

}
