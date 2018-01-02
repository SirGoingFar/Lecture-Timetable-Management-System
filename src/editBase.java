import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class editBase{

    Stage window;
    Scene scene1;
    Scene scene2;
    VBox content = new VBox(5);
    VBox container = new VBox(20);
    Connection connection;
    String courseBaseName;
    String current;
    
    // Class Constructor
    public editBase(){
    
        try{
            connection = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablems","root","root");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void display() {
        window = new Stage();
        window.setTitle("List of Coursebases");
        window.setScene(Scene1());
        window.setHeight(768);
        window.setWidth(1366);
        window.centerOnScreen();
        window.show();
    }
    
    
    public Scene Scene1(){
    
        //    --------------------------Coursebase Editing Window----------------------------
        ScrollPane scroll = new ScrollPane(container);
        scroll.setFitToWidth(true);

//     ------------------------------------------------------------------------------
         
        Button addCourse_Base = new Button("Add New Coursebase");
            addCourse_Base.setOnAction(ex -> {
//            container.getChildren().clear();
//            getDBTable();
            addCourseBase.display();
        });
            
        Button closeButton = new Button("Go Home");
        closeButton.setDefaultButton(true);
            closeButton.setOnAction(ex -> {
            window.close();
        });
            
        HBox h_box = new HBox(20);
        h_box.getChildren().addAll(addCourse_Base,closeButton);
        h_box.setAlignment(Pos.CENTER);
        

//     --------------------------Header------------------------------------------   
        Label headerTitle = new Label("List of created Coursebases");
        headerTitle.setFont(new Font("Arial Black",30));
        headerTitle.setAlignment(Pos.CENTER);
        
        VBox Capsule = new VBox();
        Capsule.getChildren().add(headerTitle);
       
        
//----------------------------------ScrollPane Content-------------------------------
  
        getDBTable();
        
        
        scene1 = new Scene(new BorderPane(scroll, Capsule, null, h_box, null), 400, 400);
       
        return scene1;
    }
    
    
    public Scene Scene2(){
    
        //    --------------------------Course Editing Window------------------------------------------------
        ScrollPane scroller = new ScrollPane(content);
        scroller.setFitToWidth(true);

//     ------------------------------------------------------------------------------
        Button addButton = new Button("Add Course");
        
        //Course code
        Label addCourse = new Label("  Add Course :");
        addCourse.setFont(new Font("Arial Black",14));
        
        TextField field1 = new TextField();
        field1.setPromptText("Course Code");
        
        //Course title
        TextField field2 = new TextField();
        field2.setPromptText("Course Title");

        
        //Course Unit
        TextField field3 = new TextField();
        field3.setPromptText("Course Unit");
      
        
        //Course Duration
        TextField field4 = new TextField();
        field4.setPromptText("Lecture Duration");
        
        
        //Course Description
        TextField field5 = new TextField();
        field5.setPromptText("Course Description");
        
        
        //Course Population
        TextField field6 = new TextField();
        field6.setPromptText("Course Population");
 
    
        Button doneButton = new Button("GO BACK");
        doneButton.setDefaultButton(true);
            doneButton.setOnAction(ex -> {
                window.setScene(scene1);
                content.getChildren().clear();
        });
            
        HBox hbox = new HBox(18);
        hbox.getChildren().addAll(addCourse,field1,field2,field3,field4,field5,field6,addButton,doneButton);
        hbox.setAlignment(Pos.CENTER);
        
        
//     --------------------------Header------------------------------------------   
//        Label coursebaseName = new Label(courseBaseName + " Coursebase");
        Label coursebaseName = new Label("Edit Coursebase");
        coursebaseName.setFont(new Font("Arial Black",30));
        coursebaseName.setAlignment(Pos.CENTER);
        
        Label header = new Label("   S/N       Course Code     \t \t \t Course Title \t \t \t      Course Unit      Lecture Duration        Course Description      Course Population    ");
        header.setFont(new Font("Times New Roman",20));
        
        VBox headerCapsule = new VBox(10);
        headerCapsule.getChildren().addAll(coursebaseName,header);
//       ------------------------------------------------------------------------

//        populate the screen with courses in the database
          getDBData(current);
        
        addButton.setOnAction(e -> {
            AnchorPane anchorPane = new AnchorPane();
            String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",210,210,210);
            
            anchorPane.setStyle(style);
            
            Label label1 = new Label(""+(content.getChildren().size()+1));
            AnchorPane.setLeftAnchor(label1, 20.0);
            AnchorPane.setTopAnchor(label1, 5.0);
            label1.setFont(new Font("Calibri",15));
            
            Label label2 = new Label(field1.getText());
            AnchorPane.setLeftAnchor(label2, 112.0);
            AnchorPane.setTopAnchor(label2, 5.0);
            label2.setFont(new Font("Calibri",15));
            
            Label label3 = new Label(field2.getText());
            AnchorPane.setLeftAnchor(label3, 205.0);
            AnchorPane.setTopAnchor(label3, 5.0);
            label3.setFont(new Font("Calibri",15));
            
            Label label4 = new Label(field3.getText());
            AnchorPane.setLeftAnchor(label4, 600.0);
            AnchorPane.setTopAnchor(label4, 5.0);
            label4.setFont(new Font("Calibri",15));
            
            Label label5 = new Label(field4.getText());
            AnchorPane.setLeftAnchor(label5, 730.0);
            AnchorPane.setTopAnchor(label5, 5.0);
            label5.setFont(new Font("Calibri",15));
            
            Label label6 = new Label(field5.getText());
            AnchorPane.setLeftAnchor(label6, 900.0);
            AnchorPane.setTopAnchor(label6, 5.0);
            label6.setFont(new Font("Calibri",15));
            
            Label label7 = new Label(field6.getText());
            AnchorPane.setLeftAnchor(label7, 1100.0);
            AnchorPane.setTopAnchor(label7, 5.0);
            label6.setFont(new Font("Calibri",15));
            
            
            Button button = new Button("Remove");
            button.setId(label2.getText());
            button.setOnAction(evt -> {
                
                content.getChildren().remove(anchorPane);
               
                dbConnect connect = new dbConnect();
                connect.remove(courseBaseName,button.getId());
                        
             });
            AnchorPane.setRightAnchor(button, 5.0);
            AnchorPane.setTopAnchor(button, 5.0);
            AnchorPane.setBottomAnchor(button, 5.0);
            
            anchorPane.getChildren().addAll(label1,label2,label3,label4,label5,label6,label7,button);
            
             int Field3 = Integer.parseInt(field3.getText());
             int Field4 = Integer.parseInt(field4.getText());
             int Field6 = Integer.parseInt(field6.getText());
        
            dbConnect connect = new dbConnect();
            connect.add(courseBaseName,field1.getText(),field2.getText(),Field3,Field4,Field6,field5.getText());
            currentStatus.display("Notification", "Course added successfully!");
        
        field1.clear();
        field2.clear();
        field3.clear();
        field4.clear();
        field5.clear();
        field6.clear();
            
            content.getChildren().add(anchorPane);
        });

        return scene2 = new Scene(new BorderPane(scroller, headerCapsule, null, hbox, null), 400, 400);
    }
    
    public void popScrollPane(String lab2,String lab3,String lab4,String lab5,String lab6,String lab7){
            AnchorPane anchorPane = new AnchorPane();
            String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",210,210,210);
            
            anchorPane.setStyle(style);
            
            Label label1 = new Label(""+(content.getChildren().size()+1));
            AnchorPane.setLeftAnchor(label1, 20.0);
            AnchorPane.setTopAnchor(label1, 5.0);
            label1.setFont(new Font("Calibri",15));
            
            Label label2 = new Label(lab2);
            AnchorPane.setLeftAnchor(label2, 112.0);
            AnchorPane.setTopAnchor(label2, 5.0);
            label2.setFont(new Font("Calibri",15));
            
            Label label3 = new Label(lab3);
            AnchorPane.setLeftAnchor(label3, 205.0);
            AnchorPane.setTopAnchor(label3, 5.0);
            label3.setFont(new Font("Calibri",15));
            
            Label label4 = new Label(lab4);
            AnchorPane.setLeftAnchor(label4, 600.0);
            AnchorPane.setTopAnchor(label4, 5.0);
            label4.setFont(new Font("Calibri",15));
            
            Label label5 = new Label(lab5);
            AnchorPane.setLeftAnchor(label5, 730.0);
            AnchorPane.setTopAnchor(label5, 5.0);
            label5.setFont(new Font("Calibri",15));
            
            Label label6 = new Label(lab6);
            AnchorPane.setLeftAnchor(label6, 900.0);
            AnchorPane.setTopAnchor(label6, 5.0);
            label6.setFont(new Font("Calibri",15));
            
            Label label7 = new Label(lab7);
            AnchorPane.setLeftAnchor(label7, 1100.0);
            AnchorPane.setTopAnchor(label7, 5.0);
            label6.setFont(new Font("Calibri",15));
            
            Button button = new Button("Remove");
            button.setId(lab2);
            
            button.setOnAction(evt -> {
                
                content.getChildren().remove(anchorPane);
                
                dbConnect connect = new dbConnect();
                connect.remove(courseBaseName,button.getId());
            });
            AnchorPane.setRightAnchor(button, 5.0);
            AnchorPane.setTopAnchor(button, 5.0);
            AnchorPane.setBottomAnchor(button, 5.0);
            
            anchorPane.getChildren().addAll(label1,label2,label3,label4,label5,label6,label7,button);
            
            content.getChildren().add(anchorPane);
    }
    
    
    public void getDBData(String coursebaseName){
        
        try{
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM timetablems."+coursebaseName);
        
        while(result.next()){
            
            int courseUnit = result.getInt("courseUnit");
            String c_Unit = String.format("%d",courseUnit);
           
           int lectureDur = result.getInt("lectureDuration");
           String l_dur = String.format("%d",lectureDur);
           
           int coursePopulation = result.getInt("coursePopulation");
           String c_Pop = String.format("%d",coursePopulation);
           
           
            
        popScrollPane(result.getString("courseCode"),result.getString("courseTitle"),c_Unit,l_dur,result.getString("courseDescription"),c_Pop);
        }
        
        
        }catch(SQLException e){
            e.printStackTrace();
        }
  
    }
    
    
    public void getDBTable(){
        
        try{
             DatabaseMetaData m = connection.getMetaData();
             ResultSet tables = m.getTables(null, null, "%", null);
             
             while(tables.next()){
             
                AnchorPane anchorPane = new AnchorPane();
            String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",210,210,210);
            
            anchorPane.setStyle(style);
            
            Label label1 = new Label(""+(container.getChildren().size()+1));
            AnchorPane.setLeftAnchor(label1, 20.0);
            AnchorPane.setTopAnchor(label1, 5.0);
            label1.setFont(new Font("Calibri",15));
            
            Label label2 = new Label(tables.getString(3));
            AnchorPane.setLeftAnchor(label2, 112.0);
            AnchorPane.setTopAnchor(label2, 5.0);
            label2.setFont(new Font("Calibri",15));
     
     if("harmattan".equals(tables.getString(3)) || "rain".equals(tables.getString(3))){
         
         anchorPane.getChildren().addAll(label1,label2);
     }
     else{
     
         Button removeButton = new Button("Remove");
            removeButton.setId(tables.getString(3));
            removeButton.setOnAction(evt -> {
                
                container.getChildren().remove(anchorPane);
                courseBaseName = removeButton.getId();
                current = removeButton.getId();
                dbConnect connect = new dbConnect();
                connect.remove(removeButton.getId());
            });
            AnchorPane.setRightAnchor(removeButton, 10.0);
            AnchorPane.setTopAnchor(removeButton, 5.0);
            AnchorPane.setBottomAnchor(removeButton, 5.0);
            
            
            Button editButton = new Button("Edit");
            editButton.setId(tables.getString(3));
            editButton.setOnAction(evtt -> {
                
                courseBaseName = editButton.getId();
                current = editButton.getId();
                window.setTitle("Edit coursebase : " + editButton.getId());
                window.setScene(Scene2());
            });
            AnchorPane.setRightAnchor(editButton, 100.0);
            AnchorPane.setTopAnchor(editButton, 5.0);
            AnchorPane.setBottomAnchor(editButton, 5.0);
            
            
            anchorPane.getChildren().addAll(label1,label2,editButton,removeButton);
     }
     
     container.getChildren().add(anchorPane);
     
     }
     }
            
//        popScrollPane(result.getString("courseCode"),result.getString("courseTitle"),c_Unit,l_dur,result.getString("courseDescription"),c_Pop);
        
         catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        launch(args);
    }
}