package swingmvclab;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/*
 * A hallgatók adatait tároló osztály.
 */
public class StudentData extends AbstractTableModel {

    /*
     * Ez a tagváltozó tárolja a hallgatói adatokat.
     * NE MÓDOSÍTSD!
     */
    List<Student> students = new ArrayList<Student>();
    
    @Override
    public int getColumnCount() {
    	return 4;
    }
    
    @Override
    public int getRowCount() {
    	return students.size();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	 Student student = students.get(rowIndex);
    	 switch(columnIndex) {
	    	 case 0: return student.getName();
	    	 case 1: return student.getNeptun();
	    	 case 2: return student.hasSignature();
	    	 default: return student.getGrade();
    	 }
    }
    
    @Override
    public String getColumnName(int column) {
    	switch(column) {
    	case 0: return "Név";
    	case 1: return "Neptun";
    	case 2: return "Aláírás";
    	case 3: return "Jegy";
    	}
    	return "";
    }
    
    @Override
    public Class getColumnClass(int column) {
//    	return getValueAt(0,column).getClass();
    	switch(column) {
    	case 2: return Boolean.class;
    	case 3: return Integer.class;
    	default: return String.class;
    	}
    	
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
    	if(col >= 2) return true;
    	return false;
    }
    
    @Override
    public void setValueAt(Object val, int row, int col) {
    	if(col==2) {
    		students.get(row).setSignature((boolean)val);
    	}
    	else if(col == 3) {
    		students.get(row).setGrade((int)val);
    	}
    	fireTableCellUpdated(row, col);
    }
    
    public void addStudent(String name, String neptun) {
    	students.add(new Student(name, neptun, false, 0));
    	fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    
    
    
}
