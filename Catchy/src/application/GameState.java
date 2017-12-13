package application;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//class that holds variables and functions that main game needs 
public class GameState {
	
	public int totalScore;
    public int lives;
    Stage stage;
    Scene scene;
    Pane pane;
    String username;
    Text currentScore;
    Text currentLives;
    int clickableObjectNum;
    MediaPlayer mediaPlayer;
    
    public GameState(int lives, int totalScore, String username, Stage stage, Pane pane, Text currentScore, Text currentLives, MediaPlayer mediaPlayer ) {
    		this.lives = lives;
    		this.totalScore = totalScore;
    		this.stage = stage;
    		this.username = username;
    		this.pane = pane;
    		this.currentLives = currentLives;
    		this.currentScore = currentScore;
    		this.mediaPlayer = mediaPlayer;
    		clickableObjectNum = 0;
    }
    
    //add life and reset the lives on the game scene 
    public void addLife(int life) {
    	
    		lives += life;
    		currentLives.setText("Lives: " + lives);
    		
    }
    
    //subtract life and reset the lives on the game scene 
    public void loseLife(int life) {
    	
    		lives -= life;
    		currentLives.setText("Lives: " + lives);
    		
    }
    
    //add score and reset the score on the game scene 
    public void addScore(int score) {
    	
    		totalScore += score;
    		currentScore.setText("Score: " + totalScore);
    		
    }
    
    //subtract score and reset the score on the game scene 
    public void loseScore(int score) {
    	
		totalScore -= score;
		currentScore.setText("Score: " + totalScore);
		
    }
    
 
	public void addClickableObjectNum() {
		
		clickableObjectNum++;
		
	}

	public void removeClickableObjectNum() {
		
		clickableObjectNum--;
		
	}
	
	/*
	 * Game over when life == 0 OR characters == 0
	 * */	
	
    public void checklife() throws IOException{
    	
		if(lives <= 0) {
			
			gameOver();
			
		}
}

	public void checkClickableObject() throws IOException {
		
		if(clickableObjectNum == 0) {
		
			gameOver();
			
		}
	}
	
    public void gameOver() throws IOException {
    	
        //When moving to Game over page, cancle the coin timer and timeover timer
        Game.timeoverTask.cancel();
        Game.timeoverTimer.cancel();
        Game.coinTask.cancel();
        Game.coinTimer.cancel();
        
        //Initialize game over and create scene, pass the scene to stage to translate to Game over scene.
    		GameOver gameover = new GameOver(totalScore, username, stage, mediaPlayer);
		Scene gameoverScene = gameover.createScene();
		stage.setScene(gameoverScene); 
		
    }
	
}

