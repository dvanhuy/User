
package UserService;

import ConnectJAVA.UsersUpdate;
import User.User;
import java.util.List;

public class UserService {
    private UsersUpdate usersUpdate;

    public UserService() {
        usersUpdate = new UsersUpdate();
    }
    
    public List<User> getAllUser(){
        return usersUpdate.getAllUsers();
    }
    
    public void addUser(User user)
    {
        usersUpdate.addUser(user);
    }
    public void deteleUser(int userid)
    {
        usersUpdate.deleteUser(userid);
    }

}
