import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DrawTTUI1{

    Scene scene1;
    Scene scene2;
    VBox container = new VBox(20);
    VBox content = new VBox(20);
    Stage window = new Stage();
    Stage windowTT = new Stage();
    String courseBaseName;
    String current;
    Connection connection;
    Connection connection1;
    Connection connection2;
    
    public DrawTTUI1(){
        
        try{
            
        connection = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablemsprocess","root","root");
        connection1 = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablemsprocess","root","root");
        connection2 = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablemsprocess","root","root");
        
        }catch(Exception x){}
    
    }
    
    public void display(){
        
        window.setScene(getScene1());
        window.setTitle("List of Timetables");
        window.setHeight(768);
        window.setWidth(1366);
        window.centerOnScreen();
        window.show();
    }
    public Scene getScene1(){
        
        //    --------------------------Coursebase Editing Window----------------------------
        ScrollPane scroll = new ScrollPane(container);
        scroll.setFitToWidth(true);

//     ------------------------------------------------------------------------------
        
        Button newTT = new Button("Create New Timetable");
            
        newTT.setOnAction(ex -> {
        
            genTable gen = new genTable();
            gen.display();
            
        });
            
        Button closeButton = new Button("Go Home");
        closeButton.setDefaultButton(true);
            closeButton.setOnAction(ex -> {
            window.close();
        });
            
        HBox h_box = new HBox(20);
        h_box.getChildren().addAll(newTT,closeButton);
        h_box.setAlignment(Pos.CENTER);
        

//     --------------------------Header------------------------------------------   
        Label headerTitle = new Label("List of Timetables");
        headerTitle.setFont(new Font("Arial Black",30));
        headerTitle.setAlignment(Pos.CENTER);
        
        VBox Capsule = new VBox();
        Capsule.getChildren().add(headerTitle);
        
        getTTNames();
                
        scene1 = new Scene(new BorderPane(scroll, Capsule, null, h_box, null), 400, 400);
        return scene1;
    }
      
    
    
    public Scene getScene2(){
       
         //    --------------------------Course Editing Window------------------------------------------------
        ScrollPane scroller = new ScrollPane(content);
        scroller.setFitToWidth(true);

//     ---------------------------Print Button---------------------------------------------------
        Button printButton = new Button("Print Timetable");
        //        printButton.setOnAction();
        
    
        Button gobackButton = new Button("GO BACK");
        gobackButton.setDefaultButton(true);
            gobackButton.setOnAction(ex -> {
                content.getChildren().clear();
                windowTT.close();
                
        });
            
        HBox hbox = new HBox(18);
        hbox.getChildren().addAll(printButton,gobackButton);
        hbox.setAlignment(Pos.CENTER);
        
        
//     --------------------------Header------------------------------------------   
        Label coursebaseName = new Label(current +" Timetable");
        coursebaseName.setFont(new Font("Arial Black",30));
        coursebaseName.setAlignment(Pos.CENTER);
        
        Label header = new Label("      \tDay            Time           Venue       Course Code          \t\t\tCourse Title\t\t\t            Course Unit   ");
        header.setFont(new Font("Times New Roman",20));
        header.setAlignment(Pos.CENTER);
        
        VBox headerCapsule = new VBox(10);
        headerCapsule.getChildren().addAll(coursebaseName,header);
        
//       ---------------------------populate the timetable---------------------------------------------

            getTableContent(current);
        
        
        scene2 = new Scene(new BorderPane(scroller, headerCapsule, null, hbox, null), 400, 400);
        return scene2;
    }
    
   
    public void getTTNames(){
        
        String name;
        
       try{
           
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM timetablemsprocess.timetablename");
             
             while(result.next()){
             
                AnchorPane anchorPane = new AnchorPane();
            String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",210,210,210);
            
            anchorPane.setStyle(style);
            
            name = result.getString("name");
            
            Label label1 = new Label(""+(container.getChildren().size()+1)+".");
            AnchorPane.setLeftAnchor(label1, 10.0);
            AnchorPane.setTopAnchor(label1, 5.0);
            label1.setFont(new Font("Calibri",15));
            
            Label label2 = new Label(name);
            AnchorPane.setLeftAnchor(label2, 35.0);
            AnchorPane.setTopAnchor(label2, 5.0);
            label2.setFont(new Font("Calibri",15));
            
            
            Button removeButton = new Button("Remove");
            removeButton.setId(name);
            removeButton.setOnAction(evt -> {
                
                container.getChildren().remove(anchorPane);

                processDBConnect connect = new processDBConnect();
                connect.removeTimeTable(removeButton.getId());
                
            });
            AnchorPane.setRightAnchor(removeButton, 10.0);
            AnchorPane.setTopAnchor(removeButton, 5.0);
            AnchorPane.setBottomAnchor(removeButton, 5.0);
            
            
            Button viewButton = new Button("View");
            viewButton.setId(result.getString("name"));
            viewButton.setOnAction(evtt -> {
               
                current = viewButton.getId();
                
                windowTT = new Stage();
                windowTT.setTitle("Timetable : " + current);
                windowTT.setScene(getScene2());
                windowTT.setHeight(768);
                windowTT.setWidth(950);
                windowTT.centerOnScreen();
                windowTT.show();
            });
            AnchorPane.setRightAnchor(viewButton, 100.0);
            AnchorPane.setTopAnchor(viewButton, 5.0);
            AnchorPane.setBottomAnchor(viewButton, 5.0);
            
            
            anchorPane.getChildren().addAll(label1,label2,viewButton,removeButton);
            
            container.getChildren().add(anchorPane);
             }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void getTableContent(String tablename){
    
        String venue1 = String.format("%s%s",tablename,"venue1");
        String venue2 = String.format("%s%s",tablename,"venue2");
        
        String query1 = String.format("SELECT * FROM timetablemsprocess."+venue1);
        String query2 = String.format("SELECT * FROM timetablemsprocess."+venue2);
        
        try{
            
        Statement st1 = connection1.createStatement();
        Statement st2 = connection2.createStatement();
        ResultSet rs1 = st1.executeQuery(query1);
        ResultSet rs2 = st2.executeQuery(query2);   
        String day = "";
        int count = 1;
        int time = 0;
        
            while(rs1.next() && rs2.next()){
                
                String time1[] = {"8 - 10","10 - 12","12 - 2","2 - 4","4 - 5","5 - 6"};
                String time2[] = {"8 - 10","10 - 12","12 - 1","1 - 3","3 - 5","5 - 6"};
            
                if(rs1.getInt("id")<25){
                    
                     String Time = time1[time];
                     
                  //Monday to Thursday
                
                    if(true){

                        if(count == 1)
                        day = "Monday";
                    
                    else if(count == 7)
                        day = "Tuesday";
                    
                    else if(count == 13)
                        day = "Wednesday";
                    
                    else if(count == 19)
                        day = "Thursday";
                    
                     else if(count == 25)
                        day = "Friday";
        
                    AnchorPane anchorPane = new AnchorPane();
                    String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",256,256,256);
                    anchorPane.setStyle(style);
                    
//          ----------------------Day Column-------------------------------
            Label Day = new Label(day);
            AnchorPane.setLeftAnchor(Day, 10.0);
            AnchorPane.setTopAnchor(Day, 5.0);
            Day.setFont(new Font("Arial",18));
            
//          -------------------------Time Slot Column----------------------------    
            Label timeSlot = new Label(Time);
            AnchorPane.setLeftAnchor(timeSlot, 134.0);
            AnchorPane.setTopAnchor(timeSlot, 5.0);
            timeSlot.setFont(new Font("Calibri",15));
            
//          -----------------------Venue Column--------------------------------
            Label Venue1 = new Label("CSCLT");
            Venue1.setFont(new Font("Calibri",15));
            
            Label Venue2 = new Label("Venue 2");
            Venue2.setFont(new Font("Calibri",15)); 
            
            VBox venue = new VBox(10);
            venue.getChildren().add(Venue1);
            AnchorPane.setLeftAnchor(venue, 232.0);
            AnchorPane.setTopAnchor(venue, 5.0);
            
//          -----------------------Course Code Column--------------------------------
            Label course1 = new Label(rs1.getString("courseCode"));
            course1.setFont(new Font("Calibri",15));
            
            Label course2 = new Label(rs2.getString("courseCode"));
            course2.setFont(new Font("Calibri",15)); 
            
            VBox course = new VBox(10);
            course.getChildren().add(course1);
            AnchorPane.setLeftAnchor(course, 345.0);
            AnchorPane.setTopAnchor(course, 5.0);

//         -------------------------Course Title Column-----------------------------
            Label courseTitle1 = new Label(rs1.getString("courseTitle"));
            courseTitle1.setFont(new Font("Calibri",15));
            
            Label courseTitle2 = new Label(rs2.getString("courseTitle"));
            courseTitle2.setFont(new Font("Calibri",15)); 
            
            VBox courseTitle = new VBox(10);
            courseTitle.getChildren().add(courseTitle1);
            AnchorPane.setLeftAnchor(courseTitle, 453.0);
            AnchorPane.setTopAnchor(courseTitle, 5.0);
            
//         -------------------------Course Unit Column-----------------------------
            
            String unit1 = String.format("%d",rs1.getInt("courseUnit"));
            String unit2 = String.format("%d",rs2.getInt("courseUnit"));
            
            Label courseUnit1 = new Label(unit1);
            courseUnit1.setFont(new Font("Calibri",15));
            
            Label courseUnit2 = new Label(unit2);
            courseUnit2.setFont(new Font("Calibri",15)); 
            
            VBox courseUnit = new VBox(10);
            courseUnit.getChildren().add(courseUnit1);
            AnchorPane.setLeftAnchor(courseUnit, 870.0);
            AnchorPane.setTopAnchor(courseUnit, 5.0);
            
            anchorPane.getChildren().addAll(Day, timeSlot, venue, course, courseTitle, courseUnit);
            
            content.getChildren().add(anchorPane);
                    
            
//            ---------------rotate time to print------------------------
                
            if(time <= 4)
            
                time++;
            
            else
                time=0;
                 
//           ------------------------------------------------
             }else{
                    
                        AnchorPane anchorPane = new AnchorPane();
                    String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",256,256,256);
                    anchorPane.setStyle(style);
 
//          -------------------------Time Slot Column----------------------------    
            Label timeSlot = new Label(Time);
            AnchorPane.setLeftAnchor(timeSlot, 134.0);
            AnchorPane.setTopAnchor(timeSlot, 5.0);
            timeSlot.setFont(new Font("Calibri",15));
            
//          -----------------------Venue Column--------------------------------
            Label Venue1 = new Label("CSCLT");
            Venue1.setFont(new Font("Calibri",15));
            
            Label Venue2 = new Label("Venue 2");
            Venue2.setFont(new Font("Calibri",15)); 
            
            VBox venue = new VBox(10);
            venue.getChildren().add(Venue1);
            AnchorPane.setLeftAnchor(venue, 232.0);
            AnchorPane.setTopAnchor(venue, 5.0);
            
//          -----------------------Course Code Column--------------------------------
            Label course1 = new Label(rs1.getString("courseCode"));
            course1.setFont(new Font("Calibri",15));
            
            Label course2 = new Label(rs2.getString("courseCode"));
            course2.setFont(new Font("Calibri",15)); 
            
            VBox course = new VBox(10);
            course.getChildren().add(course1);
            AnchorPane.setLeftAnchor(course, 345.0);
            AnchorPane.setTopAnchor(course, 5.0);

//         -------------------------Course Title Column-----------------------------
            Label courseTitle1 = new Label(rs1.getString("courseTitle"));
            courseTitle1.setFont(new Font("Calibri",15));
            
            Label courseTitle2 = new Label(rs2.getString("courseTitle"));
            courseTitle2.setFont(new Font("Calibri",15)); 
            
            VBox courseTitle = new VBox(10);
            courseTitle.getChildren().add(courseTitle1);
            AnchorPane.setLeftAnchor(courseTitle, 453.0);
            AnchorPane.setTopAnchor(courseTitle, 5.0);
            
//         -------------------------Course Unit Column-----------------------------
            
            String unit1 = String.format("%d",rs1.getInt("courseUnit"));
            String unit2 = String.format("%d",rs2.getInt("courseUnit"));
            
            Label courseUnit1 = new Label(unit1);
            courseUnit1.setFont(new Font("Calibri",15));
            
            Label courseUnit2 = new Label(unit2);
            courseUnit2.setFont(new Font("Calibri",15)); 
            
            VBox courseUnit = new VBox(10);
            courseUnit.getChildren().add(courseUnit1);
            AnchorPane.setLeftAnchor(courseUnit, 870.0);
            AnchorPane.setTopAnchor(courseUnit, 5.0);
            
            anchorPane.getChildren().addAll(timeSlot, venue, course, courseTitle, courseUnit);
            
            content.getChildren().add(anchorPane);
                    
            
//            ---------------rotate time to print------------------------
                
            if(time <= 4)
            
                time++;
            
            else
                time=0;
                    
                    
                    }
                 
                }
                
                
                
//             Friday
                
                
                else{
                
                    String Time = time2[time];
                    
                  if(true){
                      
                    AnchorPane anchorPane = new AnchorPane();
                    String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",256,256,256);
                    anchorPane.setStyle(style);
                    
//          ----------------------Day Column-------------------------------
            Label Day = new Label("Friday");
            AnchorPane.setLeftAnchor(Day, 10.0);
            AnchorPane.setTopAnchor(Day, 5.0);
            Day.setFont(new Font("Arial",18));
            
//          -------------------------Time Slot Column----------------------------    
            Label timeSlot = new Label(Time);
            AnchorPane.setLeftAnchor(timeSlot, 134.0);
            AnchorPane.setTopAnchor(timeSlot, 5.0);
            timeSlot.setFont(new Font("Calibri",15));
            
//          -----------------------Venue Column--------------------------------
            Label Venue1 = new Label("CSCLT");
            Venue1.setFont(new Font("Calibri",15));
            
            Label Venue2 = new Label("Venue 2");
            Venue2.setFont(new Font("Calibri",15)); 
            
            VBox venue = new VBox(10);
            venue.getChildren().add(Venue1);
            AnchorPane.setLeftAnchor(venue, 232.0);
            AnchorPane.setTopAnchor(venue, 5.0);
            
//          -----------------------Course Code Column--------------------------------
            Label course1 = new Label(rs1.getString("courseCode"));
            course1.setFont(new Font("Calibri",15));
            
            Label course2 = new Label(rs2.getString("courseCode"));
            course2.setFont(new Font("Calibri",15)); 
            
            VBox course = new VBox(10);
            course.getChildren().add(course1);
            AnchorPane.setLeftAnchor(course, 345.0);
            AnchorPane.setTopAnchor(course, 5.0);

//         -------------------------Course Title Column-----------------------------
            Label courseTitle1 = new Label(rs1.getString("courseTitle"));
            courseTitle1.setFont(new Font("Calibri",15));
            
            Label courseTitle2 = new Label(rs2.getString("courseTitle"));
            courseTitle2.setFont(new Font("Calibri",15)); 
            
            VBox courseTitle = new VBox(10);
            courseTitle.getChildren().add(courseTitle1);
            AnchorPane.setLeftAnchor(courseTitle, 453.0);
            AnchorPane.setTopAnchor(courseTitle, 5.0);
            
//         -------------------------Course Unit Column-----------------------------
            
            String unit1 = String.format("%d",rs1.getInt("courseUnit"));
            String unit2 = String.format("%d",rs2.getInt("courseUnit"));
            
            Label courseUnit1 = new Label(unit1);
            courseUnit1.setFont(new Font("Calibri",15));
            
            Label courseUnit2 = new Label(unit2);
            courseUnit2.setFont(new Font("Calibri",15)); 
            
            VBox courseUnit = new VBox(10);
            courseUnit.getChildren().add(courseUnit1);
            AnchorPane.setLeftAnchor(courseUnit, 870.0);
            AnchorPane.setTopAnchor(courseUnit, 5.0);
            
            anchorPane.getChildren().addAll(Day, timeSlot, venue, course, courseTitle, courseUnit);
            
            content.getChildren().add(anchorPane);
                    
            
//            ---------------rotate time to print------------------------
                
            if(time <= 4)
            
                time++;
            
            else
                time=0;
                 
//           ------------------------------------------------
             }else{
                    
                        AnchorPane anchorPane = new AnchorPane();
                    String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                    "-fx-background-color: -fx-background;",256,256,256);
                    anchorPane.setStyle(style);
 
//          -------------------------Time Slot Column----------------------------    
            Label timeSlot = new Label(Time);
            AnchorPane.setLeftAnchor(timeSlot, 134.0);
            AnchorPane.setTopAnchor(timeSlot, 5.0);
            timeSlot.setFont(new Font("Calibri",15));
            
//          -----------------------Venue Column--------------------------------
            Label Venue1 = new Label("CSCLT");
            Venue1.setFont(new Font("Calibri",15));
            
            Label Venue2 = new Label("Venue 2");
            Venue2.setFont(new Font("Calibri",15)); 
            
            VBox venue = new VBox(10);
            venue.getChildren().add(Venue1);
            AnchorPane.setLeftAnchor(venue, 232.0);
            AnchorPane.setTopAnchor(venue, 5.0);
            
//          -----------------------Course Code Column--------------------------------
            Label course1 = new Label(rs1.getString("courseCode"));
            course1.setFont(new Font("Calibri",15));
            
            Label course2 = new Label(rs2.getString("courseCode"));
            course2.setFont(new Font("Calibri",15)); 
            
            VBox course = new VBox(10);
            course.getChildren().add(course1);
            AnchorPane.setLeftAnchor(course, 345.0);
            AnchorPane.setTopAnchor(course, 5.0);

//         -------------------------Course Title Column-----------------------------
            Label courseTitle1 = new Label(rs1.getString("courseTitle"));
            courseTitle1.setFont(new Font("Calibri",15));
            
            Label courseTitle2 = new Label(rs2.getString("courseTitle"));
            courseTitle2.setFont(new Font("Calibri",15)); 
            
            VBox courseTitle = new VBox(10);
            courseTitle.getChildren().add(courseTitle1);
            AnchorPane.setLeftAnchor(courseTitle, 453.0);
            AnchorPane.setTopAnchor(courseTitle, 5.0);
            
//         -------------------------Course Unit Column-----------------------------
            
            String unit1 = String.format("%d",rs1.getInt("courseUnit"));
            String unit2 = String.format("%d",rs2.getInt("courseUnit"));
            
            Label courseUnit1 = new Label(unit1);
            courseUnit1.setFont(new Font("Calibri",15));
            
            Label courseUnit2 = new Label(unit2);
            courseUnit2.setFont(new Font("Calibri",15)); 
            
            VBox courseUnit = new VBox(10);
            courseUnit.getChildren().add(courseUnit1);
            AnchorPane.setLeftAnchor(courseUnit, 870.0);
            AnchorPane.setTopAnchor(courseUnit, 5.0);
            
            anchorPane.getChildren().addAll(timeSlot, venue, course, courseTitle, courseUnit);
            
            content.getChildren().add(anchorPane);
                    
            
//            ---------------rotate time to print------------------------
                
            if(time <= 4)
            
                time++;
            
            else
                time=0;
            
                    }
                                    
                }
                
                count++;
            
            }
            
        }catch(SQLException t){}
    }
}