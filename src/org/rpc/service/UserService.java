package org.rpc.service;
/**
 * @author
 * Atiq Sayyed
 * 13/02/2016
 */

import org.rpc.model.User;
import org.rpc.reader.FileContentReader;
import org.rpc.writer.FileContentWriter;

import java.util.ArrayList;

public class UserService {

  FileContentReader reader = new FileContentReader();
  FileContentWriter writer = new FileContentWriter();
  String filePath = "resources/credentials.txt";

  private ArrayList<User> getUsers() {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> lines = reader.read(filePath);

    for(String line: lines){
        String[] tokens = line.split(" ");
        users.add(new User(tokens[0],tokens[1],tokens[2]));
    }
    return users;
  }

  public String register(String username, String password){
    if(isUserExist(username)){
      return "Username already exists. Try a different one";
    }else{
      String line = username+" "+password+" user";
      writer.write(line,filePath);
      return "Registration successful";
    }
  }

  public String login(String username, String password){
     User user = getUser(username);
     String message = "";

    if(user!=null){
      if(user.getUsername().equals(username) && user.getPassword().equals(password)){
        if(user.getRole().equals("admin")){
          Integer count = getUsers().size() ;
          message = "“Welcome admin! Number of registered users are <"+count.toString()+">";
        }else{
          message="Welcome <"+user.getUsername()+">!";
        }
      }
    }
    return message;
  }


  public boolean isUserExist(String userName){
    boolean exists = false;
    ArrayList<User> users = getUsers();
    for(User user:users){
      if(user.getUsername().equals(userName)){
        exists = true;
      }
    }
    return exists;
  }

  public User getUser(String username){
    User registeredUser = null;
    ArrayList<User> users = getUsers();
    for(User user :users){
      if(user.getUsername().equals(username)){
        registeredUser=user;
      }
    }
    return registeredUser;
  }

}
