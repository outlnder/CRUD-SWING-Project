package entities;

import java.util.List;

public class GeneralUser<T> {
	
private String login, password;
private static List<? extends GeneralUser> list;
	
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }    
    
    public GeneralUser(String login, String password) {
        this.login = login;
        this.password = password;        
    }

	public static List<? extends GeneralUser> getList() {
		return list;
	}
}
