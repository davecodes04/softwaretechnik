package user;

public abstract class User {

    protected int id;
    protected String username;
    protected String password;
    protected String email;
    protected String userRole;

    public void login(){ UserSession.setCurrentUser(this); }

    public void logout(){ UserSession.clear(); }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setUserRole(String role){
        userRole = role;
    }

}
