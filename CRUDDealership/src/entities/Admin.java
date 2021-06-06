package entities;

import java.util.ArrayList;
import java.util.List;

public class Admin extends GeneralUser{
	
	private String login, password;
	
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }    
    
    public Admin(String login, String password) {
    	super(login, password);
        this.login = login;
        this.password = password;        
    }
    
    
	private static List<Admin> adminList = new ArrayList<Admin>() {
		{
		add(new Admin("admin1", "admin1"));
		add(new Admin("admin2", "admin2"));
		}
	};

	public static List<Admin> getList() {
		return adminList;
	}
	
}
