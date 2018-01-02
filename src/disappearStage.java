//import javafx.time.Duration;
//import java.time.*;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;

import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;


public class disappearStage extends Application{

   
    final Stage stage = new Stage();
          
    public static void main(String args[]){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
    
        stage.setScene(new Scene(new Label("Hello")));
        stage.show();
        
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1) ,new EventHandler<ActionEvent>(){
        
            @Override
            public void handle(ActionEvent event){
            
                stage.hide();
            }
        }));
        
        timeline.play();
    }   
}