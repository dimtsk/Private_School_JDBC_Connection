
package projecta;

import Entities.Student;
import sql_DB.showLists;


public class MainMenu {
    UsefulMethods input=new UsefulMethods();
    showLists brinkLists=new showLists();
    boolean b=false;
    
    //CONSTRUCTOR
    public MainMenu(){    
    }
    
    // START MENU OF THE APPLICATION
    public void menu(){
        Student s=new Student();
        do{
        System.out.println("CHOOSE ONE OF THE FOLLOWING OPTIONS:\n"
                + "TYPE 1 - ADD INFORMATIONS\n"
                + "TYPE 2 - LIST OVERVIEW\n"
                + "TYPE 3 - EXIT\n"
                + "CHOICE: ");
        
        int x=input.controInput(1,3);
        switch(x){
            //EDITING
            case 1: 
                b=false;
                addList();
                break;
                //LISTS
            case 2:
                b=false;
                printAllLists();
                break;
                //EXIT
            case 3:
                b=true;
                System.out.println("SEE YOU SOON!");
                System.exit(0);
            }  
        }while(b=false); 
    }
    
    
    // ADD LIST OPTIONS
    public void addList(){   
        input.underline();
        System.out.println("CHOOSE ONE OF THE FOLLOWING OPTIONS:\n"
                + "TYPE 1 - ADD STUDENTS\n"
                + "TYPE 2 - ADD COURSES\n"
                + "TYPE 3 - ADD TRAINERS\n"
                + "TYPE 4 - ADD ASSIGNMENTS\n"
                + "TYPE 5 - ADD STUDENT TO A COURSE\n"
                + "TYPR 6 - ADD TRAINER TO A COURSE\n"
                + "TYPE 7 - ADD ASSIGNMENT TO A STUDENT\n"
                + "TYPE 8 - GO BACK TO MENU\n"
                + "CHOISE:");
        AddEntities addInfo=new AddEntities();
        int x=input.controInput(1,8);       
        switch(x){
            //ADD STUDENTS
            case 1: 
                b=false;
                addInfo.addStudents();
                break;
                //ADD COURSES
            case 2:
                b=false;
                addInfo.addCourses();
                break;
                //ADD TRAINERS
            case 3:
                b=false;
                addInfo.addTrainers();
                break;
                //ADD ASSIGNMENTS
            case 4:
                b=false;
                addInfo.addAssignments();
                break;
                //ADD STUDENT TO COURSE
            case 5:
                b=false;
                addInfo.addStudentToCourse();
                break;
                //ADD TRAINER TO COURSE
            case 6:
                b=false;
                addInfo.addTrainerToCourse();
                break;
                //ADD ASSIGNMENTS TO STUDENT
            case 7:
                b=false;
                addInfo.addAssignmentToStudent();
                break;
                //MAIN MENU
            case 8:
                b=true;
                menu();
                break;
            }  
    }
    
    //PRINT LIST MENU
    public void printAllLists(){
        AddEntities printList=new AddEntities();
        input.underline();
        System.out.println("WHICH LIST DO YOU WISH TO SEE?\n"
                + "TYPE 1 - STUDENTS LIST\n"
                + "TYPE 2 - COURSES LIST\n"
                + "TYPE 3 - TRAINERS LIST\n"
                + "TYPE 4 - ASSIGNMENTS LIST\n"
                + "TYPE 5 - STUDENTS PER COURSE\n"
                + "TYPE 6 - TRAINERS PER COURSES\n"
                + "TYPE 7 - ASSIGNMENTS PER COURSES\n"
                + "TYPE 8 - ASSIGNMENTS PER STUDENT\n"
                + "TYPE 9 - STUDENTS BELONG TO MORE THAN ONE COURSES\n"
                + "TYPE 10 - BACK TO MAIN MENU\n"
                + "CHOICE:");
        int x=input.controInput(1, 10);       
        switch(x){
            case 1:
                input.underline();
                printList.printStudents();
                seeMoreLists();
                break;
            case 2:
                input.underline();
                printList.printCourses();
                seeMoreLists();
                break;
            case 3:
                input.underline();
                printList.printTrainers();
                seeMoreLists();
                break;
            case 4:
                input.underline();
                printList.printAssignments();
                seeMoreLists();
                break;
            case 5:
                input.underline();
                brinkLists.findStudentsPerCourses();
                seeMoreLists();
                break;
            case 6:
                input.underline();
                brinkLists.findTrainersPerCourses();
                seeMoreLists();
                break;
            case 7:
                input.underline();
                brinkLists.findAssignmentPerCourse();
                seeMoreLists();
                break;
            case 8:
                input.underline();
                brinkLists.findAssignmentsPerStudent();
                seeMoreLists();
                break;
            case 9:
                input.underline();
                brinkLists.findStudentsWithMoreThanOneCourses();
                seeMoreLists();
                break;
            case 10:
                menu();        
        }                
    }
    //ASKING USER IF HE WANT TO SEE ANOTHER LIST
    public void seeMoreLists(){
        input.underline();
        System.out.println("DO YOU WANT TO SEE ANOTHER LIST? Y/N");
                boolean result=input.yesOrNo();  
                if(result==true){
                    printAllLists();
                }   
                else{
                    menu();
                }
    }
}
