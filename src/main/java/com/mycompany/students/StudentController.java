/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class StudentController {
    private StudentView view;
    private FileHandler fileHandler;
    private StudentDataControl studentDataControl;
    public StudentController(StudentView view, FileHandler fileHandler) throws IOException {
	this.view = view;
	this.fileHandler = fileHandler;
	ArrayList<Student> studentsList= fileHandler.getStudentsList();
	view.setStudentsList(studentsList);
	view.setClassOptions();
	view.setAddButtonListener(new AddButtonActionListener());
	view.setSaveButtonListener(new AddSaveButtonListener());
	view.setFilterByClassListener(new AddFilerByClassListener());
    }
    public class AddButtonActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	    Student student= view.getStudentInfo();
	    if (student!=null){
		ArrayList<Student> currentStudentsList;
		    currentStudentsList = view.getStudentsList();
		    currentStudentsList.add(student);
		    view.setStudentsList(currentStudentsList);
	    }
	}
	
    }
    public class AddSaveButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	    ArrayList<Student> studentsList= view.getStudentsList();
	    try {
		fileHandler.saveData(studentsList);
	    } catch (FileNotFoundException ex) {
		Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
    }
    
    public class AddFilerByClassListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	    view.filterStudentList();
	}
	
    }
}
