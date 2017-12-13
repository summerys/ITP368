package application;
import java.io.IOException;
import java.util.Random;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

//Parent class of 1.TrabObject 2. MysteryObject 3.BonusCoinObject
//That extends Imageview 
public class CatchableObject extends ImageView{

	private int speed;
	private int maxHeight;
	private int maxWidth;
	boolean isPositiveXMovement;
	boolean isPositiveYMovement;
	Pane pane;
	double x;
	double y;
	double dx;
	double dy;

	public CatchableObject(Image img, int maxWidth, int maxHeight, int initialX, int initialY, int speed, GameState gameState, Pane pane, Boolean IsCharacter) {
		
		super(img);
		super.setX(initialX); super.setY(initialY);	//set initial x and y on the scene 	
		
		Random r = new Random();
		double rangeMin = -1;
		double rangeMax = 1;
		dx = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		dy = rangeMin + (rangeMax - rangeMin) * r.nextDouble(); 
		
		x = initialX;
		y = initialY;
		this.maxHeight = maxHeight - 30; 
		this.maxWidth = maxWidth - 30;
		this.speed = speed;
		isPositiveXMovement = true; 
		isPositiveYMovement = true;
		this.pane = pane;
		
		if(IsCharacter) {
			
			gameState.addClickableObjectNum(); // increase clicable object only when it's the catchable object 
											  // NOT applicable for trap, mystery or coins 	
		}
		
		setOnMouseClicked(e -> {

			showMessage("+3");		// each catchable object is 3 points 
			setImage(null);			// Disable the image 
			gameState.addScore(3);
			gameState.removeClickableObjectNum();
			try {
				gameState.checkClickableObject();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
	}
	
	// Animation of the image on the scene 
	// Bouncing off the wall and move to random directions 
	public void move() {
		
		if(isPositiveXMovement) {
			x = x + (speed * (1+dx));
			this.setX(x);
				
		}else {
			x = x - (speed * (1+dx)) ;
			this.setX(x);
		} 
		
		if(isPositiveYMovement) {
			y = y + (speed * (1+dy));
			this.setY(y);
		}
		else {
			y = y - (speed * (1+dy));
			this.setY(y);	
		}
		
		if( x >= maxWidth ){
			isPositiveXMovement = false;
		}
		if(x <= 0) {
			isPositiveXMovement = true;
		}
		if( y >= maxHeight ){
			isPositiveYMovement = false;
		}
		if(y <= 0) {
			isPositiveYMovement = true;
		}		
	
	}
	
	// Message appears when user presses the objects 
	 public void showMessage(String msg) {
	    	
			Label message = new Label(msg);
			message.setId("message");
			message.setTextFill(Color.GAINSBORO);
			message.setFont(new Font("Arial", 50));
			message.setLayoutX(x-10); // display message where use clicks the object at
			message.setLayoutY(y-10);
			
			pane.getChildren().add(message);
			
			// message stays for 2 seconds and disappear 
			PauseTransition visiblePause = new PauseTransition(
			        Duration.seconds(2)
			);
			
			visiblePause.setOnFinished( event -> message.setVisible(false) );
			visiblePause.play();
	  
	    }


}
