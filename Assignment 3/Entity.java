package com.example.guessmaster;

import java.lang.*;

@SuppressWarnings("all")

public abstract class Entity {
    //declaring instance variables
    private String name;
    private Date born;
    private Double difficulty;

    //initializing the no-argument constructor
    public Entity() {
        name = " ";                                                              //no inputs given therefore name is null
        born = new Date("January",1,1980);                  //giving born an arbitrary date to store
        difficulty = 0.01;
    }

    //initializing copy constructor
    public Entity(Entity entity) {                                               //initializing instance variables using input object
        name = entity.getName();
        born = entity.getBorn();
        difficulty = entity.getDifficulty();
    }

    //initializing constructor
    public Entity(String entityName, String strBorn, Double level) {            //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(strBorn);
        difficulty = level;
    }

    //initializing constructor
    public Entity(String entityName, int month, int day, int year, Double level) {    //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(month, day, year);
        difficulty = level;
    }

    //initializing constructor
    public Entity(String entityName, String month, int day, int year, Double level) { //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(month, day, year);
        difficulty = level;
    }

    //initializing constructor
    public Entity(String entityName, int year, Double level) {                  //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(year);
        difficulty = level;
    }

    //initializing constructor
    public Entity(String entityName, Date birthDate, Double level) {            //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(birthDate);
        difficulty = level;
    }

    //initializing mutator
    public void setName(String entityName) {
        this.name = entityName;                                  //changing the name of an entity using an input name
    }

    //initializing mutator
    public void setDifficulty(Double level) {
        this.difficulty = level;
    }

    //initializing mutator
    public void setEntity(String entityName, int month, int day, int year, Double level) {
        this.name = entityName;                                 //changing the name of an entity using an input name
        this.born = new Date(month, day, year);                 //changing the birthDate of an entity using input date
        this.difficulty = level;                                //changing the difficulty of hte entity using the input level
    }

    //initializing mutator
    public void setEntity(String entityName, String month, int day, int year, Double level) {
        this.name = entityName;                                 //changing the name of an entity using an input name
        this.born = new Date(month, day, year);                 //changing the birthDate of an entity using input date
        this.difficulty = level;                                //changing the difficulty of an entity using the input level
    }

    //initializing name accessor
    public String getName() {
        return this.name;                                       //used to access the private variable 'name'
    }

    //initializing born accessor
    public Date getBorn() {
        return new Date(born);                                  //used to access the private variable 'born'
    }

    //initializing difficulty accessor
    public Double getDifficulty() {
        return difficulty;                                      //used to access the private variable 'difficulty'
    }

    //method that takes the difficulty of an entity and awards tickets based on the difficulty rating
    public int getAwardedTicketNumber() {
        Double tickets = new Double(this.difficulty*100);   //multiply difficulty by 100 to get the awarded tickets
        return tickets.intValue();
    }

    //declaring an abstract method, to be used in derived classes, return type String
    public abstract String entityType();

    //declaring an abstract method, return type Entity
    public abstract Entity clone();

    //method that takes in the entities name and birthDate, returning information in a string
    public String toString(Entity entity, Date birthDate) {
        return this.getName() + ", born on " + this.getBorn();
    }

    //checks to see if the entity name matches that of another entity
    public Boolean nameEquals(Entity entity) {
        String entityName = entity.getName();                   //accessing the name of the specific entity
        if(entityName.equals(this.name)){                       //if the name of both entities matches
            return true;                                        //outputs true
        }
        else {                                                  //otherwise,
            return false;                                       //outputs false
        }
    }

    //method to display the welcoming message to the player
    public String welcomeMessage() {
        return "Welcome! Let's start the game! " + entityType();    //welcome the player to the game and state the entity type
    }

    //method to display a closing message to the player
    public String closingMessage() {
        String congrats = "Congratulations! The detailed information of the entity you guess is: \n"; //congratulate the player
        String details = this.toString();                       //show entity details
        return congrats + details;
    }

    //checking to see if the entity birthDate is the sane as another entity
    public Boolean bornEquals(Entity entity) {
        Date birthDate = entity.born;                           //use accessor to get the entity birthDate
        int month = birthDate.getMonth();                       //use accessor to get the month from born
        int day = birthDate.getDay();                           //use accessor to get the day from born
        int year = birthDate.getYear();                         //use accessor to get the year from born
        if(month == this.born.getMonth() && day == this.born.getDay() && year == this.born.getYear()) { //if all month, day, year matches
            return true;
        }
        else {
            return false;
        }
    }

    //checks if both birthDate and name are the same as that of another entity
    public Boolean equals(Entity entity) {
        Boolean nameBool = entity.nameEquals(this);      //storing output of nameEquals()
        Boolean bornBool = entity.bornEquals(this);      //storing output of bornEquals()
        if(nameBool && bornBool) {                              //if they are both true
            return true;                                        //then the two entities are equal
        }
        else {                                                  //otherwise,
            return false;                                       //they are not equal
        }
    }
}
