package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

//Starting class
public class Catchy extends Application{
	
	public static final int gameWidth = 700; //Game Width 
    public static final int gameHeight = 700; // Game Height 
    public static Scene mainMenu;    
	private Stage stage;
	Media sound;
	MediaPlayer mediaPlayer;
	
    @Override
    public void start(Stage PrimaryStage) {
    		
    		//Setting default Background Music
    		String musicFile = "src/SpaceCube.mp3";     
        sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
         
    		this.stage = PrimaryStage;
    		stage.setTitle("Welcome to Catchy!");
    		displayWelcomeScene();
    	
    }

    private void displayWelcomeScene() {
    	
    		//Initialize the first scene. Getting the scene from class startScene
    		StartGameScene startScene = new StartGameScene(stage, mediaPlayer);
    		Scene mainMenu = startScene.createScene();
        stage.setScene(mainMenu);  
        stage.show();
 
	}
   
	public static void main(String[] args) {
        launch();
    }
}