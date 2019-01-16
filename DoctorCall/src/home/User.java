package home;


public class User {
    private long userId;
    private String username;
    private String password;
    private long roleId;

    public User() {
    }

    public User(long userId, String username, String password, long roleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    
    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    

    
    
    
    
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + ", password=" + password + ", roleId=" + roleId + '}';
    }
    

    
    
    
}