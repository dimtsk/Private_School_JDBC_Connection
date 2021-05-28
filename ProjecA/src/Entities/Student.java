
package Entities;

import Entities.Course;
import Entities.Assignment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;



public class Student {
    
    private int id;
    private String firstName;
    private String surName;
    private int tuitionFees;
    private LocalDate dateOfBirth;    
    private static ArrayList<Student> allStudents = new ArrayList();

    //CONSTRUCTORS
    public Student() {
    }

    public Student(String firstName, String surName,  String dateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.tuitionFees = tuitionFees;

    }

    public Student(int id, String firstName, String surName, LocalDate dateOfBirth, int tuitionFees) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.tuitionFees = tuitionFees;
        this.dateOfBirth = dateOfBirth;
    }
        
    
    //GETTERS AND SETTERS
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public static void setAllStudents(ArrayList<Student> allStudents) {
        Student.allStudents = allStudents;
    }
    
    public static void saveStudent(Student student){
        allStudents.add(student);
    }
    
    //EQUALS AND HASHCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.firstName);
        hash = 71 * hash + Objects.hashCode(this.surName);
        hash = 71 * hash + this.tuitionFees;
        hash = 71 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.tuitionFees != other.tuitionFees) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.surName, other.surName)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;
    }

    //TOSTRING
    @Override
    public String toString() {
        return String.format(" %-5s%-22s%-20s%-20s%-15s", id, firstName, surName, tuitionFees, dateOfBirth);
    }
    
    //METHODS
    public ArrayList<Course> getCourses(){
        ArrayList<Course> c=new ArrayList<>();
        for(Course course:Course.getAllCourses()){
            if(course.getStudents().contains(this)){
                c.add(course);
            }
            
        }
        return c;
    }
    
    public ArrayList<Assignment> getAssignments(){
        ArrayList<Assignment> a=new ArrayList<>();
        for(Course course:this.getCourses()){
            for(Assignment assignment:course.getAssignments()){
                a.add(assignment);
            }
        }
        return a;
    }

}
