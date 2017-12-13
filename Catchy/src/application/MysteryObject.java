package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class MysteryObject extends CatchableObject {
	
	Random rand;
	GameState gameState;

	public MysteryObject(Image img, int maxWidth, int maxHeight, 
			int initialX, int initialY, int speed, GameState gameState, 
			Pane pane, ArrayList<TrapObject> bombs, ArrayList<CatchableObject> catchableObjects, ArrayList<String> theme) {
		super(img, maxWidth, maxHeight, initialX, initialY, speed, gameState, pane, false);
		
		rand = new Random();
		this.gameState = gameState;
		
		//Assign mouse click event when create the object
		setOnMouseClicked(e -> {   
		
			setImage(null);	// make image invisible when clicked				
	    		
	    		int randomMystery = rand.nextInt(4)+1; //randomly choose kinds of mystery box
	    		
	    		if(randomMystery == 1) {
	    			showMessage("One Extra Life!");
	
	    		}else if(randomMystery == 2) {
	    			showMessage("Bonus Points!");
	    			
	    		}else if(randomMystery == 3) {
	    			showMessage("More Characters to catch!");
	    			
	    		}else if(randomMystery == 4) {
	    			showMessage("More bombs!");	
	    		}
	    		
	    		getMystery(randomMystery, bombs, catchableObjects, theme, pane); 
	    		
		});	
	}
	
	public void getMystery(int mystery, ArrayList<TrapObject> bombs, ArrayList<CatchableObject> catchableObjects, ArrayList<String> theme ,Pane pane) {
		
		if(mystery == 1) { // add one extra life
			extraLives();
		}
		else if(mystery == 2) { // random bonus points between 0 to 100 
			giveBonusScore();
		}
		else if(mystery == 3) { // put more clickable objects 
			putMoreClickableObjects(catchableObjects, theme, pane);
		}
		else { //put more bombs
			putMoreBomb(bombs, pane);
		}
		
	}

	private void putMoreBomb(ArrayList<TrapObject> bombs, Pane pane) {
		
		TrapObject bomb;
		int initialX;
		int initialY;
		Image image;
		
		//put 5 more bombs 
		for(int i = 0; i < 5; i++) {	
			
			initialX = rand.nextInt(Game.gameWidth) + 1;
			initialY = rand.nextInt(Game.gameHeight) + 1;
			
			image = new Image("bomb.png", Game.ballsize, Game.ballsize, false, false);
			bomb = new TrapObject(image, Game.gameWidth, Game.gameHeight, initialX, initialY, Game.speed, gameState, pane);
			pane.getChildren().addAll(bomb);
			bombs.add(bomb);
			
		}
		
	}

	private void putMoreClickableObjects(ArrayList<CatchableObject> catchableObjects, ArrayList<String> theme, Pane pane) {
		
		//put 5 more of each CatchableObjects
		for(int i = 0; i < 5; i++) {
			
			for(int j = 0; j < theme.size(); j++) {	
				
				rand = new Random();
				int initialX = rand.nextInt(Game.gameWidth) + 1; //pick random x and y values 
				int initialY = rand.nextInt(Game.gameHeight) + 1;
				
				Image image = new Image(theme.get(j), Game.ballsize, Game.ballsize, false, false);
				CatchableObject objects = new CatchableObject(image, Game.gameWidth, Game.gameHeight, initialX, initialY, Game.speed, gameState, pane, true);
				pane.getChildren().addAll(objects);
				catchableObjects.add(objects);

			}
		}
		
	}
	
	private void giveBonusScore() {
		
		gameState.addScore(rand.nextInt(100)); // get random bonus nubmer between 0 to 100 
	}

	private void extraLives() {
		
		gameState.addLife(1);
		
	}
}
