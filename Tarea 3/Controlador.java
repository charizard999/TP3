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

public class Controlador
{
    private VentanaPrincipal principal;
    List<String> data;
    String [] categorias = {"Action & Adventure","TV Drama","Dramas","International Movies","Comedies","Romantic Movies","Crime TV Shows",
            "International TV Shows","TV Mysteries","Independent Movies","Sports Movies","Thrillers","LGBTQ Movies",
            "Romantic TV Shows"};
    private ListaCategoria listaCategorias;

    public Controlador(){
        data = new ArrayList<String>();
        listaCategorias = new ListaCategoria();    
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return principal;
    }

    public void setVentanaPrincipal(VentanaPrincipal principal) {
        this.principal = principal;

    }

    public void setListaCategoria(ListaCategoria listaCategorias){
        this.listaCategorias = listaCategorias;
    }

    public ListaCategoria getListaCategoria(){
        return listaCategorias;
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
            listaCategorias.insertarCategoria(new Categoria(categorias[i]));
        }
    }

    public void imprimirLista(){
        llenarCategorias();
        listaCategorias.imprimir();
    }

    public void ordenarDatos(){
     //crear nuevo video y llenarlo con estos datos
     for(int i = 12; i< data.size(); i+=12){
         // objeto de video y llenarlo con los set
        System.out.println(data.get(i)); //show_id
        System.out.println(data.get(i+1));
        System.out.println(data.get(i+2));
        System.out.println(data.get(i+3));
        System.out.println(data.get(i+4));
        System.out.println(data.get(i+5));
        System.out.println(data.get(i+6));
        System.out.println(data.get(i+7));
        System.out.println(data.get(i+8));
        System.out.println(data.get(i+9));
        System.out.println(data.get(i+10));
        System.out.println(data.get(i+11));
     }
    }

}
