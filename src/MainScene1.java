import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainScene1 extends Application{

        Stage window;
        Scene scene;
        
    public static void main(String args[]){
        launch(args);
    }
    
    
    public Scene Scene(){
        
        //--------------------------Header Bar-----------------------------------------------
        
        //Right Header Picture
        Image image1 = new Image(getClass().getResourceAsStream("OAU_LOGO.png"));
        Label label1 = new Label();
        label1.setGraphic(new ImageView(image1));
        
        //Left Header Picture
        Image image2 = new Image(getClass().getResourceAsStream("OAU_LOGO.png"));
        Label label2 = new Label();
        label2.setGraphic(new ImageView(image2));
        
        //Header Title
        Label label3 = new Label("LECTURE TIMETABLE MANAGEMENT SYSTEM");
        label3.setFont(new Font("Arial Black",28));
//        label3.setScaleX(2.5);
//        label3.setScaleY(2.5);
        label3.setAlignment(Pos.CENTER);
        
        Label label4 = new Label("Department of Computer Science and Engineering,");
        label4.setFont(new Font("Agency FB",24));
//        label4.setScaleX(1.5);
//        label4.setScaleY(1.5);
        label4.setAlignment(Pos.CENTER);
        
        Label label5 = new Label("Obafemi Awolowo University, Ile-Ife.");
        label5.setFont(new Font("Agency FB",20));
//        label5.setScaleX(1.5);
//        label5.setScaleY(1.5);
        label5.setAlignment(Pos.BOTTOM_CENTER);
        
        //Header Title Merger
        VBox merge = new VBox(10);
        merge.getChildren().addAll(label3,label4,label5);
        merge.setAlignment(Pos.BASELINE_CENTER);
        
        //Header Capsule
        HBox headerhbox = new HBox(10);
        headerhbox.setPadding(new Insets(10,10,10,10));
        headerhbox.getChildren().addAll(label1, merge, label2);
           
        
        //---------------------------------Icon Buttons-------------------------------------------------
        
        //Create Coursebase
        Button button3 = new Button();
        Image image3 = new Image(getClass().getResourceAsStream("CreateBase.png"));
        button3.setGraphic(new ImageView(image3));
        button3.setOnAction(e -> addCourseBase.display());
        
        //Edit Coursebase
        Button button4 = new Button();
        Image image4 = new Image(getClass().getResourceAsStream("EditBase.png"));
        button4.setGraphic(new ImageView(image4));
        button4.setOnAction(e -> {
            
            editBase ed = new editBase();
            ed.display();
        });
        
        //Generate Timetable
        Button button5 = new Button();
        Image image5 = new Image(getClass().getResourceAsStream("GenerateTable.png"));
        button5.setGraphic(new ImageView(image5));
        button5.setOnAction(e -> {
            genTable1 gen = new genTable1();
            gen.display();
        });
        
        //View Timetable
        Button button6 = new Button();
        Image image6 = new Image(getClass().getResourceAsStream("ViewTable.png"));
        button6.setGraphic(new ImageView(image6));
        button6.setOnAction(e -> {
        
            DrawTTUI1 draw = new DrawTTUI1();
            draw.display();
        });
        
        //Icon Merge
        HBox iconhbox = new HBox(60);
        iconhbox.getChildren().addAll(button3,button4,button5,button6);
        iconhbox.setAlignment(Pos.CENTER);
        
        //Notification
        Label label6 = new Label("Welcome! Select 'Create Coursebase' to start.");
        label6.setFont(new Font("Calibri",16));
//        label6.setScaleX(1.5);
//        label6.setScaleY(1.5);
        
        StackPane notif = new StackPane();
        notif.getChildren().add(label6);
        notif.setAlignment(Pos.CENTER);
        
        //page merge
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(20);
        //pane.setHgap(10);
        
        GridPane.setConstraints(headerhbox,0,2);
        GridPane.setConstraints(iconhbox,0,10);  
        GridPane.setConstraints(notif,0,11);
                
        pane.getChildren().addAll(headerhbox,iconhbox,notif);
        pane.setAlignment(Pos.CENTER);
        
        String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",256,256,256);
        pane.setStyle(style);
        pane.setAlignment(Pos.CENTER);
        
        return new Scene(pane);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
    
        window = primaryStage;
        window.setTitle("Lecture Timetable Management System; Dept of Computer Science and Engineering, OAU");
//        window.setWidth(900);
//        window.setHeight(600);
        window.centerOnScreen();
        window.resizableProperty().setValue(Boolean.FALSE);
//        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(Scene());
              
        
        window.setScene(Scene());
        window.show();
    }
}
