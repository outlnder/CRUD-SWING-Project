package entities;

import java.util.ArrayList;
import java.util.List;

public class User extends GeneralUser{	

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
	

	private static List<User> userList = new ArrayList<User>(){
		{
		add(new User("user1", "user1"));
		add(new User("user2", "user2"));
		add(new User("user3", "user3"));
		add(new User("user4", "user4"));
		add(new User("user5", "user5"));
		}
	};

	
	
	public static List<User> getList() {
		return userList;
	}	
}
