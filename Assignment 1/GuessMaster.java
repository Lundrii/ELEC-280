import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("all")

public class GuessMaster {
    //declaring instance variable
    private int numberOfCandidates;
    private Entity[] entities;

    //initializing a no-argument constructor
    public GuessMaster() {
        this.numberOfCandidates = 0;
        this.entities = new Entity[100];
    }

    //initializing constructor
    public GuessMaster(int numberOfEntities, Entity entity) {
        this.numberOfCandidates = numberOfEntities;             //initializing the number of candidates
        this.entities[this.numberOfCandidates] = entity;        //set entity as the element in index numberOfCandidates
    }

    //Mutators
    public void addEntity(Entity entity) {
        this.numberOfCandidates += 1;                            //add one to number of indices
        this.entities[this.numberOfCandidates] = entity;         //add entity to the end of the array of entities
    }

    //Accessor
    public Entity getEntity(int entityInd) {
        return (this.entities[entityInd]);
    }

    //fetch a random number to be used as an index for playGame()
    public int genRandomEntityInd() {
        Random rand = new Random();                             //use Java's Random class to generate random integers
        int randInd = rand.nextInt(this.numberOfCandidates + 1);    //numbers between 0 and numberOfCandidates
        return randInd;
    }

    //welcomes player and displays the rules of the game as well as the keyword 'quit'
    public void printRules() {
        System.out.println("Welcome to Guess Master!");
        System.out.println("The rules are straight froward, you will be given the name of a person, " +
                "place or thing, and you must guess when they were born.");
        System.out.println("If your guess is incorrect, you will be told whether the date" +
                " is before or after the guess you made.\n");
        System.out.println("You may end the game at anytime by typing 'quit'.");
        System.out.println("Press the 'Enter' key whe you are ready to start.");

        System.out.println("___________________________________________________________________________________________");
        System.out.print("\n");
    }

    //wait for player to read rules of the game
    public void startGame() {
        Scanner keyboard = new Scanner(System.in);              //using keyboard inputs to activate game
        keyboard.nextLine();                                    //waits for player to hit the enter button to start game
    }

    //play game guessing for a specific entity given in the inputs of hte function
    public void playGame(Entity entity) {
        String name = entity.getName();                         //use accessors to get name of the entity in question
        Date birthDate = entity.getBorn();                      //use accessors to get birthDate of entity in question
        Date guess = new Date();                                //create a new Date class to store players guess

        this.printRules();                                      //print the rules of the game
        this.startGame();                                       //wait on player to press 'Enter' to start game
        System.out.println("When was " + name + " born?");
        while(true){                                            //loop indefinitely until player guess's the proper date
            guess.readInput();                                  //read player input from keyboard
            if(guess.equals(birthDate)) {                       //if guess matches the correct birthDate
                System.out.println("BINGO, You got it!");
                String entityBorn = entity.toString(name, birthDate);   //use toString() to display correct birthDate
                System.out.println(entityBorn);
                break;                                          //player won the game, exit the loop
            }
            else if(guess.precedes(birthDate)) {                //if guess precedes the correct birthDate
                System.out.println("Incorrect. Try a later Date");
            }
            else {                                              //otherwise, the correct date is earlier than the guess
                System.out.println("Incorrect. Try an earlier date");
            }
        }
    }

    //play game guessing for an entity in a specific index given in the input of the function
    public void playGame(int entityInd) {
        Entity entity = this.getEntity(entityInd);              //get the entity that is in the given index
        String name = entity.getName();                         //use accessors to get the name of the entity
        Date birthDate = entity.getBorn();                      //use accessors to get the birthDate of the entity
        Date guess = new Date();                                //create new Date class to store the players guess

        this.printRules();                                      //print the rules of the game
        this.startGame();                                       //wait on the player to press enter to start the game
        System.out.println("When was " + name + " born?");
        while(true){                                            //loop indefinitely until player guess's the correct date
            guess.readInput();                                  //read player input from the keyboard
            if(guess.equals(birthDate)) {                       //if guess matches the correct birthDate
                System.out.println("BINGO, You got it!");
                String entityBorn = entity.toString(name, birthDate);   //use toString() to display correct birthDate
                System.out.println(entityBorn);
                break;                                          //player has won the game, exit the loop
            }
            else if(guess.precedes(birthDate)) {                //if guess precedes the correct date
                System.out.println("Incorrect. Try a later Date");
            }
            else {                                              //otherwise, the correct date is earlier than the guess
                System.out.println("Incorrect. Try an earlier date");
            }
        }
    }

    //no-argument declaration of play game. Plays game using a random generated index
    public void playGame() {
        int randInd = genRandomEntityInd();                     //use genRandomEntityInd() to generate a random index
        Entity entity = this.getEntity(randInd);                //get the entity that is in that index of entities[]
        String name = entity.getName();                         //use accessors to get the name of the entity
        Date birthDate = entity.getBorn();                      //use accessors to get the birthDate of the entity
        Date guess = new Date();                                //create new Date class to store the players guess

        this.printRules();                                      //print the rules of the game
        this.startGame();                                       //wait for player to press 'Enter' to start the game
        System.out.println("When was " + name + " born?");
        while(true){                                            //loop indefinitely until correct date is guessed
            guess.readInput();                                  //get player guess from the keyboard input
            if(guess.equals(birthDate)) {                       //if guess matches the correct birthDate
                System.out.println("BINGO, You got it!");
                String entityBorn = entity.toString(name, birthDate);   //use toString() to display correct birthDate
                System.out.println(entityBorn);
                break;                                          //player won, exit the loop
            }
            else if(guess.precedes(birthDate)) {                //if the guess precedes the correct birthDate
                System.out.println("Incorrect. Try a later Date");
            }
            else {                                              //otherwise, the correct birthDate comes before the guess
                System.out.println("Incorrect. Try an earlier date");
            }
        }
    }

    public static void main(String[] args) {
        Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
        Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
        Entity usa = new Entity("United States", new Date("July", 4, 1776));

        GuessMaster gm = new GuessMaster();
        gm.addEntity(trudeau);
        gm.addEntity(dion);
        gm.addEntity(usa);

        gm.playGame();

    }
}
