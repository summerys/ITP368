package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Main scene (first scene)
public class StartGameScene {
	
	private Stage stage;
	private GridPane pane;
	public static Scene mainScene;
	public static Scene gameScene;
	public static Scene tutorialScene;
	
	private HBox difficultyButtons;
	private HBox themeButtons;
	
	ToggleGroup difficultyToggleButton = new ToggleGroup();
	ToggleGroup themeToggleButton = new ToggleGroup();
	
	public int DIFFICULTY = 2; // default difficulty value
	public String THEME = "alien"; // default theme value 
	
	Text difficultyAlert;
	Text themeAlert;
	TextField textField;
	String username;
	Text title;
	MediaPlayer mediaPlayer;

	Game game;
	
	public StartGameScene(Stage stage, MediaPlayer mediaPlayer) {
		
		this.stage = stage; // get mediaPlayer to change the background music in game scene
		this.mediaPlayer = mediaPlayer;
	}
	
	//Returns the main Scene 
	public Scene createScene() {
	
        pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));    
        pane.setVgap(5); 
        pane.setHgap(5); 
        pane.setAlignment(Pos.CENTER); 
    
        pane.setId("menu");
        
        createUserInformation();
        createItemsForMainMenu();

        mainScene = new Scene(pane, Catchy.gameWidth, Catchy.gameHeight, Color.ALICEBLUE);
        mainScene.getStylesheets().add("style.css");
        
        return mainScene;
	}
	
	//Setting textbox for user to input their name
	private void createUserInformation(){
		
		//Textbox that lets user to input their name
		Text name = new Text("Player's Name:");
		styleTitle(name);
		name.setId("select"); //set ID to use in css
		textField = new TextField ();
		
		HBox userInfo = new HBox();
		userInfo.getChildren().addAll(name, textField);
		userInfo.setSpacing(10);
		
		pane.add(userInfo, 0, 1); 	
	}
    
	//Display title, theme, difficulty 
	private void createItemsForMainMenu() {
		
		VBox startMenu = new VBox(10);	
		VBox themeMenu = new VBox(10);
		VBox startMenuButton = new VBox(10);
		VBox difficultyMenu = new VBox(10);
		startMenu.setAlignment(Pos.CENTER);
		themeMenu.setAlignment(Pos.CENTER);
		difficultyMenu.setAlignment(Pos.CENTER);
		startMenuButton.setAlignment(Pos.CENTER);
		
		//Title
		title = new Text("Catchy");
		styleTitle(title);
		title.setId("title"); // to use in css
		
		startMenu.getChildren().addAll(title);
		pane.add(startMenu, 0, 0); 	

		//Set theme
		Text theme = new Text("Theme:"); 
		styleTitle(theme); // style the text 
		theme.setId("select"); // style the text 
		themeMenu.getChildren().addAll(theme);
		pane.add(themeMenu, 0, 2); 
		
		//Display theme buttons
		displayThemeMenu(themeMenu, pane);
			
		Text diff = new Text("Difficulty:"); 
		styleTitle(diff); // style the text 
		diff.setId("select"); // style the text 
		difficultyMenu.getChildren().addAll(diff);
		pane.add(difficultyMenu, 0, 4); 
		
		Button Instruction = new Button("How to play"); 
		Instruction.setId("Instruction");
		Button start = new Button("START"); 

		startMenuButton.getChildren().addAll(Instruction, start);
		pane.add(startMenuButton, 0, 9);
        	
		//Display difficulty buttons
        	displayDifficultyMenu(difficultyMenu);
        	
        	//game begin (Move to game scene) when start button is pressed 
    		start.setOnAction(new EventHandler<ActionEvent>() {
    			
            public void handle(ActionEvent event) {         	
            
            		if(textField.getText() != null) {
            			username = textField.getText();
            		}else {
            			username = "None";
            		}
            		
            		//Initialize game class and game scene
	            	Game game = new Game(DIFFICULTY, THEME, stage, username, mediaPlayer);
	            	gameScene = game.createScene(); 
	            stage.setScene(gameScene);
	            
            }           
        });
    		
    		Instruction.setOnAction(new EventHandler<ActionEvent>() {
    			
                public void handle(ActionEvent event) {         	    
                	//Create tutorial scene
    	            	Tutorial tutorial = new Tutorial(stage, mediaPlayer);
    	            	tutorialScene = tutorial.createScene(); 
    	            stage.setScene(tutorialScene);
                }           
            });
    	
	}

	//display theme buttons
	private void displayThemeMenu(VBox menu, GridPane root) {
		
		themeButtons = new HBox(10);
		themeButtons.setAlignment(Pos.CENTER);
		
		//Display options of theme
		ToggleButton rickAndMorty = new ToggleButton("RICK&MORTY"); 		
		ToggleButton alien = new ToggleButton("ALIEN");
		
		rickAndMorty.setToggleGroup(themeToggleButton);
		alien.setToggleGroup(themeToggleButton);
		alien.setSelected(true); // set default clicked button

		//sets the theme when button is presed 
		rickAndMorty.setOnAction(new EventHandler<ActionEvent>() {		
            public void handle(ActionEvent event) {   
           	THEME = "rickAndMorty";
            }           
        });
		
		alien.setOnAction(new EventHandler<ActionEvent>() {		
            public void handle(ActionEvent event) {  
            	THEME = "alien";
            }           
        });
		
		themeButtons.getChildren().addAll(rickAndMorty, alien);
		root.add(themeButtons, 0, 3); 
	}

	private void displayDifficultyMenu(VBox menu) {
		
		
		difficultyButtons = new HBox(10);
		difficultyButtons.setAlignment(Pos.CENTER);
		
		// Options of difficulty 
		ToggleButton easy = new ToggleButton("EASY"); 		
		ToggleButton medium = new ToggleButton("MEDIUM"); 
		ToggleButton hard = new ToggleButton("HARD"); 
		easy.setToggleGroup(difficultyToggleButton);
		medium.setToggleGroup(difficultyToggleButton);
		hard.setToggleGroup(difficultyToggleButton);
		medium.setSelected(true);
		
		//Sets the difficulty when button is pressed 
		//Every difficulty has different theme songs
		easy.setOnAction(new EventHandler<ActionEvent>() {	
			
            public void handle(ActionEvent event) {   
            	
            		DIFFICULTY = 0;
            		mediaPlayer.stop();
            		// music change when user press Easy
            		String musicFile = "src/easy.mp3";   
                Media sound = new Media(new File(musicFile).toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                
            }      
           
        });
		
		medium.setOnAction(new EventHandler<ActionEvent>() {
			
            public void handle(ActionEvent event) {
            	
            		DIFFICULTY = 1;
            		mediaPlayer.stop();
            		// music change when user press Medium
            		String musicFile = "src/medium.mp3";     
                Media sound = new Media(new File(musicFile).toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                
    
            }           
        });
		
		hard.setOnAction(new EventHandler<ActionEvent>() {
			
            public void handle(ActionEvent event) {              
            		DIFFICULTY = 2; 
            		mediaPlayer.stop();
            		// music change when user press Hard
            		String musicFile = "src/hard.mp3";     // For example
                Media sound = new Media(new File(musicFile).toURI().toString());
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            }           
        });

		difficultyButtons.getChildren().addAll(easy, medium, hard);	
		pane.add(difficultyButtons, 0, 5); 
	}
	
	// method for font style --> used this font throughout the game 
	// Made it static so it is easier for other class to use this method
		static void styleTitle(Text title) {
			
			Blend blend = new Blend();
			blend.setMode(BlendMode.MULTIPLY);

			DropShadow ds = new DropShadow();
			ds.setColor(Color.rgb(254, 235, 66, 0.3));
			ds.setOffsetX(5);
			ds.setOffsetY(5);
			ds.setRadius(5);
			ds.setSpread(0.2);

			blend.setBottomInput(ds);

			DropShadow ds1 = new DropShadow();
			ds1.setColor(Color.web("#f13a00"));
			ds1.setRadius(20);
			ds1.setSpread(0.2);

			Blend blend2 = new Blend();
			blend2.setMode(BlendMode.MULTIPLY);

			InnerShadow is = new InnerShadow();
			is.setColor(Color.web("#feeb42"));
			is.setRadius(9);
			is.setChoke(0.8);
			blend2.setBottomInput(is);

			InnerShadow is1 = new InnerShadow();
			is1.setColor(Color.web("#f13a00"));
			is1.setRadius(5);
			is1.setChoke(0.4);
			blend2.setTopInput(is1);

			Blend blend1 = new Blend();
			blend1.setMode(BlendMode.MULTIPLY);
			blend1.setBottomInput(ds1);
			blend1.setTopInput(blend2);

			blend.setTopInput(blend1);

			title.setEffect(blend);
		}

	
}
