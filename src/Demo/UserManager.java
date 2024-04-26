package Demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final List<User> users;
    private static final String PATH_FILE = "src/Demo/userFile.txt";
    public UserManager(){
        this.users = new ArrayList<User>();
    }
    public void add(User user){
        this.users.add(user);
        this.writeDataToFile();
    }
    public void showListUsers(){
        this.readDataToFile();
        for (User user : users){
            System.out.println(user);
        }
    }

    public void delete(String username){
        this.readDataToFile();
        User userToRemote = null;
        for (User user : users){
            if (user.getUsername().equals(username)){
                userToRemote = user;
                break;
            }
        }
        if (userToRemote != null){
            users.remove(userToRemote);
            this.writeDataToFile();
            System.out.println("User " + username + " has been deleted.");
        } else {
            System.out.println("User " + username + " not found.");
        }
    }

    public void update(String username, User updatedUser){
        this.readDataToFile();
        boolean found = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)){
                users.set(i, updatedUser);
                found = true;
                break;
            }
        }
        if (found){
            this.writeDataToFile();
            System.out.println("User " + username + " has been updated.");
        }else {
            System.out.println("User " + username + " not found.");
        }
    }
    public void readDataToFile(){
        this.users.clear();
        try {
            FileReader fileReader = new FileReader(PATH_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] txt = line.split(",");
                User user = new User(txt[0],txt[1],txt[2]);
                this.users.add(user);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void writeDataToFile(){

        try {
            FileWriter fileWriter = new FileWriter(PATH_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User user : users){
                String line = user.getUsername() + "," + user.getPassword() + "," + user.getEmail();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
