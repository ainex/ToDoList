import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 07.09.13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class ToDoSamplesInit {
    private Connection dbConnection;
    private Statement statement;
    PreparedStatement preparedStatement;
    ResultSet requestResults;

    public ToDoSamplesInit(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void createTables(){
        //Work  Education Miscellaneous

        try {
            statement = dbConnection.createStatement();
            statement.execute("CREATE TABLE WORK" +
                    "(ID INT PRIMARY KEY AUTO_INCREMENT, entryDate DATETIME, expDate DATETIME, description VARCHAR(128))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertToDoItems() {
        String sqlItemAdd;
        sqlItemAdd = "INSERT INTO WORK (entryDate, expDate, description) VALUES (?,?,?)";
        java.util.Date date = new java.util.Date();
        java.util.Date date2 = new java.util.Date();
        Timestamp dateSQL = new Timestamp(date.getTime());
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlItemAdd);
            preparedStatement.setTimestamp(1, dateSQL);
            preparedStatement.setTimestamp(2, dateSQL);
            preparedStatement.setString(3, "Do the Math!");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
