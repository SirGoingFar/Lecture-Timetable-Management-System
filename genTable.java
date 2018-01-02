import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class genTable{

    static Stage window;
    static Stage windowAnother;
    private static Label label;
    private static Button generateButton;
    private static Button cancelButton;
    static Scene scene;
    
    Connection connection1;
    Connection connection2;
    
    Statement statement2;
    Statement statement3;
    Statement statement4;
    Statement statement5;
    Statement statement6;
    Statement statement7;
    
    
    ChoiceBox<String> courseBase;
    Integer [] hr2 = {1,2,3,4,7,8,9,10,13,14,15,16,19,20,21,22,25,26,29}; 
    Integer [] hr1 = {5,6,11,12,17,18,23,24,27,30};
    Random rng = new Random();
    LinkedList<Integer> hr_2 = new LinkedList<Integer>(Arrays.asList(hr2));
    LinkedList<Integer> hr_1 = new LinkedList<Integer>(Arrays.asList(hr1));
    
    
    int id;
    String courseCode;
    String courseTitle;
    int courseUnit;
    int lectureDuration;
    int count;
    
    
    // Class Constructor
    public genTable(){
    
        try{
            connection1 = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablems","root","root");
            connection2 = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablemsprocess","root","root");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void display(){
    
        window = new Stage();
        window.setTitle("Generate Timetable");
        window.centerOnScreen();
        window.resizableProperty().setValue(Boolean.FALSE);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(getScene());
        window.setAlwaysOnTop(true);
        window.show();
        
    }
    
    public Scene getScene(){
        
        Label label2 = new Label("New Timetable Name");
        
        TextField timetableName = new TextField();
        timetableName.setPromptText("Timetable Name");
        
        HBox hbox4 = new HBox(20);
        hbox4.setAlignment(Pos.CENTER);
        hbox4.getChildren().addAll(label2,timetableName);
        
        label = new Label();
        label.setText("Select Coursebase");
       
        
        courseBase = new ChoiceBox<>();
        String notif = "Select a coursebase";
        courseBase.getItems().add(notif);
        courseBase.setValue(notif);
        getDBTable();
        
        
        //here is to be worked on...........the ChoiceBox must be the name of the coursebases in the DB
        
        HBox hbox2 = new HBox(20);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(label,courseBase);
        
        
        
        //Buttons
        generateButton = new Button("Generate");
        generateButton.setOnAction(e -> {
            
            processDBConnect con = new processDBConnect();
            con.addTTName(timetableName.getText());
            
            process(courseBase.getValue(),timetableName.getText());
        });
        
        cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> window.close());
        
        
        HBox hbox3 = new HBox(30);
        hbox3.setAlignment(Pos.CENTER);
        hbox3.getChildren().addAll(generateButton,cancelButton);
        
        
        VBox layout = new VBox(25);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(hbox4, hbox2, hbox3);
        
        return new Scene(layout, 300, 150);
    }
    
    
    public void getDBTable(){
        
        try{
             DatabaseMetaData m = connection1.getMetaData();
             ResultSet tables = m.getTables(null, null, "%", null);
             
             while(tables.next()){
            courseBase.getItems().add(tables.getString(3));
             }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
   
    
    private void process(String courseBaseName, String timetableName){
        
        processDBConnect p = new processDBConnect();
        count = p.add(courseBaseName);
        p.add(timetableName,1);
        p.add(timetableName,2);
        
        
        try{
            
            statement2 = connection2.createStatement();
            statement3 = connection2.createStatement();
            statement5 = connection2.createStatement();
            statement6 = connection2.createStatement();
            statement7 = connection2.createStatement();
            
            ResultSet rs2 = statement2.executeQuery("SELECT * FROM timetablemsprocess.processtb");
            
          
            while(count!=0){
                
                
                if(rs2.next()){
            
                    id = rs2.getInt("id");
                    courseCode = rs2.getString("courseCode");
                    courseTitle = rs2.getString("courseTitle");
                    courseUnit = rs2.getInt("courseUnit");
                    lectureDuration = rs2.getInt("lectureDuration");
                    
                    if(lectureDuration == 1){
                    
                        process1(timetableName);
       
                        
    //              ---------------------Empty ProcessTB---------------------------------
                                String query3 = String.format("DELETE FROM timetablemsprocess.processtb WHERE id='"+ id +"'");
                                statement7.executeUpdate(query3);
                                
                            
                    }
                    
                    else if(lectureDuration == 2){
                    
                        process2(timetableName);
                        
//              ---------------------Empty ProcessTB---------------------------------                                
                         String query3 = String.format("DELETE FROM timetablemsprocess.processtb WHERE id='"+ id +"'");
                         statement7.executeUpdate(query3);
                                
                                
                
                    }
                    else if(lectureDuration == 3){
                    
                        process1(timetableName);
                        process2(timetableName);
                        
//              ---------------------Empty ProcessTB---------------------------------
                    String query3 = String.format("DELETE FROM timetablemsprocess.processtb WHERE id='"+ id +"'");
                    statement7.executeUpdate(query3);
                        
                    }
            
                    count--;
           }
        
            }
        }catch(Exception v){
            v.printStackTrace();
        }
        
            currentStatus.display("Success", "Timetable Generated Successfully!");
            window.close();
        }
    
    
    public void process1(String courseBaseName){
    
                        int arrayID = rng.nextInt(hr_1.size());
                        int timeID = hr_1.get(arrayID);

                        
                        int venueID = (rng.nextInt(2)+1);
                        String venue = String.format("%s%s%d",courseBaseName,"venue",venueID);
                              
                try{        
                        String query = String.format("SELECT * FROM timetablemsprocess.%s WHERE id=%d",venue,timeID);
                        ResultSet rs3 = statement3.executeQuery(query);
                          
                        
                            if(rs3.next()){
                              
                            if("free".equals(rs3.getString("courseCode"))){ 
            
                                String query2 = String.format("UPDATE timetablemsprocess.%s SET courseCode='"+courseCode+"', courseTitle='"+courseTitle+"', courseUnit='"+courseUnit+"' WHERE id=%d",venue,timeID);
                                try{
                                statement4 = connection2.createStatement();
                                statement4.executeUpdate(query2);
                                System.out.println(courseCode);
                                }catch(Exception h){}
                               
                               
//                                -------------------remove timeslot from timeslot available from processTB-----------------------                                
                                hr_1.remove(timeID);
                               
                            }
                            }
                            
                           
    }catch(Exception e){}
    }
    
    public void process2(String courseBaseName){         
                    
                        int arrayID = rng.nextInt(hr_2.size());
                        int timeID = hr_2.get(arrayID);

                        
                        int venueID = (rng.nextInt(2)+1);
                        String venue = String.format("%s%s%d",courseBaseName,"venue",venueID);
                              
                try{        
                        String query = String.format("SELECT * FROM timetablemsprocess.%s WHERE id=%d",venue,timeID);
                        ResultSet rs3 = statement3.executeQuery(query);
                          
                        
                            if(rs3.next()){
                              
                            if("free".equals(rs3.getString("courseCode")) && timeID != 28){ 
            
                                String query2 = String.format("UPDATE timetablemsprocess.%s SET courseCode='"+courseCode+"', courseTitle='"+courseTitle+"', courseUnit='"+courseUnit+"' WHERE id=%d",venue,timeID);
                                try{
                                statement4 = connection2.createStatement();
                                statement4.executeUpdate(query2);
                                System.out.println(courseCode);
                                }catch(Exception f){}
                               
                                
//                                -------------------remove timeslot from timeslot available from processTB-----------------------                                
                                hr_2.remove(timeID);
                                
                                
                            }
                            }
                            

    }catch(Exception e){}
    }

}
            

    
