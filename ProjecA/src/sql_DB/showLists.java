
package sql_DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entities.Assignment;
import Entities.Course;
import Entities.Student;
import Entities.Trainer;
import projecta.UsefulMethods;


public class showLists extends SQLmethods {
    UsefulMethods input=new UsefulMethods();
    /*
        -------------------------------------------------------------------------------------------------------------
        RETURNS ALL TRAINERS FROM DB
        -------------------------------------------------------------------------------------------------------------
        */
    public List<Trainer> getTrainerList(){                                         
        ArrayList<Trainer> list=new ArrayList();
        Connection conn=getConnection();
        Statement statement=null;
        ResultSet rs=null;                
        try{       
            statement=conn.createStatement();       
            rs=statement.executeQuery("select * from trainer");        
            while(rs.next()){
                int id=rs.getInt("id");
                String f=rs.getString("first_name");
                String l=rs.getString("last_name");
                String subj=rs.getString("subject");
                Trainer trainer=new Trainer(id,f,l,subj);
                list.add(trainer);
            }
        }catch(SQLException ex){
             Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(rs,statement,conn);
        }        
        return list; 
    }
    /*
        -------------------------------------------------------------------------------------------------------------
        RETURNS ALL COURSES FROM DB
        -------------------------------------------------------------------------------------------------------------
        */
    public List<Course> getCourseList(){
       Connection connection=getConnection();
       String query="SELECT * FROM course";
       Statement statement=null;
       ResultSet rs=null;
       Course course=null;       
       ArrayList<Course> courseList=new ArrayList();       
        try{
            statement=connection.createStatement();
            rs=statement.executeQuery(query);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String subj=rs.getString("subject");
                String stream= rs.getString("stream");
                String type= rs.getString("type");               
                Date d1=rs.getDate("start_date");
                Date d2=rs.getDate("end_date");               
                LocalDate s=d1.toLocalDate();
                LocalDate e=d2.toLocalDate(); 
                String start=s.toString();
                String end=e.toString();
                course=new Course(id,subj,stream,type,start,end);
                courseList.add(course);
            }
        }catch(SQLException ex){
            Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             closeConnections(rs,statement,connection);
        }       
       return courseList;
    }
    /*
        -------------------------------------------------------------------------------------------------------------
        RETURNS ALL STUDENTS FROM DB
        -------------------------------------------------------------------------------------------------------------
        */
    public List<Student> getStudentList(){
       Connection connection=getConnection();
       String query="SELECT * FROM student";
       Statement statement=null;
       ResultSet rs=null;
       Student student=null;       
       ArrayList<Student> studentList=new ArrayList();       
        try{
            statement=connection.createStatement();
            rs=statement.executeQuery(query);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String f=rs.getString("first_name");
                String l=rs.getString("last_name");
                Date d=rs.getDate("date_of_birth");
                LocalDate date=d.toLocalDate();
                int fees=rs.getInt("tuition_fees");

                student=new Student(id,f,l,date,fees);
                studentList.add(student);
            }
        }catch(SQLException ex){
            Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(rs,statement,connection);
        }       
       return studentList;
    }
    /*
        -------------------------------------------------------------------------------------------------------------
        RETURNS ALL ASSIGNMENTS FROM DB
        -------------------------------------------------------------------------------------------------------------
        */
        public List<Assignment> getAssignmentList() {
            ArrayList<Assignment> list=new ArrayList();
            Connection conn=getConnection();
            Statement statement=null;
            ResultSet myResult=null;   
            Assignment assignment=null;
        
        try{       
            statement=conn.createStatement();       
            myResult=statement.executeQuery("select * from assignment");        
            while(myResult.next()){
                int assignmentId=myResult.getInt("id");
                String title=myResult.getString("title");
                String description=myResult.getString("description");
                Date d=myResult.getDate("sub_date_time");
                LocalDate sdt=d.toLocalDate();
                int oral=myResult.getInt("oral_mark");
                int total=myResult.getInt("total_mark");
                
                assignment=new Assignment(assignmentId,title,description,sdt,oral,total);
                list.add(assignment);
            }
        }catch(SQLException ex){
             Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(myResult,statement,conn);
        }        
        return list; 
    }
    /*
        -------------------------------------------------------------------------------------------------------------
        RETURNS ALL STUDENTS PER COURSE   
        -------------------------------------------------------------------------------------------------------------
        */
        public void findStudentsPerCourses(){
            
            Connection conn=getConnection();
            Statement st=null;
            ResultSet rs=null;
            Course course=null;
            Student student=null;   
            System.out.format("%-8s", "id");
            System.out.format("%-18s", "Subject");
            System.out.format("%-18s", "Firstname");
            System.out.format("%-18s", "Lastname");  
            input.underline();
            try{
            st=conn.createStatement();       
            rs=st.executeQuery("select * from course_student"); 
            while(rs.next()){
                int i=rs.getInt("id");
                int courseId=rs.getInt("st_subj_id");
                course=getCourseById(courseId);
                int studentId=rs.getInt("st_id");
                student=getStudentById(studentId);
                System.out.println("");
                System.out.format("%-8s%-18s%-18s%-18s", i, course.getTitle(), student.getFirstName(), student.getSurName() );

            }
                
            }catch(SQLException ex){
             Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                closeConnections(rs,st,conn);
            }                    
        }
    /*
        -------------------------------------------------------------------------------------------------------------
        RETURNS ALL TRAINERS PER COURSES    
        -------------------------------------------------------------------------------------------------------------
        */        
        public void findTrainersPerCourses(){
            Connection conn=getConnection();
            Statement st=null;
            ResultSet rs=null;
            Course course=null;
            Trainer trainer=null;               
            System.out.format("%-8s", "id");
            System.out.format("%-18s", "Subject");            
            System.out.format("%-18s", "Firstname");
            System.out.format("%-18s", "Lastname");
            input.underline();           
            try{            
            st=conn.createStatement();       
            rs=st.executeQuery("select * from course_trainer"); 
            while(rs.next()){
                int i=rs.getInt("id");
                int courseId=rs.getInt("tr_subj_id");
                course=getCourseById(courseId);
                int trainerId=rs.getInt("tr_id");
                trainer=getTrainerById(trainerId);  
                System.out.println("");
                System.out.format("%-8s%-18s%-18s%-18s", i, course.getTitle(), trainer.getFirstName(), trainer.getSurName() );                
            }                
            }catch(SQLException ex){
             Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                closeConnections(rs,st,conn);
            }                    
        }
    /*
        -------------------------------------------------------------------------------------------------------------
        RETURNS ALL ASSIGNMENTS PER COURSES    
        -------------------------------------------------------------------------------------------------------------
        */      
         public void findAssignmentPerCourse(){
            Connection conn=getConnection();
            Statement st=null;
            ResultSet rs=null;
            Course course=null;
            Assignment assignment=null;   
            System.out.format("%-8s", "id");
            System.out.format("%-18s", "Subject");            
            System.out.format("%-25s", "Title");
            System.out.format("%-18s", "Description");
            System.out.format("%-18s", "Sub Date Time");
            input.underline();            
            try{
            
            st=conn.createStatement();       
            rs=st.executeQuery("select * from course_assign"); 
            while(rs.next()){
                int i=rs.getInt("id");
                int courseId=rs.getInt("as_subj_id");
                course=getCourseById(courseId);
                int assignmentId=rs.getInt("as_id");
                assignment=getAssignmentById(assignmentId);
                System.out.println("");
                System.out.format("%-8s%-18s%-25s%-18s%-18s", i, course.getTitle(), assignment.getTitle(), 
                        assignment.getDescription(), assignment.getSubDateTime() );
            }
                
            }catch(SQLException ex){
             Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                closeConnections(rs,st,conn);
            }                    
        }
    /*
        -------------------------------------------------------------------------------------------------------------
        RETURNS ALL ASSIGNMENTS PER STUDENT    
        -------------------------------------------------------------------------------------------------------------
        */      
            public void findAssignmentsPerStudent(){
            Connection conn=getConnection();
            Statement st=null;
            ResultSet rs=null;
            Student student=null;
            Assignment assignment=null;               
            System.out.format("%-8s", "id");
            System.out.format("%-18s", "Firstname");            
            System.out.format("%-18s", "Lastname");
            System.out.format("%-18s", "Title");
            System.out.format("%-18s", "Description");
            System.out.format("%-18s", "Sub Date Time");
            input.underline();            
            try{            
            st=conn.createStatement();       
            rs=st.executeQuery("select * from assign_student"); 
            while(rs.next()){
                int i=rs.getInt("id");               
                int assignmentId=rs.getInt("assign_id");
                assignment=getAssignmentById(assignmentId);
                int studentId=rs.getInt("assign_st_id");
                student=getStudentById(studentId);   
                System.out.println("");
                System.out.format("%-8s%-18s%-18s%-25s%-18s%-18s",
                        i, student.getFirstName(), student.getSurName(), assignment.getTitle(),
                assignment.getDescription(), assignment.getSubDateTime() );
            }                
            }catch(SQLException ex){
             Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                closeConnections(rs,st,conn);
            }          
        }
        /*
        -------------------------------------------------------------------------------------------------------------
        RETURNS STUDENTS WITH MORE THAN ONE COURSES 
        -------------------------------------------------------------------------------------------------------------
        */  
            public void findStudentsWithMoreThanOneCourses(){
                Connection conn=getConnection();
                String query="select * "
                        + "from course_student "
                        + "inner join student on course_student.st_id=student.id "
                        + "inner join course on course_student.st_subj_id=course.id "
                        + "group by st_id having count(*)>1";
                Statement st=null;
                ResultSet rs=null;
                Student student=null;
                Course course=null;   
                int i=0;
                System.out.format("%-8s", "id");
                System.out.format("%-18s", "Firstname");            
                System.out.format("%-18s", "Lastname");
                System.out.format("%-8s", "Studentid");
                input.underline();                
                try{            
                st=conn.createStatement();       
                rs=st.executeQuery(query); 

                while(rs.next()){
                    i++;
                    int id=rs.getInt("id");
                    int courseId=rs.getInt("st_subj_id");
                    course=getCourseById(courseId);
                    int studentId=rs.getInt("st_id");
                    student=getStudentById(studentId);
                    System.out.println("");
                    System.out.format("%-8s%-18s%-18s%-8s",i,student.getFirstName(), student.getSurName(), id);
                    }              
                }catch(SQLException ex){
                 Logger.getLogger(showLists.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    closeConnections(rs,st,conn);
                }   
            }
            
}
