
package projecta;

import java.time.LocalDate;
import java.util.Scanner;


public class UsefulMethods {
    Scanner input=new Scanner(System.in);
    
     public UsefulMethods() {
    }
    
    //SCANNER RETURN STRING
    public String readInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.next();
        return userInput;
    }
    
    // CONTROL IF THE USERS INPUT IS INVALID (NOT A NUMBER)
    public  int onlyNumbers(){
        int result;
        
        while(true){ 
            try{
                String num=input.next();
                int number=Integer.parseInt(num);
                result=number;
                break;
            }catch(Exception e){
                System.err.println("INVALID NUMBER TRY AGAIN");    
            }
        }
        return result;
    }
    //CONTROL IF THE USERS INPUT IS INVALID (NOT A STRING)
    public  String checkIf_String(){

        String result="";
        while(true){
            result=input.next();
            if((!result.equals("")) 
            && (result != null) 
            && (result.matches("^[a-zA-Z]*$"))){
            return result;
            }else{
            System.err.println("INVALUD INPUT. TRY AGAIN");
            }
        }    
    }

    
    //yes or no
    public  boolean yesOrNo(){
         boolean b=true;
         boolean result=false;
      while(b){    
                
                    char c=input.next().charAt(0);
                        if (c=='Y'||c=='y'){
                        result=true;
                        b=false;
                    }else if(c=='n'||c=='N'){
                        result=false;
                        b=false;
                    }
                    else {
                        System.err.println("INVALID INPUT. TRY AGAIN");
                       
                    }
                }
      return result;
    }
    
    //UNDERLINE
    public  void underline(){
        System.out.println("");
        System.out.print("_______________________________________________________________________________________________________________________________________________________________\n");
    }
    
    //1,2 AND 3 THE ONLY ACCEPTABLE INPUT
    public int controInput(int min, int max){
        int result;
        do{
            result=input.nextInt();
            if(result<min||result>max){
            System.err.println("INVALID INPUT. TRY AGAIN");
            }else{
                return result;
            }
        }while(true);
        
    }
    //CHANGE LINE
    public void changeLine(){
        System.out.println("");
    }
    //CONTROL DATE INPUT
    public LocalDate localDate() {
        
        Scanner inputDate=new Scanner(System.in);

          LocalDate date=null;
        boolean result;
        do {
            try {
                date = LocalDate.parse(inputDate.nextLine());
                result = false;
                break;
            } catch (Exception e) {
                System.err.print("INVALID DATA VALUE TRY AGAIN: ");
                result = true;
            }

        } while (result);
        return date;
    }
}
