/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dotha
 */
public class StudentView extends JFrame{
    private JLabel idLabel,nameLabel,classLabel,gradeLabel;
    private JTextField idField,nameField,classField,gradeField;
    private JButton addButton, saveButton, sortByNameButton;
    private JTable infoTable;
    private ArrayList<Student> studentsList;
    private JScrollPane scrollStudentTable;
    private JComboBox filterByClass;
    private String column[]={"ID","NAME","CLASS","GRADE"};
    private Object tableData=new Object[][]{};
    private ArrayList<String> classOptions;
   
    public StudentView() {
	classOptions= new ArrayList<>();
        initComponents();
    }
    public void initComponents(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        JPanel panel= new JPanel();
        panel.setSize(1000,1000);
        SpringLayout layout= new SpringLayout();
        panel.setLayout(layout);
        
        idLabel= new JLabel("ID");
        nameLabel= new JLabel("Name");
        classLabel= new JLabel("Class");
        gradeLabel= new JLabel("Grade");
        
        idField= new JTextField(30);
        nameField= new JTextField(30);
        classField= new JTextField(30);
        gradeField= new JTextField(30);
        
        addButton = new JButton("Add");
        saveButton= new JButton("Save");
	
        filterByClass= new JComboBox(classOptions.toArray());
        sortByNameButton= new JButton("Sort By Name");
        
	scrollStudentTable= new JScrollPane();
	
	infoTable= new JTable();
        infoTable.setModel(new DefaultTableModel((Object[][]) tableData, column));
        scrollStudentTable.setViewportView(infoTable);
	scrollStudentTable.setPreferredSize(new Dimension(480,300));
	
	idField.setEditable(false);
	
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(classLabel);
        panel.add(gradeLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(classField);
        panel.add(gradeField);
        
        panel.add(addButton);
        panel.add(saveButton);
        panel.add(filterByClass);
        panel.add(sortByNameButton);
        
	panel.add(scrollStudentTable);
	
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, classLabel, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, classLabel, 10, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, gradeLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gradeLabel, 10, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, idField, 80, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, nameField, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 80, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, classField, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, classField, 80, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, gradeField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gradeField, 80, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, addButton, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addButton, 10, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, saveButton, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, saveButton, 110, SpringLayout.WEST, panel);
        
	layout.putConstraint(SpringLayout.NORTH, scrollStudentTable, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, scrollStudentTable, 20, SpringLayout.EAST, idField);
        
	layout.putConstraint(SpringLayout.NORTH, filterByClass, 10, SpringLayout.SOUTH, scrollStudentTable);
        layout.putConstraint(SpringLayout.WEST, filterByClass, 0, SpringLayout.WEST, scrollStudentTable);
	
	layout.putConstraint(SpringLayout.NORTH, sortByNameButton, 10, SpringLayout.SOUTH, scrollStudentTable);
        layout.putConstraint(SpringLayout.WEST, sortByNameButton, 10, SpringLayout.EAST, filterByClass);
	
        this.add(panel);
        this.pack();
        this.setSize(1000,1000);
        this.setTitle("Student Control");
        
        this.setVisible(true);
        
    }

    public ArrayList<Student> getStudentsList() {
	return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
	this.studentsList = studentsList;
	int size= studentsList.size();
	Object[][] students= new Object[size][4];
	for (int i=0; i<size; i++){
	    students[i][0]=studentsList.get(i).getId();
	    students[i][1]=studentsList.get(i).getName();
	    students[i][2]=studentsList.get(i).getClassName();
	    students[i][3]=studentsList.get(i).getGrade();
	}
	infoTable.setModel(new DefaultTableModel(students,column));
	int nextID=studentsList.get(studentsList.size()-1).getId()+1;
	idField.setText(Integer.toString(nextID));
	setClassOptions();
    }
    
    public Student getStudentInfo(){
	if (!validate(idField, "id")||!validate(nameField, "name")||!validate(classField, "class")||!validate(gradeField, "grade")){
	    return null;
	}
	return new Student(Integer.parseInt(idField.getText()), nameField.getText(), classField.getText(), Double.parseDouble(gradeField.getText()));
    }
    
    public boolean validate(JTextField fieldBox, String field){
	String value= fieldBox.getText();
	if (value==null||"".equals(value)){
	    fieldBox.requestFocus();
	    showMessage(field+" is required");
	    return false;
	}
	if ("id".equals(field)){
	    try{
		int id= Integer.parseInt(fieldBox.getText());
	    }
	    catch(NumberFormatException e){
		fieldBox.requestFocus();
		showMessage(field+" must be an integer");
		return false;
	    }
	}
	if ("grade".equals(field)){
	try{
		double grade= Double.parseDouble(fieldBox.getText());
	    }
	    catch(NumberFormatException e){
		fieldBox.requestFocus();
		showMessage(field+" must be a float");
		return false;
	    }
	}
	return true;
    }
    
    public void filterStudentList(){
	ArrayList<Student> filteredStudentsList= new ArrayList<Student>();
	
	String className= filterByClass.getSelectedItem().toString();
	if(className=="ALL"){
	    setStudentsList(studentsList);
	    return;
	}
	studentsList.forEach(student->{
	    if (className.equals(student.getClassName())){
		filteredStudentsList.add(student);
	    }
	});
	
	Collections.sort(filteredStudentsList, new Comparator<Student>(){
	    @Override
	    public int compare(Student o1, Student o2) {
		return (o1.getGrade()>o2.getGrade())?1:-1;
	    }
	});
	
	int size= filteredStudentsList.size();
	Object[][] students= new Object[size][4];
	for (int i=0; i<size; i++){
	    students[i][0]=filteredStudentsList.get(i).getId();
	    students[i][1]=filteredStudentsList.get(i).getName();
	    students[i][2]=filteredStudentsList.get(i).getClassName();
	    students[i][3]=filteredStudentsList.get(i).getGrade();
	}
	infoTable.setModel(new DefaultTableModel(students,column));

    }
    
    public void showMessage(String message){
	JOptionPane.showMessageDialog(this, message);
    }
    
    public void setAddButtonListener(ActionListener listener){
	addButton.addActionListener(listener);
    }
    
    public void setSaveButtonListener(ActionListener listener){
	saveButton.addActionListener(listener);
    }

    public void setClassOptions() {
	ArrayList<String> classOptions=new ArrayList<String>();
	classOptions.add("ALL");
	studentsList.forEach((student)->{
	    String className=student.getClassName();
	    if (!classOptions.contains(className)){
		classOptions.add(className);
	    }
	});
	filterByClass.setModel(new DefaultComboBoxModel(classOptions.toArray()));
    }
    public void setFilterByClassListener(ActionListener listener){
	filterByClass.addActionListener(listener);
    }
    
}
