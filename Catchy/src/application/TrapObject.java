package application;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class TrapObject extends CatchableObject {
	
	GameState gameState;
	
	public TrapObject(Image img, int maxWidth, int maxHeight, int initialX, int initialY, int speed, GameState gameState, Pane pane) {
		super(img, maxWidth, maxHeight, initialX, initialY, speed, gameState, pane, false);
		
		this.gameState = gameState;
		
		//lose one life when click bomb
		setOnMouseClicked(e -> {	
			showMessage("-1 life :( ");
    			setImage(null);
    			gameState.loseLife(1); 
			//Game over if lives == 0 or time is over 
    			try {
					gameState.checklife();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
		});
	}
}
