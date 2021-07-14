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
        
        controlador  = new Controlador();
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
        modelo = new DefaultTableModel(new String[][] {}, new String[] {"Título", "Casting", "País","Tipo","Director","Año","Audiencia","Duración","Categoría","País","Agregada en"});

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
        controlador.readExcelFile();
        
    }catch(Exception ex){
         System.out.print(ex);
    }
    
         controlador.ordenarDatos();
        
    }
    
    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
  
   
    
}
