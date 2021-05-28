
package sql_DB;

import Entities.Assignment;
import Entities.Course;
import Entities.Student;
import Entities.Trainer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLmethods {
    
    private static String url="jdbc:mysql://localhost:3306/project?useTimezone=true&serverTimezone=UTC";
    private static String user="root";
    private static String password="!d1m1994ts1k0s";
    
    /*------------------------------------------------------------------------------------------------
    CALL METHOD TO CONNECT WITH DB
    ------------------------------------------------------------------------------------------------*/     
    public Connection getConnection(){
        
        Connection connection=null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;    
    }    
    /*------------------------------------------------------------------------------------------------
    CONVERT DATE TO LOCALDATE
    ------------------------------------------------------------------------------------------------*/     
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
    }
    
    /*------------------------------------------------------------------------------------------------
     CLOSE CONNECTION No1
    ------------------------------------------------------------------------------------------------*/     
    public void closeConnections(ResultSet myResult,Statement statement,Connection conn){
        try{       
            myResult.close();
            statement.close();
            conn.close();        
        }catch(SQLException ex){
             Logger.getLogger(SQLmethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*------------------------------------------------------------------------------------------------
     CLOSE CONNECTION No2 (WITHOUT ResultSet)
    ------------------------------------------------------------------------------------------------*/    
    public void closeConnections(Statement statement,Connection conn){
        try{
            statement.close();
            conn.close();        
        }catch(SQLException ex){
             Logger.getLogger(SQLmethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*------------------------------------------------------------------------------------------------
     METHODS TO GET ELEMENTS FROM TABLES WITH MANY TO MANY RELATIONSHIP  
    /*------------------------------------------------------------------------------------------------*/
    /*------------------------------------------------------------------------------------------------
    1o COURSE_STUDENT RELATIONSHIP
    ------------------------------------------------------------------------------------------------*/
    //GET STUDENTS BY ID
    protected Student getStudentById(int id){
        Student student=studentFindById(id);
    return student;
    }
    //FIND STUDENT VIA getStudentById()
    public Student studentFindById(int id){
        Connection conn=getConnection();
        PreparedStatement p=null;
        ResultSet rs=null;
        Student student=null;            
        try { 
            p=conn.prepareStatement("SELECT * FROM student WHERE id=?");
            p.setInt(1, id);
            rs =p.executeQuery();
            rs.next();            
                int ids=rs.getInt("id");
                String f=rs.getString("first_name");
                String l=rs.getString("last_name");
                Date d=rs.getDate("date_of_birth");
                LocalDate dob=d.toLocalDate();
                int fees=rs.getInt("tuition_fees");
                student=new Student(id,f,l,dob,fees);           
        }catch(SQLException ex){
            Logger.getLogger(SQLmethods.class.getName()).log(Level.SEVERE, null, ex);
        }      
       return student;       
    }
    //GET COURSES BY ID
    protected Course getCourseById(int id){
        Course course=courseFindById(id);
    return course;
    }
    //FIND COURSE VIA courseFindById()
    public Course courseFindById(int id){
        Connection conn=getConnection();
        PreparedStatement p=null;
        ResultSet rs=null;
        Course course=null;
            
        try { 
            p=conn.prepareStatement("SELECT * FROM course WHERE id=?");
            p.setInt(1, id);
            rs =p.executeQuery();
            rs.next();
                String subj=rs.getString("subject");
                String stream= rs.getString("stream");
                String type= rs.getString("type");               
                Date d1=rs.getDate("start_date");
                Date d2=rs.getDate("end_date");               
                LocalDate startd=d1.toLocalDate();
                LocalDate endd=d2.toLocalDate(); 
                String start=startd.toString();
                String end=endd.toString();
                course=new Course(subj,stream,type,start,end);            
        }catch(SQLException ex){
            Logger.getLogger(SQLmethods.class.getName()).log(Level.SEVERE, null, ex);
        }      
       return course;       
    }
    /*------------------------------------------------------------------------------------------------
    2o COURSE_TRAINER RELATIONSHIP
    ------------------------------------------------------------------------------------------------*/
    //GET TRAINER BY ID
        protected Trainer getTrainerById(int id){
        Trainer trainer=trainerFindById(id);
        return trainer;
        }
    //FIND TRAINER VIA trainerFindById()
        public Trainer trainerFindById(int id){
        Connection conn=getConnection();
        PreparedStatement p=null;
        ResultSet rs=null;
        Trainer trainer=null;            
        try { 
            p=conn.prepareStatement("SELECT * FROM trainer WHERE id=?");
            p.setInt(1, id);
            rs =p.executeQuery();
            rs.next();            
                String f=rs.getString("first_name");
                String l=rs.getString("last_name");
                String s=rs.getString(4);
                trainer=new Trainer(f,l,s);            
        }catch(SQLException ex){
            Logger.getLogger(SQLmethods.class.getName()).log(Level.SEVERE, null, ex);
        }      
       return trainer;       
    }
    /*------------------------------------------------------------------------------------------------
    3o COURSE_ASSIGNMENT RELATIONSHIP
    ------------------------------------------------------------------------------------------------*/  
    //GET ASSIGNMENT BY ID
    protected Assignment getAssignmentById(int id){
        Assignment assignment=assignmentFindById(id);
    return assignment;
    }   
    //FIND ASSIGNMENT VIA aiignmentFindById()
    public Assignment assignmentFindById(int id){
        Connection conn=getConnection();
        PreparedStatement p=null;
        ResultSet rs=null;
        Assignment assignment=null;
            
        try { 
            p=conn.prepareStatement("SELECT * FROM assignment WHERE id=?");
            p.setInt(1, id);
            rs =p.executeQuery();
            rs.next();
                int assignmentId=rs.getInt("id");
                String title=rs.getString("title");
                String description=rs.getString("description");
                Date d=rs.getDate("sub_date_time");
                LocalDate sdt=d.toLocalDate();
                int oral=rs.getInt("oral_mark");
                int total=rs.getInt("total_mark");                
                assignment=new Assignment(assignmentId,title,description,sdt,oral,total);            
        }catch(SQLException ex){
            Logger.getLogger(SQLmethods.class.getName()).log(Level.SEVERE, null, ex);
        }      
       return assignment;       
    }
    /*------------------------------------------------------------------------------------------------
    4o STUDENT_ASSIGNMENT RELATIONSHIP (ALL METHODS ARE ALREADY BUILT
    ------------------------------------------------------------------------------------------------*/  
    //GET STUDENT BY ID
    //FIND STUDENT VIA getStudentById()
    //GET ASSIGNMENT BY ID
    //FIND ASSIGNMENT VIA aiignmentFindById()
}
