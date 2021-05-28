
package projecta;


import Entities.Student;
import Entities.Trainer;
import Entities.Course;
import Entities.Assignment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sql_DB.InsertIntoDB;
import sql_DB.showLists;



public class AddEntities {
    //OBJECT THAT CONTAINS USEFUL METHODS THAT YOU CAN USE MANY TIMES
    static UsefulMethods input=new UsefulMethods();
    static MainMenu menu=new MainMenu();
    static InsertIntoDB insert=new InsertIntoDB();

    
    static boolean choice=true;
    
    // ADD STUDENTS METHOD
    public static void addStudents() {
        while(choice){
        Student student = new Student();
        
        //INSERT STUDENTS INFO
        System.out.println("GIVE STUDENTS INFORMATIOS:");
        System.out.print("FIRSTNAME: ");
        student.setFirstName(input.checkIf_String());
        System.out.print("SURNAME: ");
        student.setSurName(input.checkIf_String()) ;
        System.out.print("DATE OF BIRTH (YYYY-MM-DD): ");
        student.setDateOfBirth((input.localDate()));
        System.out.print("FEES: ");
        student.setTuitionFees(input.onlyNumbers());
        input.underline();
//        Student.saveStudent(student);
        insert.create(student);
        
        
        System.out.println("DO YOU WANT TO ADD ANOTHER STUDENT? Y/N");
            boolean a=input.yesOrNo();
            if(a==true){
                addStudents();
            }
            else{
                menu.addList();
            } 
        }
    }    
         
    // ADD COURSE METHOD
    public static void addCourses(){
        Course course=new Course();

        System.out.println("TITLE:");
        course.setTitle(input.checkIf_String());
        System.out.println("STREAM");
        course.setStream(input.checkIf_String());
        System.out.println("TYPE:");
        course.setType(input.checkIf_String());
        System.out.println("START DATE (YYYY-MM-DD):");
        course.setStart_date(input.localDate());
        System.out.println("END DATE (YYYY-MM-DD):");
        course.setEnd_date(input.localDate());
//        Course.saveCourses(course);
        insert.create(course);
            System.out.println("DO YOU WANT TO ADD ANOTHER COURSE? Y/N");
            boolean a=input.yesOrNo();
            if(a==true){
                addCourses();
            }
            else{
                menu.addList();
            }
    }
    //ADD TRAINER METHOD    
    public static void addTrainers(){
        Trainer trainer=new Trainer();
        while(choice){
            input.underline();
            System.out.println("ADD TRAINER:");
            System.out.print("NAME:");
            trainer.setFirstName(input.checkIf_String());
            System.out.print("SURNAME:");
            trainer.setSurName(input.checkIf_String());
            System.out.print("SUBJECT:");
            trainer.setSubject(input.checkIf_String());   
            input.underline();
//            Trainer.saveTrainer(trainer);
            insert.create(trainer);
            System.out.println("DO YOU WANT TO ADD ANOTHER TRAINER? Y/N");
                boolean a=input.yesOrNo();
                if(a==true){
                    addTrainers();
                }
                else{
                    menu.addList();
                } 
            }    
    }
        
    //ADD ASSIGNMENT METHOD       
    public static void addAssignments(){    
            Assignment assignment=new Assignment();
            while(choice){
                System.out.println("INSERT ASSIGNMENT:");
                System.out.print("TITLE:");
                assignment.setTitle(input.checkIf_String());           
                System.out.print("DESCRIPTION: ");
                assignment.setDescription(input.checkIf_String());
                System.out.print("SUBMISSION DATE (YYYY-MM-DD): ");
                assignment.setSubDateTime(LocalDate.parse(input.readInput()));           
                System.out.print("ORAL MARK: ");
                assignment.setOralMark(input.onlyNumbers());            
                System.out.print("TOTAL MARK: ");
                assignment.setTotalMark(input.onlyNumbers());            
//                Assignment.saveAssignments(assignment);
                input.underline();
                insert.create(assignment);
            System.out.println("DO YOU WANT TO ADD ANOTHER ASSIGNMENT? Y/N");
                boolean a=input.yesOrNo();
                if(a==true){
                    addAssignments();
                }
                else{
                      menu.addList();
                } 
            }
    } 
    //ADD STUDENT TO MORE THAT ONE COURSES
    public static void addStudentToCourse(){
        showLists lists=new showLists();
        ArrayList<Student> copiedStudents=new ArrayList();
        for(Student st:lists.getStudentList()){
            System.out.println(st);
            copiedStudents.add(st);
        }
        
        System.out.println("SELECT COURSE:");
        for(int i=0; i<lists.getCourseList().size(); i++){
            System.out.println("A/A: "+(i+1)+" -->"+lists.getCourseList().get(i));
        }
        int y=input.controInput(1,lists.getCourseList().size());
        Course saveOneCourse=lists.getCourseList().get(y-1);
        
        if(saveOneCourse.getStudents().size()>0){
            for(Student student:saveOneCourse.getStudents()){
                Iterator<Student> it=copiedStudents.iterator();
                while(it.hasNext()){
                    Student st=it.next();
                    if(st.equals(student)){
                        it.remove();
                    }
                }
            }
        }

        boolean b=true;
        while(b){
            System.out.println("SELECT STUDENT:");
                for(int i=0; i<copiedStudents.size(); i++){
                    System.out.println("A/A: "+(i+1)+ " --> "+copiedStudents.get(i).getFirstName()+"  "+copiedStudents.get(i).getSurName());
                }
            int x=input.controInput(1, copiedStudents.size());//CONTROL INPUT DEPENDS FROM LIST SIZE
            Student st1=copiedStudents.get(x-1);
            copiedStudents.remove(x-1);
            saveOneCourse.addStudents(st1);
            if(copiedStudents.size()>0){
            System.out.println("DO YOU WANT TO ADD ANOTHER COURSE TO THIS STUDENT? Y/N"); 
            if(!input.yesOrNo()){
              b=false;  
            }
            }else{
                b=false;
            }
        }   menu.addList();
    }
    
