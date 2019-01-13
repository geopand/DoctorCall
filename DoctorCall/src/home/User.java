
package home;


public class User {
    private int userId;
    private String username;
    private String password;
    private int roleId;

    public User() {
    }

    public User(int userId, String username, String password, int roleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    


    @Override
    public String toString() {
        return "User Details \n" + "User ID:\t" + userId + "\n Username:\t" + username + "\n password:\t" + password + "\n roleId:\t" + roleId;
    }
  
    
    
 
    

    
    
}
