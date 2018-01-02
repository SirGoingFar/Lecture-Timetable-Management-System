
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class addCourseBase{

    static Stage window;
    static Stage windowAnother;
    private static Label nameLabel;
    //private static Label semesterLabel;
    private static TextField nameField;
    private static Button createButton;
    private static Button cancelButton;
    static Scene scene;
    
    
    public static void display(){
    
        window = new Stage();
        window.setTitle("Add Coursebase");
        window.centerOnScreen();
        window.resizableProperty().setValue(Boolean.FALSE);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(getScene());
        window.show();
    }
    
    public static Scene getScene(){
        
        nameLabel = new Label();
        nameLabel.setText("Coursebase Name");
        
        nameField = new TextField();
        nameField.setPromptText("Enter Coursebase Name");
        
        HBox hbox1 = new HBox(20);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(nameLabel,nameField);
        
//        semesterLabel = new Label();
//        semesterLabel.setText("Semester Type");
//        
//        ChoiceBox<String> semesterType = new ChoiceBox<>();
//        semesterType.getItems().addAll("Harmattan","Rain");
//        semesterType.setValue("Harmattan");
        
//        HBox hbox2 = new HBox(20);
//        hbox2.setAlignment(Pos.CENTER);
////        hbox2.getChildren().addAll(semesterLabel,semesterType);
////        createButton.setOnAction(e -> proceed(createButton.getText(), semesterType.getValue()));
        
        createButton = new Button("Create");
        createButton.setOnAction(e -> proceed(nameField.getText()));
        cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> window.close());
        
        HBox hbox3 = new HBox(30);
        hbox3.setAlignment(Pos.CENTER);
        hbox3.getChildren().addAll(createButton,cancelButton);
        
        
        VBox layout = new VBox(25);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(hbox1,hbox3);
        
        //      --------------------------------------------------------------------
           String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",256,256,256);
            layout.setStyle(style);
//      --------------------------------------------------------------------
        
        
        return new Scene(layout,300,100);
    }
    
//    private static void proceed(String courseBaseName, String semesterType){
    private static void proceed(String courseBaseName){
        
        dbConnect connect = new dbConnect();
        connect.add(courseBaseName);
        // Write a code to the database to create a new Coursebase, E.G. create(courseBaseName);
        /*
        try{
        
        }
        catch(Exception e){}
    }
        
        ::::::::::Test whether the input to the field is a String or otherwise before allowing PROCEED::::::::
         */
        
        window.close();
        addCourse();
    }  
    
    private static void addCourse(){
    
        windowAnother = new Stage();
        windowAnother.setTitle("Add Course");
        windowAnother.centerOnScreen();
        windowAnother.resizableProperty().setValue(Boolean.FALSE);
        windowAnother.initModality(Modality.APPLICATION_MODAL);
        windowAnother.setScene(getScene2());
        window.setAlwaysOnTop(true);
        windowAnother.show();
    }
    
    public static Scene getScene2(){
                
        Button Next;
        Button Home;
       
        
        //Header
        String title = nameField.getText() + " Coursebase";
        Label coursebaseName = new Label(title);
        coursebaseName.setFont(new Font("Arial Black",30));
//        coursebaseName.setScaleX(2.5);
//        coursebaseName.setScaleY(2.5);
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.getChildren().add(coursebaseName);
        
        
        //Course code
        Label option1 = new Label("     Course Code");
        TextField field1 = new TextField();
        field1.setPromptText("Course Code (String vale without space)");
        HBox hbox1 = new HBox(50);
        hbox1.getChildren().addAll(option1,field1);
        
        //Course title
        Label option2 = new Label("     Course Title");
        TextField field2 = new TextField();
        field2.setPromptText("Course Title (String value)");
        HBox hbox2 = new HBox(55);
        hbox2.getChildren().addAll(option2,field2);
        
        //Course Unit
        Label option3 = new Label("     Course Unit");
        TextField field3 = new TextField();
        field3.setPromptText("Course Unit (int value)");
        HBox hbox3 = new HBox(55);
        hbox3.getChildren().addAll(option3,field3);
        
        //Course Duration
        Label option4 = new Label("     Lecture Duration");
        TextField field4 = new TextField();
        field4.setPromptText("Course Lecture Duration (int value)");
        HBox hbox4 = new HBox(29);
        hbox4.getChildren().addAll(option4,field4);
        
        //Course Description
        Label option5 = new Label("     Course Description");
        TextField field5 = new TextField();
        field5.setPromptText("Course Description (String value)");
        HBox hbox5 = new HBox(18);
        hbox5.getChildren().addAll(option5,field5);
        
        //Course Population
        Label option6 = new Label("     Course Population");
        TextField field6 = new TextField();
        field6.setPromptText("Course Population (int value)");
        HBox hbox6 = new HBox(22);
        hbox6.getChildren().addAll(option6,field6);
        
        VBox vbox = new VBox(23);
        vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5,hbox6);
        
        //Buttons
        Next = new Button("Input Next Course");
        Next.setOnAction(e -> {
        
        int Field3 = Integer.parseInt(field3.getText());
        int Field4 = Integer.parseInt(field4.getText());
        int Field6 = Integer.parseInt(field6.getText());
        
        dbConnect connect = new dbConnect();
        connect.add(nameField.getText(),field1.getText(),field2.getText(),Field3,Field4,Field6,field5.getText());
        currentStatus.display("Notification", "Enter next course");
        
        field1.clear();
        field2.clear();
        field3.clear();
        field4.clear();
        field5.clear();
        field6.clear();
        
        });
        
        Home = new Button("Go Home");
        Home.setOnAction(e -> windowAnother.close());
                
        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(Next,Home);
        
        VBox pageMerge = new VBox(35);
        pageMerge.getChildren().addAll(header,vbox,hbox);
        pageMerge.setAlignment(Pos.CENTER);
        
        //      --------------------------------------------------------------------
           String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",256,256,256);
            pageMerge.setStyle(style);
//      --------------------------------------------------------------------
        
        return new Scene(pageMerge,380,400);
    }
}