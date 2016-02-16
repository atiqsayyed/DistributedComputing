package org.rpc;

import org.apache.xmlrpc.*;
import org.rpc.service.UserService;

public class RPCServer {

  private UserService userService= new UserService();

  public String login(String username, String password){
    return userService.login(username,password);
  }

  public String register(String username, String password){
    return userService.register(username, password);
  }

  public static void main(String[] args){
    try {

      WebServer server = new WebServer(8080);
      server.addHandler("rpc", new RPCServer());
      server.start();

      System.out.println("Started successfully.");
      System.out.println("Accepting requests. (Halt program to stop.)");
    } catch (Exception exception){
      System.err.println("JavaServer: " + exception);
    }
  }

}
