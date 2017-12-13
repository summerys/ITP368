package application;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class BonusCoinObject extends CatchableObject {
	
	double x;
	double y;
	private int speed;
	
	public BonusCoinObject(Image img, int maxWidth, int maxHeight, int initialX, int initialY, int speed, GameState gameState, Pane pane) {
		super(img, maxWidth, maxHeight, initialX, initialY, speed, gameState, pane, false);
		
		x = initialX;
		y = initialY;
		this.speed = speed;
		
		//Set on mouse click event 
		setOnMouseClicked(e -> {
			
			showMessage("+20"); 	// show messages
			setImage(null);		// hide image  
			gameState.addScore(20);	// add to total score 

		});
		
	}

	public void move() {
		y = y-speed;
		this.setY(y);  // move from bottom to top 
	}
}
