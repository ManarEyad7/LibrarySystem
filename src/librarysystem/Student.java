/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

/**
 *
 *  The Student class that holds general attributes about a student 
 */
public class Student {
    
    private String nameStudent ; // To hold the name of Student.
    private  String phoneNumber ;  // To hold the phone number of Student.
    
    /**
     *  constructor with two arguments
     * @param nameStudent
     * @param phoneNumber 
     */
    public Student(String nameStudent ,String phoneNumber)
    {
        this.nameStudent = nameStudent;
        this.phoneNumber = phoneNumber ; 
    }
    /**
     * A copy constructor
     * @param object 
     */
    public Student(Student object)
    {
        this.nameStudent = object.nameStudent;
        this.phoneNumber = object.phoneNumber ; 
    }
    /**
     * The getNameStudent method
     * @return 
     */
    public String getNameStudent() {
        return nameStudent;
    }
    /**
     * The setNameStudent method
     * @param nameStudent 
     */
    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
    /**
     * The getPhoneNumber method
     * @return 
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * The setPhoneNumber method
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * The toString method 
     * @return Information about the student.
     */
    @Override
    public String toString() {
        return "The Name =" + nameStudent + ", The Phone Number=" + phoneNumber ;
    }
    
    
}
