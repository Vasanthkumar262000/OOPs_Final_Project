package shopping;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String username;
    private String hashedPassword;
    private Set<String> roles;

    public User(String username, String password) {
	setUsername(username);
	setHashedPassword(password); // password upon user creation
	roles = new HashSet<>();
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{8,}$");
	Matcher matcher = pattern.matcher(username);
	if (!matcher.matches()) {
	    throw new IllegalArgumentException("Invalid username .");
	}
	this.username = username;
    }

    public String getHashedPassword() {
	return hashedPassword;
    }

    public void setHashedPassword(String password) {
	Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
	Matcher matcher = pattern.matcher(password);
	if (!matcher.matches()) {
	    throw new IllegalArgumentException("Invalid password .");
	}
	this.hashedPassword = hashPassword(password); // password hashing
    }

    private String hashPassword(String password) {
	// Placeholder for password hashing logic
	return "hashed_" + password; // It is replaced with actual hashing logic
    }

    public void addRole(String role) {
	roles.add(role);
    }

    public Set<String> getRoles() {
	return new HashSet<>(roles); // Returns a copy to preserve encapsulation technique
    }
}
