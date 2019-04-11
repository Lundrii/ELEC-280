package com.example.guessmaster;

//importing all needed packages
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Random;

//@SuppressWarnings("all")

public class GuessMaster extends AppCompatActivity {
    //specifying view components
    private TextView entityName;
    private TextView ticketsum;
    private Button guessButton;
    private EditText userIn;
    private Button btnclearContent;
    private ImageView entityImage;
    String answer;

    //declaring instance variable
    private int numberOfCandidates;
    private Entity[] entities;
    private int tickets;
    String entName;
    int entityId = 0;

    //instantiate all objects that will be used in Guess Master
    Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25,1971), "Male", "Liberal",0.25);
    Singer dion = new Singer("Celine Dion", new Date("March", 30, 1968), "Female","La voix du bon Dieu", new Date("November", 6, 1981),0.5);
    Person myCreator = new Person("My Creator", new Date("June", 16, 1999), "Male", 1.0);
    Country usa = new Country("United States", new Date("July", 4, 1776), "Washington D.C.",0.1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_master);
        guessButton = (Button)findViewById(R.id.btnGuess);
        btnclearContent = (Button)findViewById(R.id.btnClear);
        userIn = (EditText)findViewById(R.id.guessInput);
        ticketsum = (TextView)findViewById(R.id.ticket);
        entityName = (TextView)findViewById(R.id.entityName);
        entityImage = (ImageView)findViewById(R.id.entityImage);

        //add all entities created to the entities[] array
        addEntity(trudeau);
        addEntity(dion);
        addEntity(myCreator);
        addEntity(usa);

        //start the game by displaying the first entity
        changeEntity();

        //when clear button is clicked, change entity
        btnclearContent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                changeEntity();
            }
        });

        //when submit guess button is clicked, compare the answer provided with entity.getBorn()
        guessButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                playGame();
            }
        });
    }

    //call continue game
    public void changeEntity(){
        continueGame();
    }

    //clears user input, generate a random entity, set the new entity image and display AlertDialog
    public void continueGame(){
        entityId = genRandomEntityInd();
        Entity entity = entities[entityId];

        entName = entity.getName();
        entityName.setText(entName);
        userIn.getText().clear();

        ImageSetter();
        welcomeToGame(entity);
    }

    //set the image to be displayed on screen based on the name of the current entity
    public void ImageSetter(){
        String entName = entityName.getText().toString();
        if(entName.equals("Justin Trudeau")){
            entityImage.setImageResource(R.drawable.justint);
        }
        else if(entName.equals("Celine Dion")){
            entityImage.setImageResource(R.drawable.celidion);
        }
        else if(entName.equals("My Creator")){
            entityImage.setImageResource(R.drawable.thecreator);
        }
        else if(entName.equals("United States")){
            entityImage.setImageResource(R.drawable.usaflag);
        }
    }

    //displays an AlertDialog welcoming the player and telling them the entity type
    public void welcomeToGame(Entity entity){
        AlertDialog.Builder welcomeAlert = new AlertDialog.Builder(GuessMaster.this);
        welcomeAlert.setTitle("GuessMaster Game Version 3.0");
        welcomeAlert.setMessage(entity.welcomeMessage());
        welcomeAlert.setCancelable(false);
        welcomeAlert.setNegativeButton("Start Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"Game is starting... Enjoy",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = welcomeAlert.create();
        dialog.show();
    }

    //initializing a no-argument constructor
    public GuessMaster() {
        this.numberOfCandidates = 0;
        this.entities = new Entity[100];
        this.tickets = 0;
    }

    //initializing constructor
    public GuessMaster(int numberOfEntities, Entity entity) {
        this.numberOfCandidates = numberOfEntities;             //initializing the number of candidates
        this.entities[this.numberOfCandidates] = entity;        //set entity as the element in index numberOfCandidates
        this.tickets = 0;
    }

    //initializing mutator
    public void addEntity(Entity entity) {
        this.numberOfCandidates += 1;                            //add one to number of indices
        this.entities[this.numberOfCandidates] = entity;         //add entity to the end of the array of entities
    }

    //initializing accessor
    public Entity getEntity(int entityInd) {
        return (this.entities[entityInd]);
    }

    //finds and returns an entity based on a given name of the entity
    public Entity findEntity(){
        String entName = entityName.getText().toString();
        Entity entity;
        if(entName.equals("Justin Trudeau")) {
            entity = trudeau;
        }
        else if(entName.equals("Celine Dion")) {
            entity = dion;
        }
        else if(entName.equals("My Creator")) {
            entity = myCreator;
        }
        else if(entName.equals("United States")) {
            entity = usa;
        }
        else {
            entity = trudeau;
        }
        return entity;
    }

    //fetch a random number to be used as an index for playGame()
    public int genRandomEntityInd() {
        Random rand = new Random();                             //use Java's Random class to generate random integers
        return rand.nextInt(this.numberOfCandidates + 1);    //numbers between 0 and numberOfCandidates
    }

    //play game guessing for a specific entity given in the inputs of hte function
    public void playGame(Entity entity) {
        answer = userIn.getText().toString();
        answer = answer.replace("\n","").replace("\r","");
        Date dateInput = new Date(answer);

        final int awardedTickets = entity.getAwardedTicketNumber();
        AlertDialog.Builder closingAlert = new AlertDialog.Builder(GuessMaster.this);
        closingAlert.setTitle("You Won!");
        closingAlert.setMessage("BINGO!");
        closingAlert.setCancelable(false);
        closingAlert.setNegativeButton("Start Game", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"You won " + awardedTickets + " tickets.", Toast.LENGTH_SHORT).show();
            }
        });

        if(dateInput.equals(entity.getBorn())) {
            continueGame();
            AlertDialog dialog = closingAlert.create();
            dialog.show();
            tickets = tickets + entity.getAwardedTicketNumber();
        }
        else if(dateInput.precedes(entity.getBorn())){
            AlertDialog.Builder laterDateMessage = new AlertDialog.Builder(GuessMaster.this);
            laterDateMessage.setMessage("Enter a later date");
            AlertDialog dialog = laterDateMessage.create();
            dialog.show();
        }
        else if(entity.getBorn().precedes(dateInput)) {
            AlertDialog.Builder earlierDateMessage = new AlertDialog.Builder(GuessMaster.this);
            earlierDateMessage.setMessage("Enter a earlier date");
            AlertDialog dialog = earlierDateMessage.create();
            dialog.show();
        }
        String ticketString = Integer.toString(tickets);
        ticketsum.setText("Total Tickets: " + ticketString);
    }

    //play game guessing for an entity in a specific index given in the input of the function
    public void playGame(int entityInd) {
        Entity entity = this.getEntity(entityInd);              //get the entity that is in the given index

        answer = userIn.getText().toString();
        answer = answer.replace("\n","").replace("\r","");
        Date dateInput = new Date(answer);

        final int awardedTickets = entity.getAwardedTicketNumber();
        AlertDialog.Builder closingAlert = new AlertDialog.Builder(GuessMaster.this);
        closingAlert.setTitle("You Won!");
        closingAlert.setMessage("BINGO!");
        closingAlert.setCancelable(false);
        closingAlert.setNegativeButton("Start Game", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"You won " + awardedTickets + " tickets.", Toast.LENGTH_SHORT).show();
            }
        });

        if(dateInput.equals(entity.getBorn())) {
            continueGame();
            AlertDialog dialog = closingAlert.create();
            dialog.show();
            tickets = tickets + entity.getAwardedTicketNumber();
        }
        else if(dateInput.precedes(entity.getBorn())){
            AlertDialog.Builder laterDateMessage = new AlertDialog.Builder(GuessMaster.this);
            laterDateMessage.setMessage("Enter a later date");
            AlertDialog dialog = laterDateMessage.create();
            dialog.show();
        }
        else if(entity.getBorn().precedes(dateInput)) {
            AlertDialog.Builder earlierDateMessage = new AlertDialog.Builder(GuessMaster.this);
            earlierDateMessage.setMessage("Enter a earlier date");
            AlertDialog dialog = earlierDateMessage.create();
            dialog.show();
        }
        String ticketString = Integer.toString(tickets);
        ticketsum.setText("Total Tickets: " + ticketString);
    }

    //no-argument declaration of play game. Plays game using a random generated index
    public void playGame(){
        Entity entity = findEntity();

        answer = userIn.getText().toString();
        answer = answer.replace("\n","").replace("\r","");
        Date dateInput = new Date(answer);

        final int awardedTickets = entity.getAwardedTicketNumber();
        AlertDialog.Builder correctGuess = new AlertDialog.Builder(GuessMaster.this);
        correctGuess.setTitle("You Won!");
        correctGuess.setMessage("BINGO!");
        correctGuess.setCancelable(false);
        correctGuess.setNegativeButton("Start Game", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),"You won " + awardedTickets + " tickets.", Toast.LENGTH_SHORT).show();
            }
        });

        if(dateInput.equals(entity.getBorn())) {
            continueGame();
            AlertDialog dialog = correctGuess.create();
            dialog.show();
            tickets = tickets + entity.getAwardedTicketNumber();
        }
        else if(dateInput.precedes(entity.getBorn())){
            AlertDialog.Builder incorrectEarlyGuess = new AlertDialog.Builder(GuessMaster.this);
            incorrectEarlyGuess.setMessage("Enter a later date");
            AlertDialog dialog = incorrectEarlyGuess.create();
            dialog.show();
        }
        else if(entity.getBorn().precedes(dateInput)) {
            AlertDialog.Builder incorrectLateGuess = new AlertDialog.Builder(GuessMaster.this);
            incorrectLateGuess.setMessage("Enter a earlier date");
            AlertDialog dialog = incorrectLateGuess.create();
            dialog.show();
        }
        String ticketString = Integer.toString(tickets);
        ticketsum.setText("Total Tickets: " + ticketString);
    }
}

