import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 06.09.13
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class ItemDAOImpl implements ItemDAO {

    Connection dbConnection;

    public ItemDAOImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void addToDoItem(Date expirationDate, String taskDescription) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeToDoItem() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void editToDoItem() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<ToDoItem> getItems(String folderName) {
        List<ToDoItem> itemList = new ArrayList<ToDoItem>();
        try {
            Statement st = dbConnection.createStatement();
            ResultSet requestResults = st.executeQuery("SELECT * FROM "+folderName);

            while (requestResults.next()){
                int id = requestResults.getInt("ID");
                Date date = requestResults.getTimestamp("entryDate");
                Date expDate = requestResults.getTimestamp("expDate");
                String description = requestResults.getString("description");
                ToDoItem toDoItem = new ToDoItem(id, date, expDate, description);
                itemList.add(toDoItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }
}