    //ADD TRAINER TO A COURSE
    public static void addTrainerToCourse(){
        ArrayList<Trainer> copiedTrainers=new ArrayList<>(Trainer.getAllTrainers());
        
        System.out.println("SELECT COURSE:");
        for(int i=0; i<Course.getAllCourses().size(); i++){
            System.out.println("A/A: "+(i+1)+" -->"+Course.getAllCourses().get(i).getTitle());
        }
        int y=input.controInput(1,Course.getAllCourses().size());
        Course saveOneCourse=Course.getAllCourses().get(y-1);
        
        if(saveOneCourse.getTrainers().size()>0){
            for(Trainer trainer:saveOneCourse.getTrainers()){
                Iterator<Trainer> it=copiedTrainers.iterator();
                while(it.hasNext()){
                    Trainer tr=it.next();
                    if(tr.equals(trainer)){
                        it.remove();
                    }
                }
            }
        }

        boolean b=true;
        while(b){
            System.out.println("SELECT TRAINER:");
                for(int i=0; i<copiedTrainers.size(); i++){
                    System.out.println("A/A: "+(i+1)+ " --> "+copiedTrainers.get(i).getFirstName()+"  "+copiedTrainers.get(i).getSurName());
                }
            int x=input.controInput(1, copiedTrainers.size());//CONTROL INPUT DEPENDS FROM LIST SIZE
            Trainer trainer1=copiedTrainers.get(x-1);
            copiedTrainers.remove(x-1);
            saveOneCourse.addTrainers(trainer1);
            if(copiedTrainers.size()>0){
            System.out.println("DO YOU WANT TO ADD ANOTHER COURSE TO THIS TRAINER? Y/N"); 
            if(!input.yesOrNo()){
              b=false;  
            }
            }else{
                b=false;
            }
        }   menu.addList();
    }
    
    //ADD MORE THAN ONE ASSIGNMENTS TO A STUDENT
    public static void addAssignmentToStudent(){
           ArrayList<Student> copiedStudents=new ArrayList<>(Student.getAllStudents());

            System.out.println("SELECT ASSIGNMENT:");
            for(int i=0; i<Assignment.getAllAssignments().size(); i++){
                System.out.println("A/A: "+(i+1)+" -->"+Assignment.getAllAssignments().get(i));
            }
            int y=input.controInput(1,Assignment.getAllAssignments().size());
            Assignment saveOneAssignment=Assignment.getAllAssignments().get(y-1);

            if(saveOneAssignment.getStudents().size()>0){
                for(Student student:saveOneAssignment.getStudents()){
                    Iterator<Student> it=copiedStudents.iterator();
                    while(it.hasNext()){
                        Student st=it.next();
                        if(st.equals(student)){
                            it.remove();
                        }
                    }
                }
            }

            boolean b=true;
            while(b){
                System.out.println("SELECT STUDENT:");
                    for(int i=0; i<copiedStudents.size(); i++){
                        System.out.println("A/A: "+(i+1)+ " --> "+copiedStudents.get(i).getFirstName()+"  "+copiedStudents.get(i).getSurName());
                    }
                int x=input.controInput(1, copiedStudents.size());//CONTROL INPUT DEPENDS FROM LIST SIZE
                Student st1=copiedStudents.get(x-1);
                copiedStudents.remove(x-1);
                saveOneAssignment.addStudent(st1);
                if(copiedStudents.size()>0){
                System.out.println("DO YOU WANT TO ADD ANOTHER ASSIGNMENT TO THIS STUDENT? Y/N"); 
                if(!input.yesOrNo()){
                  b=false;  
                }
                }else{
                    b=false;
                }
            }   menu.addList();
        }
    private static showLists lists=new showLists();
    // PRINT STUDENTS LIST 
    public void printStudents(){
        showLists a=new showLists();
        System.out.format("%-5s", "id");
        System.out.format("%-23s", "Firstname");
        System.out.format("%-18s", "Lastname");
        System.out.format("%-20s", "Tuition Fees");
        System.out.format("%-18s", "Date of Birth");
        System.out.println("");
        input.underline();
        List<Student> st=a.getStudentList();
            for(Student student:st){
                System.out.println(student);
            }   
    }

