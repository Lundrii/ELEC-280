public class Country extends Entity {
    private String capital;

    //initializing the no-argument constructor
    public Country() {
        super();
        capital = " ";
    }

    //initializing constructor
    public Country(Entity entity, String capCity) {
        super(entity);                                              //initializing instance variables using inputs to constructor
        capital = capCity;
    }

    //initializing constructors
    public Country(String entityName, String strBorn, Double level, String capCity) {
        super(entityName, strBorn, level);                          //initializing instance variables using inputs to constructor
        capital = capCity;
    }

    //initializing constructors
    public Country(String entityName, int month, int day, int year, String capCity, Double level) {
        super(entityName, month, day, year, level);                 //initializing instance variables using inputs to constructor
        capital = capCity;
    }

    //initialize constructor
    public Country(String entityName, String month, int day, int year, String capCity, Double level) {
        super(entityName, month, day, year, level);                 //initializing instance variables using inputs to constructor
        capital = capCity;
    }

    //initializing constructor
    public Country(String entityName, int year, String capCity, Double level) {
        super(entityName, year, level);                             //initializing instance variables using inputs to constructor
        capital = capCity;
    }

    //initializing constructor
    public Country(String entityName, Date birthDate, String capCity, Double level) {
        super(entityName, birthDate, level);                        //initializing instance variables using the inputs to constructor
        capital = capCity;
    }

    //initializing copy-constructor
    public Country(Country country) {
        super(country);                                             //copy input object into new object
        capital = country.getCapital();
    }

    //initialize clone
    public Country clone() {                                        //make a clone of the input object
        return new Country(this);
    }

    //initializing accessor to fetch capital
    public String getCapital() {
        return capital;
    }

    //returning a String to abstract method entityType
    public String entityType() {
        return "This is a Country!";                                //entityType is Country
    }

    //initializing the toString function to return the details about the entity
    public String toString() {
        return "Name: " + this.getName() + "\nBorn at: " + this.getBorn() + "\nCapital: " + getCapital();
    }
}
