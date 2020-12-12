/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dotha
 */
public class FileHandler {
    private String filename;
    private StudentView view;

    public FileHandler(String filename, StudentView view) {
	this.filename = filename;
	this.view = view;
    }
    
    

    public String getFilename() {
        return filename;
    }
    
    public ArrayList<Student> getStudentsList () throws IOException, IllegalArgumentException, NumberFormatException{
        ArrayList<Student> studentsList= new ArrayList<Student>();
        File file= new File(this.getFilename());
        Scanner scanner= new Scanner(file);
        while(scanner.hasNextLine()){
            boolean hasEx=false;
            int id=0;
            try{
                id=Integer.parseInt(scanner.nextLine());
            }
            catch(NumberFormatException e){
                hasEx=true;
            }
            String name=scanner.nextLine();
            String className=scanner.nextLine();
            double grade=0;
            try{
                grade=Double.parseDouble(scanner.nextLine());
            }
            catch(NumberFormatException e){
                hasEx=true;
            }
            if (!hasEx){
                studentsList.add(new Student(id, name, className, grade));
            }
        }
        return studentsList;
    }
    
    public void saveData(ArrayList<Student> studentsList) throws FileNotFoundException{
	File file= new File(filename);
	if (file.exists()){
	    file.delete();
	}
	try(PrintWriter output= new PrintWriter(file)){
	    studentsList.forEach((el)->{
		output.println(el.getId()+"\n"+el.getName()+"\n"+el.getClassName()+"\n"+el.getGrade());
	    });
	    view.showMessage("Save Successfully");
	}
    }
    
    
}
