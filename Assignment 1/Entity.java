@SuppressWarnings("all")

public class Entity {
    //declaring instance variables
    private String name;
    private Date born;

    //initializing the no-argument constructor
    public Entity() {
        name = "";                                                //no inputs given therefore name is null
        born = new Date("January",1,1980);  //giving born an arbitrary date to store
    }

    //initializing constructor
    public Entity(String entityName, String strBorn) {            //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(strBorn);
    }

    //initializing constructor
    public Entity(String entityName, int month, int day, int year) {    //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(month, day, year);
    }

    //initializing constructor
    public Entity(String entityName, String month, int day, int year) { //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(month, day, year);
    }

    //initializing constructor
    public Entity(String entityName, int year) {                //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(year);
    }

    //initializing constructor
    public Entity(String entityName, Date birthDate) {          //initializing instance variables using inputs to constructor
        name = entityName;
        born = new Date(birthDate);
    }

    //initializing mutator
    public void setName(String entityName) {
        this.name = entityName;                                  //changing the name of an entity using an input name
    }

    //initializing mutator
    public void setEntity(String entityName, int month, int day, int year) {
        this.name = entityName;                                 //changing the name of an entity using an input name
        this.born = new Date(month, day, year);                 //changing the birthDate of an entity using input date
    }

    //initializing mutator
    public void setEntity(String entityName, String month, int day, int year) {
        this.name = entityName;                                 //changing the name of an entity using an input name
        this.born = new Date(month, day, year);                 //changing the birthDate of an entity using input date
    }

    //initializing accessor
    public String getName() {
        return name;                                            //used to access the private variable 'name'
    }

    //initializing accessor
    public Date getBorn() {
        return new Date(born);                                  //used to access the private variable 'born'
    }

    //method that takes in the entities name and birthDate, returning information in a string
    public String toString(String entityName, Date birthDate) {
        return (this.name + ", born on " + this.born);          //returns 'name', born on 'birthDate' as a string
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
