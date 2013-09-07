import java.sql.Connection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 07.09.13
 * Time: 11:28
 * To change this template use File | Settings | File Templates.
 */
public class Controller {

    public static void main (String[] args){

        Connection dbConnection = H2DatabaseUtil.getDbConnection();
        ToDoSamplesInit samplesInit = new ToDoSamplesInit(dbConnection);
        samplesInit.createTables();
        samplesInit.insertToDoItems();
        ItemDAOImpl dao = new ItemDAOImpl(dbConnection);
        List<ToDoItem> itemList = dao.getItems("WORK");
        for (ToDoItem item : itemList) {
            System.out.println(item.itemToString());
        }


    }
}
