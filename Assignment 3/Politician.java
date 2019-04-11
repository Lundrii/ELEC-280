package com.example.guessmaster;

@SuppressWarnings("all")

public class Politician extends Person {
    private String party;

    //initializing the no-argument constructor
    public Politician() {
        super();
        party = " ";
    }

    //initializing constructor
    public Politician(Person person, String politicalParty) {
        super(person);                                              //initializing instance variables using the inputs to constructor
        party = politicalParty;
    }

    //initialize constructors
    public Politician(String entityName, String strBorn, String personsGender, String politicalParty, Double level) {
        super(entityName, strBorn,personsGender, level);            //initializing instance variables using the inputs to constructor
        party = politicalParty;
    }

    //initializing constructors
    public Politician(String entityName, int month, int day, int year, String personsGender, String politicalParty, Double level) {
        super(entityName, month, day, year, personsGender, level);  //initializing instance variables using the inputs to constructor
        party = politicalParty;
    }

    //initialize constructors
    public Politician(String entityName, String month, int day, int year, String personsGender, String politicalParty, Double level) {
        super(entityName, month, day, year, personsGender, level);  //initializing instance variables using the inputs to constructor
        party = politicalParty;
    }

    //initializing constructors
    public Politician(String entityName, int year, String personsGender, String politicalParty, Double level) {
        super(entityName, year, personsGender, level);              //initializing instance variables using the inputs to constructor
        party = politicalParty;
    }

    //initializing constructors
    public Politician(String entityName, Date birthDate, String personsGender, String politicalParty, Double level) {
        super(entityName, birthDate, personsGender, level);         //initializing instance variables using the inputs to constructor
        party = politicalParty;
    }

    //initializing copy-constructor
    public Politician(Politician politician){
        super(politician);                                          //copy input object into new object
        party = politician.getParty();
    }

    //initializing accessor to fetch party
    public String getParty() {
        return party;
    }

    public Politician clone() {
        return new Politician(this);                                //make a clone of the input object
    }

    //returning a String for abstract method entityType
    public String entityType() {
        return "This is a Politician!";                             //entityType is Politician
    }

    //initializing the toString function to return details about the entity
    public String toString() {
        return "Name: " + this.getName() + "\nBorn at: " + this.getBorn() + "\nGender: " + this.getGender() + "\nParty: " + this.getParty();
    }
}
