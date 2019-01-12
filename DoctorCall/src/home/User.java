
package home;


public class User {
    private int userid;
    private String username;
    private String password;
    private int roleId;

    public User() {
    }

    public User(int userid, String username, String password, int roleId) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
        return "User Details \n" + "User ID:\t" + userid + "\n Username:\t" + username + "\n password:\t" + password + "\n roleId:\t" + roleId;
    }
  
    
    
 
    

    
    
}
