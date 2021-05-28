 
package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class Course {
    
    private int id;
    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
    private ArrayList<Student> students=new ArrayList<>();
    private ArrayList<Assignment> assignments=new ArrayList<>();
    private ArrayList<Trainer> trainers=new ArrayList<>();
    
    public static  ArrayList<Course> allCourses=new ArrayList<>();
    
    public Course() {
    } 

    public Course(String title, String stream, String type, String start_date, String end_date,
                                        ArrayList<Student> students,ArrayList<Assignment> assignments,
                                        ArrayList<Trainer> trainers) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = LocalDate.parse(start_date);
        this.end_date= LocalDate.parse(end_date);
        this.students=students;
        this.trainers=trainers;
        this.assignments=assignments;
    }

    public Course(String title, String stream, String type, String start_date, String end_date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = LocalDate.parse(start_date);
        this.end_date = LocalDate.parse(end_date);
    }

    public Course(int id, String title, String stream, String type, String start_date, String end_date) {
        this.id = id;
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = LocalDate.parse(start_date);
        this.end_date = LocalDate.parse(end_date);
    }
    
    

    //GETTERS AND SETTERS
    public void setId(int id) {    
        this.id = id;
    }

    public int getId() {    
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    public static ArrayList<Course> getAllCourses() {
        return allCourses;
    }

    public static void setAllCourses(ArrayList<Course> allCourses) {
        Course.allCourses = allCourses;
    }

    public static void saveCourses(Course course){
        allCourses.add(course);
    }
    
    public static void addCourse(Course course){
        allCourses.add(course);
    }   
    
    public void addStudents(Student student){
        this.students.add(student);
    }
    
    public void addTrainers(Trainer trainer){
        this.trainers.add(trainer);
    }
    //EQUALS AND HASHCODE
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + Objects.hashCode(this.stream);
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + Objects.hashCode(this.start_date);
        hash = 79 * hash + Objects.hashCode(this.end_date);
        hash = 79 * hash + Objects.hashCode(this.students);
        hash = 79 * hash + Objects.hashCode(this.assignments);
        hash = 79 * hash + Objects.hashCode(this.trainers);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.stream, other.stream)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.start_date, other.start_date)) {
            return false;
        }
        if (!Objects.equals(this.end_date, other.end_date)) {
            return false;
        }
        if (!Objects.equals(this.students, other.students)) {
            return false;
        }
        if (!Objects.equals(this.assignments, other.assignments)) {
            return false;
        }
        if (!Objects.equals(this.trainers, other.trainers)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return String.format(" %-5s%-22s%-20s%-20s%-15s%-15s", id, title, stream, type, start_date, end_date);

    }    
}
