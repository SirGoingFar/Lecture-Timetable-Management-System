import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class processDBConnect{
    
    private static Connection connection1;
    private static Connection connection2;
    
    public processDBConnect(){
    
        try{
            connection1 = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablems","root","root");
            connection2 = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/timetablemsprocess","root","root");
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
  
    public int add(String coursebaseName){
        
        int count=0;
        try{
        Statement st = connection2.createStatement();
        ResultSet result = st.executeQuery("SELECT * FROM timetablemsprocess."+(coursebaseName+"_"));
        
        Statement statement = connection2.createStatement();
        
        while(result.next()){ 
            
            String Query = String.format("INSERT INTO timetablemsprocess.processtb(courseCode, courseTitle, courseUnit, lectureDuration) VALUES('"+result.getString("courseCode")+"', '"+result.getString("courseTitle")+"', '"+result.getInt("courseUnit")+"', '"+result.getInt("lectureDuration")+"')");
            statement.executeUpdate(Query);
            count++;
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    
    public static void add(String cbName, int num){
        
        String coursebaseName = String.format("%svenue%d",cbName,num);
        String myTableName = String.format("CREATE TABLE %s (" + "ID INT(5) NOT NULL AUTO_INCREMENT," + "courseCode VARCHAR(6), " + "courseTitle VARCHAR(100), " + "courseUnit INT(2), " + "PRIMARY KEY(ID))",coursebaseName);
     
        try{ 
                Statement stat = connection2.createStatement(); 
                stat.executeUpdate(myTableName); 
                
                
                String Query = String.format("INSERT INTO timetablemsprocess.%s(courseCode, courseTitle, courseUnit) VALUES('"+"free"+"', '"+""+"', '"+0+"')",cbName+"venue"+num);
                for(int i=0; i<30; i++){
                    stat.executeUpdate(Query);
                }
                
        }
        catch (SQLException e ) {
            e.printStackTrace(); 
        }         
}
    
//         catch(NumberFormatExeption ){
//            
//       }
        
        //put into consideration the LECTURE DURATION so as to know the table into which the course will fall into
        //is it into the 1hour table or 2hours' table; USE THE IF STATEMENT
    
    //remove coursebase
    public void remove(String coursebaseName){
        String query = String.format("DROP TABLE %s",coursebaseName);
        
        try{
        Statement statement = connection1.createStatement();
        statement.execute(query);
        
//        String query = String.format("DROP TABLE %s",coursebaseName);
//        ResultSet result = statement.executeQuery(query);
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //remove from coursebase list
    public void remove(String coursebaseName, String ID){
   
        String query = String.format("DELETE FROM timetablems."+ coursebaseName +" WHERE courseCode='"+ ID +"'");
        
        try{
        Statement statement = connection1.createStatement();
        statement.executeUpdate(query);
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
 //remove designed timetable
    public void addTTName(String timetablename){
        String Query = String.format("INSERT INTO timetablemsprocess.timetablename(name) VALUES('"+timetablename+"')");
        
        try{
        Statement statement = connection2.createStatement();
        statement.executeUpdate(Query);
        
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }   
    
//remove designed timetable
    public void removeTimeTable(String ID){
        String query = String.format("DELETE FROM timetablemsprocess.timetablename WHERE name='"+ ID +"'");
        
        try{
        Statement statement = connection2.createStatement();
        statement.executeUpdate(query);
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public int getCount(){
    
        int rowCount=0;
        
        try{
            
        Statement st = connection2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("SELECT * FROM timetablemsprocess.processtb");
        
        rs = st.executeQuery("SELECT COUNT(*) FROM timetablemsprocess.processtb");
        
        rs.next();
       
       rowCount = rs.getInt(1);
       
        }catch(Exception v){}
    
        return rowCount;
    }
   
}