    //PRINT COURSES LIST
    public void printCourses(){
       showLists a=new showLists();
       List<Course> c=a.getCourseList();
       System.out.format("%-5s", "id");
       System.out.format("%-22s", "Subject");
       System.out.format("%-22s", "Stream");
       System.out.format("%-18s", "Type");
       System.out.format("%-16s", "Start date");
       System.out.format("%-18s", "End date");
       System.out.println("");
       input.underline();
            for(Course course:c){
                System.out.println(course);    
            }
    }
    // PRINT TRAINERS LIST
    public void printTrainers(){
        showLists a=new showLists();
        List<Trainer> t=a.getTrainerList();
       System.out.format("%-5s", "id");
       System.out.format("%-23s", "Firstname");
       System.out.format("%-18s", "Lastname");
       System.out.format("%-18s", "Subject"); 
       System.out.println("");
       input.underline();
            for(Trainer trainer:t){
                System.out.println(trainer);
            }
    }
    //PRINT ASSIGNMENTS LIST
    public void printAssignments(){
        showLists a=new showLists();

            System.out.format("%-10s", "id");
            System.out.format("%-20s", "Title");
            System.out.format("%-16s", "Description");
            System.out.format("%-18s", "Sub Date Time");
            System.out.format("%-15s", "Oral Mark");
            System.out.format("%-12s", "Total Mark");
            System.out.println("");
            input.underline();
        List<Assignment> assign=a.getAssignmentList();
        for(Assignment assignment:assign){
            System.out.println(assignment);
        }
    }
    //PRINT STUDENTS COURSES
//    public void printStudentsCourses(){   
//        for(Course course:Course.getAllCourses()){
//            input.underline();
//            int count=0;
//           
//            System.out.format("%"+course.getTitle());
//            for(Student student:course.getStudents()){
//                count++;
//                System.out.println(count+". "+student.getFirstName()+"  "+student.getSurName());
//            }
//        }        
//    }
    //PRINT ASSIGNMENTS PER COURSES
    public void printAssignmentsPerCourse(){
        for(Course course:Course.getAllCourses()){
            input.underline();
            int count=0;
            System.out.println("-->"+course.getTitle());
            for(Assignment assignment:course.getAssignments()){
                count++;
               System.out.println(count+". "+assignment.getTitle()+"  "+assignment.getDescription()+"  "+assignment.getSubDateTime()+"  "+assignment.getOralMark()+"  "+assignment.getTotalMark());
            }
        }
    }
    //PRINT TRAINERS PER COURSES
    public void printTrainersPerCourses(){  
        input.underline();
        int count=0;
        for(Course course:Course.getAllCourses()){
            input.underline();
            System.out.println("-->"+course.getTitle());
            for(Trainer trainer:course.getTrainers()){
                count++;
                System.out.println(count+". "+trainer.getFirstName()+"  "+trainer.getSurName());
            }count=0;
        }
    }
    //PRINT ASSIGNMENTS PER STUDENTS
    public void printAssignmentsPerStudents(){
        int count=0;
        for(Student student:Student.getAllStudents()){
            input.underline();
            System.out.println("-->"+student.getFirstName()+"  "+student.getSurName());
           for(Assignment assignment:student.getAssignments()){
               count++;
               System.out.println(count+". "+assignment.getTitle()+"  "+assignment.getDescription()+"  "+assignment.getSubDateTime()+"  "+assignment.getOralMark()+"  "+assignment.getTotalMark());
           }count=0;
        }
    }
    //PRINT STUDENTS WITH MORE THAN ONE COURSE
    public void printStudentsWithMoreThanOneCourse(){
        int count=0;
        System.out.println("STUDENS WITH MORE THAN ONE COURSES:");
        for(int i=0; i<Student.getAllStudents().size(); i++){
            if(Student.getAllStudents().get(i).getCourses().size()>1){
                count++;
                System.out.println(count+".  "+Student.getAllStudents().get(i).getFirstName()+"  "+Student.getAllStudents().get(i).getSurName());
            }
        }
        
    }
}
