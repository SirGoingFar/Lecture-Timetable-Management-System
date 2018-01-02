import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbConnect{
    
    private Connection connection;
    private Connection connection1;
    
    public dbConnect(){
    
        try{
            connection = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablems","root","root");
            connection1 = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablemsprocess","root","root");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //add to coursebase
    public static void add(String coursebaseName){
    
        String myTableName = String.format("CREATE TABLE %s (" + "id INT(5) NOT NULL AUTO_INCREMENT," + "courseCode VARCHAR(6), " + "courseTitle VARCHAR(100), " + "courseUnit INT(2), " + "lectureDuration INT(2), " + "coursePopulation INT(3), " + "courseDescription VARCHAR(150), " + "PRIMARY KEY(id))",coursebaseName);
        String myTableName_ = String.format("CREATE TABLE %s (" + "id INT(5) NOT NULL AUTO_INCREMENT," + "courseCode VARCHAR(6), " + "courseTitle VARCHAR(100), " + "courseUnit INT(2), " + "lectureDuration INT(2), " + "coursePopulation INT(3), " + "courseDescription VARCHAR(150), " + "PRIMARY KEY(id))",(coursebaseName+"_"));
        try{ 
                Connection con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablems","root","root");
                Connection connection1 = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablemsprocess","root","root");
                
                Statement stat = con.createStatement(); 
                Statement stats = connection1.createStatement(); 
                
                stat.executeUpdate(myTableName); 
                stats.executeUpdate(myTableName_); 
                
        
        }
//        catch (createSQLException e) {
//            currentStatus.display("Notification", "Name already exist");
//            addCourseBase.window.close();
//            addCourseBase.getScene();
//            e.printStackTrace(); 
//        }
        catch (SQLException e ) {
            e.printStackTrace(); 
        }      
        
}
    
    //add to coursebase list
    public void add(String coursebaseName, String courseCode, String courseTitle, int courseUnit, int lectureDuration, int coursePopulation, String courseDescription){
        
        int val1 = 1;
        int val2 = 2;
        
        String Query = String.format("INSERT INTO timetablems.%s(courseCode, courseTitle, courseUnit, lectureDuration, coursePopulation, courseDescription) VALUES('"+courseCode+"', '"+courseTitle+"', '"+courseUnit+"', '"+lectureDuration+"', '"+coursePopulation+"', '"+courseDescription+"')",coursebaseName);
        String Query1 = String.format("INSERT INTO timetablemsprocess.%s(courseCode, courseTitle, courseUnit, lectureDuration, coursePopulation, courseDescription) VALUES('"+courseCode+"', '"+courseTitle+"', '"+courseUnit+"', '"+val1+"', '"+coursePopulation+"', '"+courseDescription+"')",(coursebaseName+"_"));
        String Query2 = String.format("INSERT INTO timetablemsprocess.%s(courseCode, courseTitle, courseUnit, lectureDuration, coursePopulation, courseDescription) VALUES('"+courseCode+"', '"+courseTitle+"', '"+courseUnit+"', '"+val2+"', '"+coursePopulation+"', '"+courseDescription+"')",(coursebaseName+"_"));
        String Query3 = String.format("INSERT INTO timetablemsprocess.%s(courseCode, courseTitle, courseUnit, lectureDuration, coursePopulation, courseDescription) VALUES('"+courseCode+"', '"+courseTitle+"', '"+courseUnit+"', '"+lectureDuration+"', '"+coursePopulation+"', '"+courseDescription+"')",(coursebaseName+"_"));
        
        try{
        Statement statement = connection.createStatement();
        statement.executeUpdate(Query);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        if(lectureDuration==3){
        try{
        Statement statement = connection.createStatement();
        statement.executeUpdate(Query1);
        statement.executeUpdate(Query2);
        }catch(SQLException e){
            e.printStackTrace();
        }
            
        }
        
        else{
        try{
        Statement statement = connection.createStatement();
        statement.executeUpdate(Query3);
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        }
//         catch(NumberFormatExeption ){
//            
//       }
        
        //put into consideration the LECTURE DURATION so as to know the table into which the course will fall into
        //is it into the 1hour table or 2hours' table; USE THE IF STATEMENT
    }
    
    //remove coursebase
    public void remove(String coursebaseName){
        String query = String.format("DROP TABLE %s",coursebaseName);
        String query2 = String.format("DROP TABLE %s",(coursebaseName+"_"));
        
        try{
        Statement statement = connection.createStatement();
        statement.execute(query);
        
        Statement statement2 = connection1.createStatement();
        statement2.execute(query2);
        
//        String query = String.format("DROP TABLE %s",coursebaseName);
//        ResultSet result = statement.executeQuery(query);
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //remove from coursebase list
    public void remove(String coursebaseName, String ID){
   
        String query = String.format("DELETE FROM timetablems."+ coursebaseName +" WHERE courseCode='"+ ID +"'");
        String query1 = String.format("DELETE FROM timetablemsprocess."+ (coursebaseName+"_") +" WHERE courseCode='"+ ID +"'");
        
        try{
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        
        Statement stat = connection1.createStatement();
        stat.executeUpdate(query1);
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
}