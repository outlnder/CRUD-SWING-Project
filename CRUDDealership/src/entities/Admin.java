package entities;

public class Admin {
	
	private String login, password;
	
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }    
    
    public Admin(String login, String password) {
        this.login = login;
        this.password = password;        
    }	
}
