package swingmvclab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * A megjelenítendõ ablakunk osztálya.
 */
public class StudentFrame extends JFrame {
    
    /*
     * Ebben az objektumban vannak a hallgatói adatok.
     * A program indulás után betölti az adatokat fájlból, bezáráskor pedig kimenti oda.
     * 
     * NE MÓDOSÍTSD!
     */
    private StudentData data;
    
    
    public class BtnActionListener implements ActionListener{
    	JTextField f1, f2;
    	
    	public BtnActionListener(JTextField f1, JTextField f2) {
    		this.f1 = f1;
    		this.f2 = f2;
    	}
    	
    	public void actionPerformed(ActionEvent ae) {
    		if(ae.getActionCommand().equals("click")) {
    			data.addStudent(f1.getText(), f2.getText());
    		}
    	}
    }
    
    
    /*
     * Itt hozzuk létre és adjuk hozzá az ablakunkhoz a különbözõ komponenseket
     * (táblázat, beviteli mezõ, gomb).
     */
    private void initComponents() {
        this.setLayout(new BorderLayout());
        
        JTable table = new JTable();
        table.setModel(data);
        
        JPanel center = new JPanel(new BorderLayout());
        JScrollPane jspane = new JScrollPane(table);        //hogy teszem CENTERBE?? Errort ad
        table.setFillsViewportHeight(true);
        center.add(jspane, BorderLayout.CENTER);
        
        
        //add JPanel
        JPanel south = new JPanel();
        
        String nameField = "Név:";
        String neptunField = "Neptun:";
        
        JLabel nevLabel = new JLabel(nameField);
        JTextField nevTextField = new JTextField(20);
        JLabel neptunLabel = new JLabel(neptunField);
        JTextField neptunTextField = new JTextField(6);
        JButton submit = new JButton("Felvesz");
        
        south.add(nevLabel);
        south.add(nevTextField);
        south.add(neptunLabel);
        south.add(neptunTextField);
        south.add(submit);
        
        center.add(south, BorderLayout.SOUTH);
        
        add(center);
        
        submit.setActionCommand("click");
        BtnActionListener bl = new BtnActionListener(nevTextField, neptunTextField);
        submit.addActionListener(bl);
        
        
        
    }

    /*
     * Az ablak konstruktora.
     * 
     * NE MÓDOSÍTSD!
     */
    @SuppressWarnings("unchecked")
    public StudentFrame() {
        super("Hallgatói nyilvántartás");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Induláskor betöltjük az adatokat
        try {
            data = new StudentData();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            data.students = (List<Student>)ois.readObject();
            ois.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        // Bezáráskor mentjük az adatokat
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
                    oos.writeObject(data.students);
                    oos.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Felépítjük az ablakot
        setMinimumSize(new Dimension(500, 200));
        initComponents();
    }

    /*
     * A program belépési pontja.
     * 
     * NE MÓDOSÍTSD!
     */
    public static void main(String[] args) {
        // Megjelenítjük az ablakot
        StudentFrame sf = new StudentFrame();
        sf.setVisible(true);
    }
}
