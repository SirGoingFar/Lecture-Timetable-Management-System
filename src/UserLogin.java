import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class UserLogin extends Application{
    
    Stage window;
    TextField nameField;
    PasswordField passwordField;
            
    public static void main(String args[]){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
    
        window = primaryStage;
        window.setTitle("Timetable Management System");
        window.centerOnScreen();
        window.resizableProperty().setValue(Boolean.FALSE);
//        window.initStyle(StageStyle.UTILITY);
//        window.initStyle(StageStyle.UNDECORATED);
      
        //Picture Tag
        Label picture = new Label ();
        Image image = new Image(getClass().getResourceAsStream("TimerPix.png"));
        picture.setGraphic(new ImageView(image));
        VBox vbox = new VBox();
        vbox.getChildren().add(picture);
        
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(8);
        grid.setAlignment(Pos.CENTER);
        
        //UserName tag
        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel,0,0);
        
        //UserName field
        nameField = new TextField();
        nameField.setPromptText("Your Username");
        GridPane.setConstraints(nameField,1,0);
            
        //Password Tag
        Label passwordLabel = new Label ("Password");
        GridPane.setConstraints(passwordLabel,0,2);
        
        //Password field
        passwordField = new PasswordField();
        passwordField.setPromptText("Your Password");
        GridPane.setConstraints(passwordField,1,2);
        
        //Login button
        Button Login = new Button("Login");
        GridPane.setConstraints(Login,0,5);
        Login.setDefaultButton(true);
        Login.setOnAction(e -> validate(nameField, passwordField));
        
        //Cancel button
        Button Cancel = new Button("Cancel");
        Cancel.setCancelButton(true);   //note
        GridPane.setConstraints(Cancel,1,5);

        grid.getChildren().addAll(nameLabel, nameField, passwordLabel, passwordField, Login, Cancel);
        
        
        BorderPane borderpane = new BorderPane();
        borderpane.setLeft(vbox);
        borderpane.setRight(grid);
        
        //      --------------------------------------------------------------------
           String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",256,256,256);
            borderpane.setStyle(style);
//      --------------------------------------------------------------------
        
        
        Scene scene = new Scene(borderpane, 450, 200, Color.BLUE);
        window.setScene(scene);
        window.centerOnScreen();
        window.show();
    }
    
    protected void validate(TextField textfield, PasswordField passwordfield){
    
        if((("ADMIN".equals(textfield.getText())) || ("Admin".equals(textfield.getText())) || ("admin".equals(textfield.getText()))) && (("ADMIN".equals(passwordfield.getText())) || ("Admin".equals(passwordfield.getText())) || ("admin".equals(passwordfield.getText())))){
        
            MainScene mainscene = new MainScene();
            window.setScene(mainscene.Scene());
            window.centerOnScreen();
        
        }
        
        else{
        
                AlertBox.display("User Login Error", "Username and Password mismatch. Try again!");
                nameField.clear();
                nameField.setPromptText("Enter correct Username");
                
                passwordField.clear();
                passwordField.setPromptText("Enter correct Password");
        }
    }

}