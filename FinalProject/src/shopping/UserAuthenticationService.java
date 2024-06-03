package shopping;

import java.util.HashMap;
import java.util.Map;

public class UserAuthenticationService {
    private Map<String, User> registeredUsers = new HashMap<>();

    public void registerUser(String username, String password) {
	try {
	    User user = new User(username, password);
	    registeredUsers.put(username, user);
	    System.out.println("Registration successful. ");
	} catch (IllegalArgumentException e) {
	    System.out.println(e.getMessage());
	}
    }

    public boolean loginUser(String username, String password) {
	User user = registeredUsers.get(username);
	if (user != null && user.getHashedPassword().equals(hashPassword(password))) {
	    System.out.println("Login successful.");
	    return true;
	}
	System.out.println("Login failure.");
	return false;
    }

    private String hashPassword(String password) {
	return "hashed_" + password;
    }
}
