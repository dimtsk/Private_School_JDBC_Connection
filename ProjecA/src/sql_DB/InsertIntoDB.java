
package sql_DB;

import Entities.Assignment;
import Entities.Course;
import Entities.Student;
import Entities.Trainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InsertIntoDB extends SQLmethods{
    
    private static String INSERT_STUDENT="INSERT INTO student"
            + "(first_name, last_name, date_of_birth, tuition_Fees) VALUES (?,?,?,?)";
    private static String INSERT_TRAINER="INSERT INTO trainer"
            + "(first_name, last_name, subject) VALUES (?,?,?)";
    private static String INSERT_COURSE="INSERT INTO course"
            + "(subject,stream,type,start_date,end_date) VALUES (?,?,?,?,?)";
    private static String INSERT_ASSIGNMENT="INSERT INTO assignment"
            + "(title,description,sub_date_time,oral_mark,total_mark) VALUES (?,?,?,?,?)";
    
    
    /*
        -------------------------------------------------------------------------------------------------------------
        ADD STUDENT
        -------------------------------------------------------------------------------------------------------------
        */  
    public void create(Student student){
            Connection conn=getConnection();
            PreparedStatement p=null;
        try {
            p = conn.prepareStatement(INSERT_STUDENT);
            p.setString(1, student.getFirstName());           
            p.setString(2, student.getSurName());   
            LocalDate date=student.getDateOfBirth();
            java.sql.Date sqlDate=java.sql.Date.valueOf(date);
            p.setDate(3, sqlDate);           
            p.setInt(4, student.getTuitionFees());           
          
            int result=p.executeUpdate(); 
            if(result==1){
                System.out.println("Student successfully created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(p,conn);
        }
        }
    
    /*
        -------------------------------------------------------------------------------------------------------------
        ADD TRAINER  
        -------------------------------------------------------------------------------------------------------------
        */  
    public void create(Trainer trainer){
            Connection conn=getConnection();
            PreparedStatement p=null;
        try {
            p = conn.prepareStatement(INSERT_TRAINER);
            p.setString(1, trainer.getFirstName());           
            p.setString(2, trainer.getSurName());   
            p.setString(3, trainer.getSubject());   
            int result=p.executeUpdate(); 
            if(result==1){
                System.out.println("Trainer successfully created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(p,conn);
        }
        }
    /*
        -------------------------------------------------------------------------------------------------------------
        ADD COURSE   
        -------------------------------------------------------------------------------------------------------------
        */  
    public void create(Course course){
            Connection conn=getConnection();
            PreparedStatement p=null;
        try {
            p = conn.prepareStatement(INSERT_COURSE);
            p.setString(1, course.getTitle()); 
            p.setString(2, course.getStream()); 
            p.setString(3, course.getType()); 
            LocalDate start=course.getStart_date();
            java.sql.Date sqlDate1=java.sql.Date.valueOf(start);
            p.setDate(4, sqlDate1);
            LocalDate end=course.getEnd_date();            
            java.sql.Date sqlDate2=java.sql.Date.valueOf(end);                      
            p.setDate(5, sqlDate2);           
          
            int result=p.executeUpdate(); 
            if(result==1){
                System.out.println("Course successfully created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(p,conn);
        }
        }
    /*
        -------------------------------------------------------------------------------------------------------------
        ADD ASSIGNMENT   
        -------------------------------------------------------------------------------------------------------------
        */  
    public void create(Assignment assignment){
            Connection conn=getConnection();
            PreparedStatement p=null;
        try {
            p = conn.prepareStatement(INSERT_ASSIGNMENT);
            p.setString(1, assignment.getTitle());
            p.setString(2, assignment.getDescription());
            LocalDate sdt=assignment.getSubDateTime();
            java.sql.Date sqlDate=java.sql.Date.valueOf(sdt);
            p.setDate(3, sqlDate); 
            p.setInt(4, assignment.getOralMark());
            p.setInt(5, assignment.getTotalMark());
          
            int result=p.executeUpdate(); 
            if(result==1){
                System.out.println("Assignment successfully created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(p,conn);
        }
        }
}
