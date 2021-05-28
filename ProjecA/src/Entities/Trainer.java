
package Entities;

import java.util.ArrayList;


public class Trainer {
    private int id;
    private String firstName;
    private String surName;
    private String subject;
    private static ArrayList<Trainer> allTrainers=new ArrayList<>();
    
    //CONSTRACTOR
    public Trainer() {
    }
    
    
    public Trainer(String firstName, String surName, String subject) {
        this.firstName = firstName;
        this.surName = surName;
        this.subject = subject;
    }

    public Trainer(int id, String firstName, String surName, String subject) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.subject = subject;
    }
    
    public int getId() {
        return id;
    }

    //GETTERS AND SETTERS
    
    public void setId(int id) {    
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static ArrayList<Trainer> getAllTrainers() {
        return allTrainers;
    }

    public static void setAllTrainers(ArrayList<Trainer> allTrainers) {
        Trainer.allTrainers = allTrainers;
    }

    public static void saveTrainer(Trainer trainer){
           allTrainers.add(trainer);
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return String.format(" %-5s%-22s%-20s%-20s", id, firstName, surName, subject);

    }
    
    
}
