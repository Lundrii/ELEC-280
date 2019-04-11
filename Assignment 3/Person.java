package com.example.guessmaster;

@SuppressWarnings("all")

public class Person extends Entity {
    private String gender;

    //initializing the no-argument constructor
    public Person() {
        super();
        gender = " ";
    }

    //initializing constructor
    public Person(Entity entity, String personsGender) {
        super(entity);                                          //initializing instance variables using inputs to constructor
        gender = personsGender;
    }

    //initialize constructor
    public Person(String entityName, String strBorn, String personsGender, Double level) {
        super(entityName, strBorn, level);                      //initializing instance variables using inputs to constructor
        gender = personsGender;
    }

    //initialize constructor
    public Person(String entityName, int month, int day, int year, String personsGender, Double level) {
        super(entityName, month, day, year, level);             //initializing instance variables using inputs to constructor
        gender = personsGender;
    }

    public Person(String entityName, String month, int day, int year, String personsGender, Double level) {
        super(entityName, month, day, year, level);             //initializing instance variables using inputs to constructor
        gender = personsGender;
    }

    //initializing constructor
    public Person(String entityName, int year, String personsGender, Double level) {
        super(entityName, year, level);                         //initializing instance variables using inputs to constructor
        gender = personsGender;
    }

    //initializing constructor
    public Person(String entityName, Date birthDate, String personsGender, Double level) {
        super(entityName, birthDate, level);                    //initializing instance variables using inputs to constructor
        gender = personsGender;
    }

    //initializing copy-constructor
    public Person(Person person){
        super(person);                                          //copy input object into new object
        gender = person.getGender();
    }

    //initialize clone
    public Person clone() {
        return new Person(this);                                //make a clone of the input object
    }

    //initializing accessor to fetch gender
    public String getGender() {
        return gender;
    }

    //returning a String to the abstract method entityType
    public String entityType() {                                //entityType is Person
        return "This is a Person!";
    }

    //initializing the toString function to return details about the entity
    public String toString() {
        return "Name: " + this.getName() + "\nBorn at: " + this.getBorn() + "\nGender: " + this.getGender();
    }
}
