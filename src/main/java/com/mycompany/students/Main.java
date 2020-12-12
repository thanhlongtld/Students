/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students;

import java.io.IOException;

/**
 *
 * @author dotha
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StudentView view= new StudentView();
	FileHandler fileHandler= new FileHandler("STUDENTS.INP", view);
	StudentController controller= new StudentController(view, fileHandler);
    }
}
