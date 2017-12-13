package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

//Class that counts doen from 60 to 0 and display the timer on screen
public class GameTimer {
	
	private Integer STARTTIME;
	private IntegerProperty timeSeconds;	
	private Label timerLabel;
	Timeline timeline;
	
	public GameTimer(Integer time) {
		
		STARTTIME = time;
		timerLabel = new Label();
		timeSeconds = new SimpleIntegerProperty(STARTTIME);
		timerLabel.setFont(new Font("Arial", 30));
		timerLabel.setTextFill(Color.web("white"));
		
	}
	
	public void start(HBox status) {
	
		timerLabel.textProperty().bind(timeSeconds.asString());		
		timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(STARTTIME+1),
                new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        
        status.getChildren().addAll(timerLabel);
        
	}
	
}
