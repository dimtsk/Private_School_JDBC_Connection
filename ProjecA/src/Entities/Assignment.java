
package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class Assignment {
    
    private int id;
    private String title;
    private String description;
    private LocalDate subDateTime;
    private int oralMark;
    private int  totalMark;
    private ArrayList<Student> students=new ArrayList<>();
    private ArrayList<Course> courses;
    public static ArrayList<Assignment> allAssignments= new ArrayList<>();
   
    
    // CONSTRUCTOR
    public Assignment() {
    }

    public Assignment(String title, String description, String subDateTime, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = LocalDate.parse(subDateTime);
        this.oralMark = oralMark;
        this.totalMark=totalMark;
    }

    public Assignment(int id, String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }
    
    public int getId() {
        return id;
    }

    // GETTERS AND SETTERS
    public void setId(int id) {    
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public static ArrayList<Assignment> getAllAssignments() {
        return allAssignments;
    }

    public static void setAllAssignments(ArrayList<Assignment> allAssignments) {
        Assignment.allAssignments = allAssignments;
    }

    public static void saveAssignments(Assignment assignment){
        allAssignments.add(assignment);
    } 
    
    // EQUALS AND HASH CODES
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.subDateTime);
        hash = 67 * hash + this.oralMark;
        hash = 67 * hash + this.totalMark;
        hash = 67 * hash + Objects.hashCode(this.students);
        hash = 67 * hash + Objects.hashCode(this.courses);
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
        final Assignment other = (Assignment) obj;
        if (this.oralMark != other.oralMark) {
            return false;
        }
        if (this.totalMark != other.totalMark) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.subDateTime, other.subDateTime)) {
            return false;
        }
        if (!Objects.equals(this.students, other.students)) {
            return false;
        }
        if (!Objects.equals(this.courses, other.courses)) {
            return false;
        }
        return true;
    }

    // TOSTRING
    @Override
    public String toString() {
        return String.format(" %-5s%-22s%-20s%-20s%-15s%-15s", id, title, description, subDateTime, oralMark, totalMark);

    }
    
         public void addStudent(Student student){
        this.students.add(student);
    }   
}
