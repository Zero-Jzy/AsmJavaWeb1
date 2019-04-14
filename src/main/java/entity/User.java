package entity;

import model.UserModel;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {

    @Id
    private String username;

    @Column
    private String password;

    @CreationTimestamp
    private Date createdAt;

    @OneToOne
    @JoinColumn(name="infor_user_id")
    private UserInfomation userInfomation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<FeedBack> feedBacks = new HashSet<FeedBack>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "role_user",
            joinColumns = { @JoinColumn(name = "username") },
            inverseJoinColumns = {@JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<Role>();

    private HashMap<String, ArrayList<String>> errors  = null;

    public User() {
    }

    public User(String username, String password, UserInfomation userInfomation) {
        this.username = username;
        this.password = password;
        this.userInfomation = userInfomation;
    }

    public UserInfomation getUserInfomation() {
        return userInfomation;
    }

    public void setUserInfomation(UserInfomation userInfomation) {
        this.userInfomation = userInfomation;
    }

    public Set<FeedBack> getFeedBacks() {
        return feedBacks;
    }

    public void setFeedBacks(Set<FeedBack> feedBacks) {
        this.feedBacks = feedBacks;
    }

    public Set getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
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

    public boolean isUser(){
        Set<Role> userRoles = this.roles;
        boolean resulte = false;
        for(Role role: userRoles){
            if (role.getId().equals(1)) resulte = true;
        }
        return resulte;
    }

    public boolean isAdmin(){
        Set<Role> userRoles = this.roles;
        boolean resulte = false;
        for(Role role: userRoles){
            if (role.getId().equals(2)) resulte = true;
        }
        return resulte;
    }

    public boolean isValid() {
        validate();
        return errors.size() == 0;
    }

    public void validate() {
        UserModel model = new UserModel();
        ArrayList<User> userArrayList = model.getALl();
        if (errors == null) {
            errors = new HashMap<String, ArrayList<String>>();
        }

        ArrayList<String> usernameErrors = this.errors.get("username");
        if (usernameErrors == null) {
            usernameErrors = new ArrayList<String>();
        }
        if (this.username == null || this.username.length() == 0) {
            usernameErrors.add("User name is requeid!");
        }
        for (User user :userArrayList){
            if (user.getUsername().equals(this.username)){
                usernameErrors.add("Username has been used!");
            }
        }
        if (this.username.length() < 2 || this.username.length() > 30) {
            usernameErrors.add("UserName must be between 2 and 30 in length!");
        }
        if (usernameErrors.size() > 0) errors.put("username", usernameErrors);


        ArrayList<String> passwordErrors = this.errors.get("password");
        if (passwordErrors == null) {
            passwordErrors = new ArrayList<String>();
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
            fullnameErrors = new ArrayList<String>();
        }
        if (this.userInfomation.getFullName() == null || this.userInfomation.getFullName().length() == 0) {
            fullnameErrors.add("Full Name is requeid!");
        }
        if (this.userInfomation.getFullName().length() < 2 || this.userInfomation.getFullName().length() > 30) {
            fullnameErrors.add("Full Name must be between 2 and 30 in length!");
        }

        if (fullnameErrors.size() > 0) errors.put("fullname", fullnameErrors);


        ArrayList<String> emailErrors = this.errors.get("email");
        if (emailErrors == null) {
            emailErrors = new ArrayList<String>();
        }
        for (User user :userArrayList){
            if (user.getUserInfomation().getEmail().equals(this.userInfomation.getEmail())){
                emailErrors.add("Email has been used!");
            }
        }
        if (this.userInfomation.getEmail() == null || this.userInfomation.getEmail().length() == 0) {
            emailErrors.add("Email is requeid!");
        }
        if (this.userInfomation.getEmail().length() < 2 || this.userInfomation.getEmail().length() > 30) {
            emailErrors.add("Email must be between 2 and 30 in length!");
        }
        if (emailErrors.size() > 0) errors.put("email", emailErrors);



        ArrayList<String> phoneErrors = this.errors.get("phone");
        if (phoneErrors == null) {
            phoneErrors = new ArrayList<String>();
        }
        if (this.userInfomation.getEmail() == null || this.userInfomation.getEmail().length() == 0) {
            phoneErrors.add("Phone is requeid!");
        }

        if (phoneErrors.size() > 0) errors.put("phone", phoneErrors);
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return errors;
    }
}
