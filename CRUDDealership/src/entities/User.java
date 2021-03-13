package entities;

public class User extends Admin{	

	private String login, password;
	
    
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

	public User(String login, String password) {
		super(login, password);
		this.login = login;
        this.password = password;
	}

	
}
