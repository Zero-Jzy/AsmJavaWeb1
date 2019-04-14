package model;

import entity.Role;
import entity.User;
import entity.UserInfomation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;



public class UserModel {

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;


    private static SessionFactory buildSessionFactory() {
        sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        return sessionFactoryObj;
    }


    public void insert(User user, UserInfomation userInfomation) {
        setIsUser(user);

        sessionObj = buildSessionFactory().openSession();

        sessionObj.beginTransaction();

        sessionObj.save(user);
        sessionObj.save(userInfomation);

        sessionObj.getTransaction().commit();
        sessionObj.close();

    }

    public User getUserByUserNameAndPassword(String username, String password) {
        User user = finOne(username);
        if (user == null) {
            return null;
        }

        if (password.equals(user.getPassword())) {
            return user;
        }else {
            return null;
        }
    }


    public User finOne(String username) {
        sessionObj = buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        Query query = sessionObj.createQuery("FROM  User where username = :username");
        query.setParameter("username", username);
        List list = query.list();

        User user = (User) list.get(0);
        sessionObj.close();

        return user;
    }

    private void setIsUser(User user) {
        sessionObj = buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        Query query = sessionObj.createQuery("FROM  Role where role_id = 1");
        List list = query.list();
        Role role = (Role) list.get(0);

        user.getRoles().add(role);

        sessionObj.close();
    }

    public ArrayList<User> getALl(){
        sessionObj = buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        Query query = sessionObj.createQuery("FROM  User");
        ArrayList<User> list = (ArrayList<User>) query.list();
        sessionObj.close();

        return list;

    }


}
