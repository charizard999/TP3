import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.EventObject;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

//librería de apache
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



import java.awt.Color;

/**
 * Write a description of class VentanaPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VentanaPrincipal  extends JFrame
{
            
        private JLabel labelBusqueda = new JLabel() ;
        private Controlador controlador;
        private JButton buscar;
        private JTextField  tfNombreVideo;
        private JTextField  tfCategoria;
        private JTextField  tfNombreACtor;
        private JTextField  tfPais;
        private JButton nuevo;
        private static DefaultTableModel modelo;
        private static JTable jt;
         
    /**
     * Constructor for objects of class VentanaPrincipal
     */
    public VentanaPrincipal()
    {
        
        
         this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setLayout(null);
        this.setSize(700, 600);
        this.setResizable(false);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int)(size.getWidth()-this.getWidth())/2,(int)(size.getHeight()-this.getHeight())/2 );
        
        //JPanel
        JPanel jpTop = new JPanel();
        
        jpTop.setSize(new Dimension(900,100));
        buscar = new JButton();
        buscar.setText("Buscar");
        JPanel jpTabla= new JPanel();

        
        //JLabel
        JLabel nPares = new JLabel("");
          
        //JTextField
        tfNombreVideo = new JTextField(20);
        tfCategoria = new JTextField(20);
        tfNombreACtor = new JTextField(20);
        tfPais = new JTextField(20);
        
        //JTable
        modelo = new DefaultTableModel(new String[][] {}, new String[] {"Título", "Casting", "País","Tipo","Director","Año","Audiencia","Duración","Categoría","País","Agregada en",});

        jt= new JTable(modelo) {
            public boolean editCellAt(int fila, int columna, EventObject e) {
                return false;    
            }
        };
        
        JScrollPane js= new JScrollPane(jt);
        js.setBounds(40,120, 800, 300);
        
        this.setSize(900, 600);
        this.setResizable(false);
        this.setLocation((int)(size.getWidth()-this.getWidth())/2,(int)(size.getHeight()-this.getHeight())/2 );

        jpTop.add(tfNombreVideo);
        jpTop.add(tfCategoria);
        jpTop.add(tfNombreACtor);
        jpTop.add(tfPais);
        jpTop.add(buscar);
        //jpTabla.add(jt);
        
        this.add(jpTop);
        this.add(js);      
        
        
        //readExcelFile(new File("netflix_titles.csv"));
        try{
        readExcelFile() ;
    }catch(Exception ex){
         System.out.print(ex);
    }
        
    }
    
    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    public void readExcelFile()  throws Exception{
          FileInputStream input_document = new FileInputStream(new File("netflix_titles.xls")); 
          HSSFWorkbook workbook = new HSSFWorkbook(input_document);
            //Acceso a la primera hoja del documento
            HSSFSheet hoja = workbook.getSheetAt(0);
            List<String> data = new ArrayList<String>();
            
            //Recorremos las filas del documento
            Iterator rows = hoja.rowIterator();
            while (rows.hasNext()) {
               HSSFRow row = (HSSFRow) rows.next();
               Iterator cells = row.cellIterator();
               while (cells.hasNext()) {
                  HSSFCell cell = (HSSFCell) cells.next();
                  //if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                     data.add(cell.getRichStringCellValue().getString());
                //  }
               }
            } 
    }
    
    
    
    /* public void readExcelFile(File excelFile){
        InputStream excelStream = null;
        try {
            excelStream = new FileInputStream(excelFile);
            // High level representation of a workbook.
            // Representación del más alto nivel de la hoja excel.
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
            // We chose the sheet is passed as parameter. 
            // Elegimos la hoja que se pasa por parámetro.
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            // An object that allows us to read a row of the excel sheet, and extract from it the cell contents.
            // Objeto que nos permite leer un fila de la hoja excel, y de aquí extraer el contenido de las celdas.
            HSSFRow hssfRow;
            // Initialize the object to read the value of the cell 
            // Inicializo el objeto que leerá el valor de la celda
            HSSFCell cell;                        
            // I get the number of rows occupied on the sheet
            // Obtengo el número de filas ocupadas en la hoja
            int rows = hssfSheet.getLastRowNum();
            // I get the number of columns occupied on the sheet
            // Obtengo el número de columnas ocupadas en la hoja
            int cols = 0;            
            // A string used to store the reading cell
            // Cadena que usamos para almacenar la lectura de la celda
            String cellValue;  
            // For this example we'll loop through the rows getting the data we want
            // Para este ejemplo vamos a recorrer las filas obteniendo los datos que queremos            
            for (int r = 0; r < rows; r++) {
                hssfRow = hssfSheet.getRow(r);
                if (hssfRow == null){
                    break;
                }else{
                    System.out.print("Row: " + r + " -> ");
                    for (int c = 0; c < (cols = hssfRow.getLastCellNum()); c++) {
                        /* 
                            We have those cell types (tenemos estos tipos de celda): 
                                CELL_TYPE_BLANK, CELL_TYPE_NUMERIC, CELL_TYPE_BLANK, CELL_TYPE_FORMULA, CELL_TYPE_BOOLEAN, CELL_TYPE_ERROR
                        */
         /*               cellValue = hssfRow.getCell(c) == null?"": hssfRow.getCell(c).getStringCellValue();
                                                      
                        System.out.print("[Column " + c + ": " + cellValue + "] ");
                    }
                    System.out.println();
                }
            }            
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
        } catch (IOException ex) {
            System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
        } finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
                System.out.println("Error in file processing after close it (Error al procesar el fichero después de cerrarlo): " + ex);
            }
        }
    }*/
    
}
