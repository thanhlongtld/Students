/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author dotha
 */
public class StudentView extends JFrame{
    private JLabel idLabel,nameLabel,classLabel,gradeLabel;
    private JTextField idField,nameField,classField,gradeField;
    private JButton addButton, editButton, deleteButton, clearButton, sortByGpaButton, sortByNameButton;
    private JTable infoTable;
    public StudentView() {
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
        editButton= new JButton("Edit");
        deleteButton= new JButton("Delete");
        clearButton= new JButton("Clear");
        sortByGpaButton= new JButton("Sort By GPA");
        sortByNameButton= new JButton("Sort By Name");
        
        
        
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(classLabel);
        panel.add(gradeLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(classField);
        panel.add(gradeField);
        
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(sortByGpaButton);
        panel.add(sortByNameButton);
        
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
        
        layout.putConstraint(SpringLayout.NORTH, editButton, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editButton, 110, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, deleteButton, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteButton, 210, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, clearButton, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearButton, 310, SpringLayout.WEST, panel);
        
        
        this.add(panel);
        this.pack();
        this.setSize(1000,1000);
        this.setTitle("Student Control");
        
        FileHandler fileHandler= new FileHandler("STUDENTS.INP");
        ArrayList<Student> studentsList= new ArrayList<Student>();
        try{
        studentsList= fileHandler.getStudentsList();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.exit(1);
        }
        
        this.setVisible(true);
        
    }
    
}
