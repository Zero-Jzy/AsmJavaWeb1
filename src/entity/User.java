package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String username;
    private String password;
    private String fullName;
    private int role;
    private int status;

    private HashMap<String, ArrayList<String>> errors;

    public User() {
    }

    public User(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public User(String username, String password, String fullName, Integer role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public boolean isValid() {
        validate();
        return errors.size() == 0;
    }

    public void validate() {
        if (errors == null) {
            errors = new HashMap<>();
        }

        ArrayList<String> usernameErrors = this.errors.get("username");
        if (usernameErrors == null) {
            usernameErrors = new ArrayList<>();
        }
        if (this.username == null || this.username.length() == 0) {
            usernameErrors.add("User name is requeid!");
        }
        if (this.username.length() < 2 || this.username.length() > 30) {
            usernameErrors.add("UserName must be between 2 and 30 in length!");
        }
        if (usernameErrors.size() > 0) errors.put("username", usernameErrors);


        ArrayList<String> passwordErrors = this.errors.get("password");
        if (passwordErrors == null) {
            passwordErrors = new ArrayList<>();
        }
        if (this.password == null || this.password.length() == 0) {
            passwordErrors.add("Password is requeid!");
        }
        if (this.password.length() < 2 || this.password.length() > 30) {
            passwordErrors.add("Password must be between 2 and 30 in length!");
        }
        if (passwordErrors.size() > 0) errors.put("password", passwordErrors);


        ArrayList<String> fullnameErrors = this.errors.get("fullname");
        if (fullnameErrors == null) {
            fullnameErrors = new ArrayList<>();
        }
        if (this.fullName == null || this.fullName.length() == 0) {
            fullnameErrors.add("Full Name is requeid!");
        }
        if (this.fullName.length() < 2 || this.fullName.length() > 30) {
            fullnameErrors.add("Full Name must be between 2 and 30 in length!");
        }
        if (fullnameErrors.size() > 0) errors.put("fullname", fullnameErrors);


//        if (this.fullName == null || this.fullName.length() == 0) {
//            errors.put("fullName", "Full name is requeid!");
//        } else if (this.fullName.length() < 2 || this.fullName.length() > 30) {
//            errors.put("fullName", "fullName ........");
//        }
//
//        if (this.password == null || this.password.length() == 0) {
//            errors.put("password", "Password is requeid!");
//        } else if (this.password.length() < 2 || this.password.length() > 30) {
//            errors.put("password", "Password ........");
//        }
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return errors;
    }
}
