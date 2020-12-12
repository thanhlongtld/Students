/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class StudentDataControl {
    private FileHandler file;
    private ArrayList<Student> studentsList;
    private StudentView view;

    public StudentDataControl(FileHandler file, StudentView view) {
	this.file = file;
	this.view = view;
    }
    

    public ArrayList<Student> getStudentsList() throws IOException {
	ArrayList<Student> studentsList= file.getStudentsList();
	return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
	this.studentsList = studentsList;
	view.setStudentsList(studentsList);
    }
    
    
}
