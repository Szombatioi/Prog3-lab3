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
 * A megjelen�tend� ablakunk oszt�lya.
 */
public class StudentFrame extends JFrame {
    
    /*
     * Ebben az objektumban vannak a hallgat�i adatok.
     * A program indul�s ut�n bet�lti az adatokat f�jlb�l, bez�r�skor pedig kimenti oda.
     * 
     * NE M�DOS�TSD!
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
     * Itt hozzuk l�tre �s adjuk hozz� az ablakunkhoz a k�l�nb�z� komponenseket
     * (t�bl�zat, beviteli mez�, gomb).
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
        
        String nameField = "N�v:";
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
     * NE M�DOS�TSD!
     */
    @SuppressWarnings("unchecked")
    public StudentFrame() {
        super("Hallgat�i nyilv�ntart�s");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Indul�skor bet�ltj�k az adatokat
        try {
            data = new StudentData();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            data.students = (List<Student>)ois.readObject();
            ois.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        // Bez�r�skor mentj�k az adatokat
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

        // Fel�p�tj�k az ablakot
        setMinimumSize(new Dimension(500, 200));
        initComponents();
    }

    /*
     * A program bel�p�si pontja.
     * 
     * NE M�DOS�TSD!
     */
    public static void main(String[] args) {
        // Megjelen�tj�k az ablakot
        StudentFrame sf = new StudentFrame();
        sf.setVisible(true);
    }
}
