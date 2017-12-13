package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameOver {
	
	int score;
	String username;
	private Scene scene;
	ArrayList<Score> scores;
	Text individualScore;
	GridPane pane;
	Stage stage;
	MediaPlayer mediaPlayer;
	
	public GameOver(int score, String username, Stage stage, MediaPlayer mediaPlayer) throws IOException{
		
		this.score = score;
		this.username = username;
		this.mediaPlayer = mediaPlayer;
		
		scores = new ArrayList<Score>();
		readFile();
		
		Score playerScore = new Score(username,score);
		scores.add(playerScore);
		
		pane = new GridPane();
		pane.setAlignment(Pos.CENTER); 
		this.stage = stage;
		
		// Sort highest to lowest score
		Collections.sort(scores, new Comparator<Score>() {
		    @Override
		    public int compare(Score lhs, Score rhs) {
		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
		        return lhs.getScore() > rhs.getScore() ? -1 : (lhs.getScore() < rhs.getScore()) ? 1 : 0;
		    }
		});
		
	}

	private void readFile() throws IOException {
		
		//Read the textfile that has the information of the scores 
		BufferedReader br = new BufferedReader(new FileReader("src/scores.txt"));
		try {
			
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine(); // First line 
		    
		    // split and add the very first line 
		    String[] temp = line.split(",");
    			Score playerScore = new Score(temp[0], Integer.valueOf(temp[1]) );
    			scores.add(playerScore); 

		    while (line != null) {
		    		//Each line has name and score seperated by comma. 
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
			    	System.out.println(line);
			    	if(line != null) {
			        temp = line.split(",");
			    		playerScore = new Score(temp[0], Integer.valueOf(temp[1]) );
			    		scores.add(playerScore);     
			    	}
		    }
		} finally {
		    br.close();
		}
	}

	//Save current user's username and score 
	private void writeToFile() {
		
		try(FileWriter fw = new FileWriter("src/scores.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{  
				out.print("\n"+username+","+score);
			} catch (IOException e) {
			    
			}
		
	}

	public Scene createScene() {
		
		initializeScoreStatus();	
		Button startOver = new Button("Start Over");
	
		pane.add(startOver, 0, 1);		
		
		//Go to main scene
		startOver.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {         
            		//Create startscene and pass onto stage 
            		StartGameScene startScene = new StartGameScene(stage, mediaPlayer);
            		Scene mainMenu = startScene.createScene();
	            stage.setScene(mainMenu);
                
            }           
        });
		
		scene = new Scene(pane, Game.gameWidth, Game.gameHeight, Color.BLUE);	             
		scene.getStylesheets().add("style.css");
		
		writeToFile();
		return scene;
	}

	private void initializeScoreStatus() {
		
		//Display highest score 
		VBox score = new VBox(10);
		score.setAlignment(Pos.CENTER);
		Text displayScore = new Text("Highest Scores");
		StartGameScene.styleTitle(displayScore);
		displayScore.setStyle("-fx-font-size: 16pt; -fx-fill: white;");
		
		score.getChildren().addAll(displayScore);
		
		// Whene there are less than 10 scores available 
		if(scores.size() < 10) {
			for(int i =0; i<scores.size(); i++) {
				// display scores 
				individualScore = new Text( (i+1) + ". " + scores.get(i).getUsername() + ": " + scores.get(i).getScore() ) ;
				StartGameScene.styleTitle(individualScore);
				individualScore.setStyle("-fx-font-size: 16pt; -fx-fill: white;");
				score.getChildren().addAll(individualScore);
				
			}
		}else { // Print out top 10 highest scores only
			
			for(int i =0; i<10; i++) {
				individualScore = new Text( (i+1) + ". " + scores.get(i).getUsername() + ": " + scores.get(i).getScore() ) ;
				StartGameScene.styleTitle(individualScore);
				individualScore.setStyle("-fx-font-size: 16pt; -fx-fill: white;");
				score.getChildren().addAll(individualScore);
			}
		}
		
		pane.add(score, 0, 0);
	}
	
}
