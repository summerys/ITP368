package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
	
	public static final int gameWidth = 700;
    public static final int gameHeight = 700;
    
    	//ArrayList of objects that use for animation 
    private ArrayList<CatchableObject> catchableObjects;
    private ArrayList<TrapObject> bombs;
    private ArrayList<MysteryObject> mysteryBox;
    private ArrayList<BonusCoinObject> coins;
    private ArrayList<String> theme;
 
    private final static int TOTALSCORE = 0; //Default value 
    private final int LIVES = 3; // default value 
    
    //***default values that are subject to change based on user's chosen difficulty
	public static int ballsize = 70; // Default value 
	public static int speed = 1; // Default value 
	int numOfObject = 2; //default
	int numOfBomb = 3; //default 
	int numOfMysteryBox = 5; //default 
	int numOfCoins = 30; //default
	
	private Scene scene;
	private Pane pane;
	boolean moveLeft;
	boolean moveRight;
	static int totalBallNum = 0;
	Random rand;
	Text currentScore;
	Text currentLives;
	Text displayName;
	GameTimer gameTimer;
	String username;
	Stage stage;
	MediaPlayer mediaPlayer;
	AnimationTimer animationTimer;
	GameState gameState;
	//Static values of timer that can be cancled in other class 
	static Timer coinTimer;
	static TimerTask coinTask;
	static Timer timeoverTimer;
	static TimerTask timeoverTask;
	
		public Game(int difficulty, String THEME, Stage stage, String username, MediaPlayer mediaPlayer) {
		
		if(username.equals("")) {
			this.username = "player 1"; //default username
		}
		else {
			this.username = username;
		}
		
		this.mediaPlayer = mediaPlayer; // to pass into start scene when user wants to start over
		this.stage = stage;
		pane = new Pane();
		
		timeoverTimer = new Timer(); 
		timeoverTask = new TimerTask() { // Task that ends the game after 1 min since game started 
			@Override
		    public void run() {
		    Platform.runLater(new Runnable() {
		       public void run() {	
	    	   		try {
						gameState.gameOver();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		       }
			    });
			}
		};
		
		timeoverTimer.schedule(timeoverTask, 6*10000);
		
		// Every 10 seconds, coins appear and give animation.(move bottom to top) //
		
		coins = new ArrayList<BonusCoinObject>(); // initialize coin arraylist 
		
		coinTimer = new Timer();
		coinTask = new TimerTask() { // Task that creates coin images into coin arraylist, and 
									// Execute animation of the coin 
			@Override
			public void run() {
			    Platform.runLater(new Runnable() {
			       public void run() {	
			    	   
			        	for(int i = 0; i < numOfCoins; i++) {	
			    			
			    			rand = new Random();
			    			int initialX = rand.nextInt(gameWidth) + 1; // pick random x and y values 
			    			int initialY = rand.nextInt(gameHeight) + 1;
			    			
			    			Image image = new Image("coin.png", ballsize, ballsize, false, false);
			    			// Create coins 
			    			BonusCoinObject coin = new BonusCoinObject(image, gameWidth, gameHeight, initialX, initialY, speed, gameState, pane);
			    			pane.getChildren().addAll(coin);
			    			coins.add(coin);
			    		}
			        	
			        	AnimationTimer animationtimer = new AnimationTimer() {

			    			@Override
			    			public void handle(long now) {
			    				for(BonusCoinObject coin: coins) {
			    					coin.move();
			    				}
			    			}
			    		};  	    		
			    		animationtimer.start(); // start the animation timer		          
			      }
			    });
			}
		};
		
		//Coin Timer that execute coin task every 10 seconds 
		coinTimer.schedule(coinTask, 1*10000, 1*10000);
	
		// Initialize condition of the game based on user's chosen difficulty level
		// As difficulty gets harder :
		// Ball size gets smaller, speed gets faster, number of objects increases 
		if(difficulty == 0) { //EASY	
			
			ballsize = 70;
			speed = 1;
			numOfObject = 2;
			numOfBomb = 3; 
			numOfMysteryBox = 5; 
			
		}
		else if(difficulty == 1) { //MEDIUM
			
			ballsize = 60;
			speed = 2;
			numOfObject = 3;
			numOfBomb = 10; 
			numOfMysteryBox = 8; 
			
		}
		if(difficulty == 2) { //HARD
			
			ballsize = 50;
			speed = 3;
			numOfObject = 5;
			numOfBomb = 15; 
			numOfMysteryBox = 13; 
			
		}
		
		//Add theme images to an arraylist based on user's choice 
		if(THEME == "alien") {
			
			theme = new ArrayList<String>();
			theme.add("Alien1.png");
			theme.add("ufo.png");
			theme.add("Alien3.jpg");	
			theme.add("Alien4.png");	
			theme.add("Alien5.jpg");	
			
		}
		
		if(THEME == "rickAndMorty") {
			
			theme = new ArrayList<String>();
			theme.add("planet1.jpg");
			theme.add("planet2.png");
			theme.add("planet3.png");
			theme.add("planet4.png");
			theme.add("planet6.png");
			theme.add("planet7.png");
		}
		
	}
	
	//create Game Scene
	 public Scene createScene() {
	   
		rand = new Random();
		
        initializeStatus();
        
        //Initialize GameState after initialize Status. 
        //because currentScore,currentLives are initialized in initializeStatus()
        GameState gameState = new GameState(LIVES, TOTALSCORE, username, stage, pane, currentScore, currentLives, mediaPlayer);
		this.gameState = gameState;
		
        initializeObjects();
        animate(); // start animation on images on the scene 
               
        scene = new Scene(pane, gameWidth, gameHeight, Color.BLUE);
        Image image = new Image("mouseClick.png");  //pass in the image path for the mouse
        scene.setCursor(new ImageCursor(image)); // set mouse cursor's image
        pane.getStylesheets().add("gameStyle.css"); //css for the pane
        
        return scene;
    }


	private void initializeStatus() {
		
		HBox status = new HBox(20);
		
		gameTimer = new GameTimer(60); // timer starts from 60 second
		gameTimer.start(status); // start timer 

		//display name on the scene
		displayName= new Text("Player: " + username + " is playing");
		StartGameScene.styleTitle(displayName);
		displayName.setStyle("-fx-font-size: 16pt; -fx-fill: white;"); // style
				
		//display score on the scene
		currentScore = new Text("Score: " + 0);
		StartGameScene.styleTitle(currentScore);
		currentScore.setStyle("-fx-font-size: 16pt; -fx-fill: white;"); // style
		
		//display life on the scene
		currentLives = new Text("Lives: " + 3);
		currentLives.setStyle("-fx-font-size: 16pt; -fx-fill: white;"); // style
		StartGameScene.styleTitle(currentLives); // style 
		
		//button to start over the game 
		Button startOver = new Button("Start Over");
		status.getChildren().addAll(displayName, currentScore, currentLives, startOver);
        pane.getChildren().addAll(status);
        
        //button to go back to main (first) scene 
        startOver.setOnAction(new EventHandler<ActionEvent>() {
			
            public void handle(ActionEvent event) {         
            	
               //game begin 
            		StartGameScene startScene = new StartGameScene(stage, mediaPlayer);
            		Scene mainMenu = startScene.createScene();
	            stage.setScene(mainMenu);
	            
	            //When moving to Start over page, cancle the coin timer and timeover timer
	            timeoverTask.cancel();
	            timeoverTimer.cancel();
	            coinTask.cancel();
	            coinTimer.cancel();
                
            }           
        });

	}

	//initialize obejcts on the scene 
	private void initializeObjects() {
		
		catchableObjects = new ArrayList<CatchableObject>();
		bombs = new ArrayList<TrapObject>();
		mysteryBox = new ArrayList<MysteryObject>();
		
		CatchableObject objects;
		TrapObject bomb;
		MysteryObject box;
		Image image;
		int initialX;
		int initialY;
		
		//Initialize the objects 
		for(int i = 0; i < numOfObject; i++) {
			
			for(int j = 0; j < theme.size(); j++) {	
				
				rand = new Random();
				initialX = rand.nextInt(gameWidth) + 1; // pick random x and y values (start x, y point of the image)
				initialY = rand.nextInt(gameHeight) + 1;
				
				image = new Image(theme.get(j), ballsize, ballsize, false, false);
				objects = new CatchableObject(image, gameWidth, gameHeight, initialX, initialY, speed, gameState, pane, true);
				pane.getChildren().addAll(objects);
				catchableObjects.add(objects);
				
			}
		}
		
		for(int i = 0; i < numOfBomb; i++) {	
			
			rand = new Random();
			initialX = rand.nextInt(gameWidth) + 1; // pick random x and y values (start x, y point of the image)
			initialY = rand.nextInt(gameHeight) + 1;
			
			image = new Image("bomb.png", ballsize, ballsize, false, false);
			bomb = new TrapObject(image, gameWidth, gameHeight, initialX, initialY, speed,  gameState, pane);
			pane.getChildren().addAll(bomb);
			bombs.add(bomb);
		}
		
		for(int i = 0; i < numOfMysteryBox; i++) {	
			
			rand = new Random();
			initialX = rand.nextInt(gameWidth) + 1; // pick random x and y values (start x, y point of the image)
			initialY = rand.nextInt(gameHeight) + 1;
			
			image = new Image("mysteryBox.png", ballsize, ballsize, false, false);
			box = new MysteryObject(image, gameWidth, gameHeight, initialX, initialY, speed,  
					gameState, pane, bombs, catchableObjects, theme);
			pane.getChildren().addAll(box);
			mysteryBox.add(box);
		}
	}
	
	void animate() {

		/*Background Animation: Create Rectangles*/
		
		int initialX = 0;
		int initialY = 0;
		ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
		
		//Create 100 rectangles with random x y values to start on the scene. 
		for(int i = 0; i < 100; i++) {
			
			initialX = rand.nextInt(gameWidth) + 1; //pick random x and y values 
			initialY = rand.nextInt(gameHeight) + 1;
			final Rectangle rect = new Rectangle(initialX, initialY, 5, 5);
			rect.setFill(Color.WHITE);
		    rect.setOpacity(2.0);
		    rectangles.add(rect);
		 	pane.getChildren().add(rect);
		 	
		}	
		 		
		AnimationTimer animationtimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				
				for(CatchableObject ball: catchableObjects) {
					ball.move();
				}
				for(TrapObject bomb: bombs) {
					bomb.move();
				}	
				for(MysteryObject box: mysteryBox) {
					box.move();
				}
				
				/*Background Animation: Give rectangles flickering effect*/
					//change color to white => yellow => blue => green 
					//and give slight change of x and y 
				for(Rectangle rect: rectangles) {

					if( rect.getFill() == Color.WHITE) {
						rect.setFill(Color.YELLOW);
						rect.setHeight(5);
						rect.setWidth(5);
						rect.setOpacity(0.5);
						rect.setX(rect.getX()+3);
						rect.setY(rect.getY()+3);
					}
					else if( rect.getFill() == Color.YELLOW) {
						rect.setFill(Color.BLUE);
						rect.setHeight(3);
						rect.setWidth(3);
						rect.setOpacity(0.5);
						rect.setX(rect.getX()-3);
						rect.setY(rect.getY()-3);
					}
					else if( rect.getFill() == Color.BLUE) {
						rect.setFill(Color.GREEN);
						rect.setHeight(5);
						rect.setWidth(5);
						rect.setOpacity(0.5);
						rect.setX(rect.getX()+3);
						rect.setY(rect.getY()+3);
					}
					else if( rect.getFill() == Color.GREEN) {
						rect.setFill(Color.WHITE);
						rect.setHeight(5);
						rect.setWidth(5);
						rect.setOpacity(0.5);
						rect.setX(rect.getX()-3);
						rect.setY(rect.getY()-3);
					}
				}
			}
		};  
		
		animationtimer.start(); // start the animation timer	
	}
}

