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
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
    Arbol_Binario b;
    private List<Categoria> nuevasCategorias;

    /**
     * Constructor for objects of class VentanaPrincipal
     */
    public VentanaPrincipal()
    {
        nuevasCategorias = new ArrayList<>();
        controlador  = new Controlador();
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setLayout(null);
        this.setSize(800, 600);
        this.setResizable(true);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int)(size.getWidth()-this.getWidth())/2,(int)(size.getHeight()-this.getHeight())/2 );
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(false);
        this.setVisible(true);
        //JPanel
        JPanel jpTop = new JPanel();

        jpTop.setSize(new Dimension((int)this.getWidth()-100,100));
        buscar = new JButton();
        buscar.setText("Buscar por categoría");
        JButton reset = new JButton();
        reset.setText("Restaurar"); 

        JButton agregarNueva = new JButton();
        agregarNueva.setText("Agregar Categoría"); 
        JPanel jpTabla= new JPanel();

        //JLabel
        JLabel jl = new JLabel("*Para agregar datos en la nueva categoría ");
        jl.setBounds(40, 600, 400, 200);
        JLabel jl2 = new JLabel("dar doble click sobre el nombre en la lista*");
        jl2.setBounds(40, 625, 400, 200);
        //JTextField
        tfNombreVideo = new JTextField(20);
        tfCategoria = new JTextField(20);
        tfNombreACtor = new JTextField(20);

        tfPais = new JTextField(20);
        // el TextPrompt para los JTextField
        TextPrompt txt = new TextPrompt("Buscar título de película", tfNombreVideo);
        TextPrompt txt2 = new TextPrompt("Buscar por categoría...", tfCategoria);
        TextPrompt txt3 = new TextPrompt("Buscar por nombre de actor...", tfNombreACtor);
        TextPrompt txt4 = new TextPrompt("Buscar por país...", tfPais);

        txt.changeAlpha(0.75f);
        txt2.changeAlpha(0.75f);
        txt3.changeAlpha(0.75f);
        txt4.changeAlpha(0.75f);        
        //JTable
        modelo = new DefaultTableModel(new String[][] {}, new String[] {"Título", "Casting", "País","Tipo","Director","Año","Audiencia","Duración","Categoría","Agregada en"});

        jt= new JTable(modelo) {
            public boolean editCellAt(int fila, int columna, EventObject e) {
                return false;    
            }
        };

        JScrollPane js= new JScrollPane(jt);
        js.setBounds(40,120, (int)this.getWidth()-100, (int)this.getHeight()/2);

        //  this.setSize(900, 600);
        // this.setResizable(false);
        // this.setLocation((int)(size.getWidth()-this.getWidth())/2,(int)(size.getHeight()-this.getHeight())/2 );

        jpTop.add(tfNombreVideo);
        jpTop.add(tfNombreACtor);
        jpTop.add(tfPais);
        jpTop.add(tfCategoria);
        jpTop.add(buscar);
        jpTop.add(reset);
        jpTop.add(agregarNueva);
        //jpTabla.add(jt);

        this.add(jpTop);
        this.add(jl);
        this.add(jl2);
        this.add(js);  
        

        //readExcelFile(new File("netflix_titles.csv"));
        try{
            controlador.readExcelFile();
            // controlador.leerCSV();
        }catch(Exception ex){
            System.out.print(ex);
        }

        controlador.llenarCategorias(); 
        controlador.ordenarDatos();
        controlador.insertarVideosCategorias(controlador.getArbol());
        llenarDatosIniciales(controlador.getListaVideo());
        buscarVideoTitulo();
        buscarVideoActor();
        buscarVideoPais();
        reset.addActionListener(evt->{
                if(tfCategoria != null && tfCategoria.getText().length()>0){
                    while (modelo.getRowCount() > 0)
                    {
                        modelo.removeRow(0);
                    }
                    tfCategoria.setText("");
                    llenarDatosIniciales(controlador.getListaVideo());
                }
            });
        buscar.addActionListener(evt->{
                cambios();
                buscarListaxCategoria(controlador.getArbol());
            });
        agregarNueva.addActionListener(evt->{

                String name = JOptionPane.showInputDialog("Nombre de la nueva categoría");
                JOptionPane.showMessageDialog(null, "La categoria " + name+" se agregó correctamente");  
                if(name !=null && name.length() > 0){
                    Categoria nueva = new Categoria(name);
                    nuevasCategorias.add(nueva);
                    controlador.agregarNuevaCategorias(nueva);
                }

            });
        JFrame f = this;
         /**
     * El doble click para agregar a la nueva categoría.
     */
        jt.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent eve ) {
                    if(nuevasCategorias.size() > 0){
                        if(eve.getClickCount()==2 && jt.getSelectedRow()!=-1) {

                            String[] list = {"A", "B", "C"};
                            JComboBox jcb = new JComboBox(nuevasCategorias.toArray());
                            JOptionPane.showMessageDialog( null, jcb, "Seleccione su categoria", JOptionPane.QUESTION_MESSAGE);
                            Video video = controlador.getListaVideo().get(jt.getSelectedRow());
                            video.setCategoria(video.getCategoria()+", "+jcb.getSelectedItem().toString());
                            controlador.insertarVideosCategoriasNuevo(video, jcb.getSelectedItem().toString());
                            JOptionPane.showMessageDialog(null, "Se agrego correctamente el video a la categoría.");
                            
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Debe agregar categorías.");

                    
                    }
                }
            });
    }
    
    /**
     * Llana la lista.
     * 
     * @param videos(List<Video> )
     * 
     */
    public void llenarDatosIniciales(List<Video> videos){
        for(Video video : videos ){
            modelo.addRow(new String[] {
                    video.getTitulo(),
                    video.getCasting(), 
                    video.getPais(), 
                    video.getTipo(),
                    video.getDirector(),
                    video.getAño_produccion(),
                    video.getAudiencia(),
                    video.getDuracion(),
                    video.getCategoria(),
                    video.getFecha_agregacion()});
        }
    }
    
    /**
     * busca en la Lista por Categoria.
     * 
     * @param arbol(Arbol_Binario)
     * 
     */
    public void buscarListaxCategoria(Arbol_Binario arbol){
        if(tfCategoria.getText().toUpperCase() != null && tfCategoria.getText().length()>0){
            while (modelo.getRowCount() > 0)
            {
                modelo.removeRow(0);
            }
            List<Video> vi = controlador.buscarCategoria(tfCategoria.getText().toUpperCase(), arbol);
            if( vi != null){
                llenarDatosIniciales(vi);
            }else{
                JOptionPane.showMessageDialog(null, "No existe la categoría buscada.");
            }

        }
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    /**
     * llama los datos.
     */
    public void cambios2(){
        try{
            controlador.readExcelFile();
            controlador.llenarCategorias();
            controlador.getListaVideo().clear();
            controlador.ordenarDatos();
        }catch(Exception ex){
            System.out.print(ex);
        } 
    }

      /**
     * llama los datos.
     */
    public void cambios(){
        try{
            controlador.readExcelFile();
            controlador.llenarCategorias();
            controlador.ordenarDatos();
            controlador.insertarVideosCategorias(controlador.getArbol());
        }catch(Exception ex){
            System.out.print(ex);
        }    
    }
    
    /**
     * busca Video por Titulo.
     */
    public void buscarVideoTitulo(){
        tfNombreVideo.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    cambios2();
                    JTextField textField = (JTextField) e.getSource();
                    String text = textField.getText();
                    while (modelo.getRowCount() > 0)
                    {
                        modelo.removeRow(0);
                    }
                    List<Video> vi = controlador.buscarVideoTitulo(text);
                    if( vi != null){
                        llenarDatosIniciales(vi);
                    }else{
                        System.out.println("lista null");
                    }
                }
            });  
    }
    
     /**
     * busca Video por Actor.
     */
    public void buscarVideoActor(){
        tfNombreACtor.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    cambios2();
                    JTextField textField = (JTextField) e.getSource();
                    String text = textField.getText();
                    while (modelo.getRowCount() > 0)
                    {
                        modelo.removeRow(0);
                    }
                    List<Video> vi = controlador.buscarVideoActor(text);
                    if( vi != null){
                        llenarDatosIniciales(vi);
                    }else{
                        System.out.println("lista null");
                    }
                }
            });  
    }
    
     /**
     * busca Video por Pais.
     */
    public void buscarVideoPais(){
        tfPais.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    cambios2();
                    JTextField textField = (JTextField) e.getSource();
                    String text = textField.getText();
                    while (modelo.getRowCount() > 0)
                    {
                        modelo.removeRow(0);
                    }
                    List<Video> vi = controlador.buscarVideoPais(text);
                    if( vi != null){
                        llenarDatosIniciales(vi);
                    }else{
                        System.out.println("lista null");
                    }
                }
            });  
    }

}
