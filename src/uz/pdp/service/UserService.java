package uz.pdp.service;

import uz.pdp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements BaseService{
    static List<User> users = new ArrayList<>();

    public boolean add(User user) {
        for (User user1 : users) {
            if(user1 != null){
                if(user1.getPhoneNumber().equals(user.getPhoneNumber()))
                    System.out.println(" User Added Unseccessful ");
                return false;
            }
        }
        System.out.println(" User Added successful ");
        users.add(user);
        return true;
    }

    @Override
    public boolean delete(int id) {
        for (User user : users) {
            if (user != null){
                if(user.getId() == id){
                    users.remove(user);
                    System.out.println(" User Deleted successful ");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object getById(int id){
        for (User user : users) {
            if(user != null){
                if(user.getId() == id){
                    return user;
                }
            }
        }
        return null;
    }

    public void showUsers(){
        for (User user : users) {
            if(user != null)
                System.out.println(user);
        }
    }

    public User login(String phoneNumber,String password){
        for(User user : users) {
            if (user != null) {
                if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                    System.out.println(" User enter successfully ");
                    return user;
                }
            }
        }
        System.out.println(" Unseccessfully enter ");
        return null;
    }

}
