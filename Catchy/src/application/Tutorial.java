package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Tutorial scene
public class Tutorial {
	
	private GridPane pane;
	Scene scene;
	VBox tutorial = new VBox(10);

	HBox characterAndPoints = new HBox();
	HBox coinAndPoints = new HBox();
	HBox loseLife = new HBox();
	HBox bombAndLife = new HBox();
	HBox mysteryBox_1 = new HBox();
	HBox mysteryBox_2 = new HBox();
	HBox mysteryBox_3 = new HBox();
	HBox mysteryBox_4 = new HBox();
	Stage stage;
	MediaPlayer mediaPlayer;
	Text points;
	
	public Tutorial(Stage stage, MediaPlayer mediaPlayer) {
		
		pane = new GridPane();
	    pane.setPadding(new Insets(10, 10, 10, 10));    
        pane.setVgap(5); 
        pane.setHgap(5); 
        pane.setAlignment(Pos.CENTER); 
        this.stage = stage;
        this.mediaPlayer = mediaPlayer;
        
	}
	
	public Scene createScene() {
		
		pane.getStylesheets().add("gameStyle.css");
		setTutorial();
			
		scene = new Scene(pane, Game.gameWidth, Game.gameHeight, Color.BLUE);
		return scene;
	}

	private void setTutorial() {
		
		tutorial.setAlignment(Pos.CENTER);
		
		// Tutorials of 1. how to get points. 2. when to lose life 
		// 3. About mystery box and 4. when game is over 
		getPoints(); 
		loseLife();
		mesteryBox();
		gameOver();		

	}

	//Display when to game over 
	private void gameOver() {
		
		Text gameOver = new Text("Game is over when...");
		Text gameOver_1 = new Text("Run out of time / Run out of Characters / Run out of Lives");
		
		//Font Style
		gameOver.setStyle("-fx-font-size: 15pt; -fx-fill: white;");
		StartGameScene.styleTitle(gameOver);
		gameOver_1.setStyle("-fx-font-size: 12pt; -fx-fill: white;");
		StartGameScene.styleTitle(gameOver_1);
		
		//Button to go back to make page 
		Button goBackToMainPage = new Button("Back to Main Page");
		
		goBackToMainPage.setOnAction(new EventHandler<ActionEvent>() {
			
            public void handle(ActionEvent event) {         
               //game begin 
            		StartGameScene startScene = new StartGameScene(stage, mediaPlayer);
            		Scene mainMenu = startScene.createScene();
	            stage.setScene(mainMenu);
         
            }           
        });
		
		//Put Hbox into VBox 
		tutorial.getChildren().addAll(gameOver, gameOver_1, goBackToMainPage);
	}

	private void mesteryBox() {
		
		Text bonus = new Text("A little bonus...but who knows what you get?");
		bonus.setStyle("-fx-font-size: 15pt; -fx-fill: white;"); //style 
		StartGameScene.styleTitle(bonus);
		tutorial.getChildren().addAll(bonus);
		
		//Mysterybox 1
		Image mysterybox1 = new Image("mysteryBox.png", 50, 50, false, false);
		ImageView imgView1 = new ImageView(mysterybox1);
		points = new Text("More Bombs are generated");
		StartGameScene.styleTitle(points); //style 
		points.setStyle("-fx-font-size: 12pt; -fx-fill: white;"); // style
		
		mysteryBox_1.getChildren().addAll(imgView1, points);
		tutorial.getChildren().addAll(mysteryBox_1);
		
		//Mysterybox 2
		Image mysterybox2 = new Image("mysteryBox.png", 50, 50, false, false);
		ImageView imgView2 = new ImageView(mysterybox2);
		points = new Text("One extra life"); 
		StartGameScene.styleTitle(points); // font style 
		points.setStyle("-fx-font-size: 12pt; -fx-fill: white;"); // style
		
		mysteryBox_2.getChildren().addAll(imgView2, points);
		tutorial.getChildren().addAll(mysteryBox_2);
		
		//Mysterybox 3
		Image mysterybox3 = new Image("mysteryBox.png", 50, 50, false, false);
		ImageView imgView3 = new ImageView(mysterybox3);
		points = new Text("Random bonus Points between 1-100 points");
		StartGameScene.styleTitle(points); // font style 
		points.setStyle("-fx-font-size: 12pt; -fx-fill: white;"); // style
		
		mysteryBox_3.getChildren().addAll(imgView3, points);
		tutorial.getChildren().addAll(mysteryBox_3);
		
		//Mysterybox 4
		Image mysterybox4 = new Image("mysteryBox.png", 50, 50, false, false);
		ImageView imgView4 = new ImageView(mysterybox4);
		points = new Text("More Characters are generated");
		StartGameScene.styleTitle(points); // font style 
		points.setStyle("-fx-font-size: 12pt; -fx-fill: white;"); // style
		
		mysteryBox_4.getChildren().addAll(imgView4, points);
		tutorial.getChildren().addAll(mysteryBox_4);
		
		pane.getChildren().addAll(tutorial);
		
	}

	private void loseLife() {
		
		Text loseLife = new Text("2. You lose life when you click....");
		loseLife.setStyle("-fx-font-size: 15pt; -fx-fill: white;"); // font style 
		StartGameScene.styleTitle(loseLife);
		
		tutorial.getChildren().addAll(loseLife);
		
		Image image = new Image("bomb.png", 50, 50, false, false);
		ImageView imgView = new ImageView(image);
		points = new Text("-1 Life (Game over when you lose 3 lives)"); // description
		StartGameScene.styleTitle(points); // font style 
		points.setStyle("-fx-font-size: 12pt; -fx-fill: white;"); // style
		
		bombAndLife.getChildren().addAll(imgView, points);
		tutorial.getChildren().addAll(bombAndLife);
	
	}

	private void getPoints() {
		
		Text howToGetPoints = new Text("1. Click to get points! ");
		howToGetPoints.setStyle("-fx-font-size: 15pt; -fx-fill: white;");
		StartGameScene.styleTitle(howToGetPoints);
		tutorial.getChildren().addAll(howToGetPoints);
		
		Image image = new Image("Alien1.png", 50, 50, false, false);
		ImageView imgView = new ImageView(image);
		points = new Text("+3 points");
		StartGameScene.styleTitle(points);
		points.setStyle("-fx-font-size: 12pt; -fx-fill: white;"); // style
		
		characterAndPoints.getChildren().addAll(imgView, points);
		tutorial.getChildren().addAll(characterAndPoints);
		
		image = new Image("coin.png", 50, 50, false, false);
		imgView = new ImageView(image);
		points = new Text("+20 points (Coins appear on screen every 10 seconds)");
		StartGameScene.styleTitle(points);
		points.setStyle("-fx-font-size: 12pt; -fx-fill: white;");
		
		coinAndPoints.getChildren().addAll(imgView, points);
		tutorial.getChildren().addAll(coinAndPoints);
	}
}
