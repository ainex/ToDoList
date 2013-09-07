import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 07.09.13
 * Time: 19:49
 * To change this template use File | Settings | File Templates.
 */
public interface ItemDAO {


    public void addToDoItem(Date expirationDate, String taskDescription);
    public void removeToDoItem();
    public void editToDoItem();
    public List<ToDoItem> getItems(String folderName);

}
