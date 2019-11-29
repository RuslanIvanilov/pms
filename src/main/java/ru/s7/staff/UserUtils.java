package ru.s7.staff;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    List<User> userList = new ArrayList<User>();

    public List<User> getUserList(){
        return userList;
    }

    public void loadFromJson(){
        String fileName = "user.json";
        String path = this.getClass().getClassLoader().getResource(fileName).getPath();
        System.out.println("PATH: " + path);

        JSONParser parser = new JSONParser();

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : a)
            {
                JSONObject json = (JSONObject) o;
                User user = new User();

                user.userId = Long.valueOf ( ((String)json.get("user_id"))==null?"0":(String)json.get("user_id") );
                user.userName = (String) json.get("user_name");
                user.firstName = ((String) json.get("user_first_name"))==null?"":(String) json.get("user_first_name");
                user.surName = ((String) json.get("user_surname"))==null?"":(String) json.get("user_surname");
                user.patronymic = ((String) json.get("user_patronymic"))==null?"":(String) json.get("user_patronymic");
                user.position = ((String) json.get("position"))==null?"":(String) json.get("position");
                user.blocked = Boolean.valueOf( ((String) json.get("blocked"))==null?"false":(String) json.get("blocked") );
                user.passHash = Long.valueOf ( ((String)json.get("pass_hash"))==null?"-1":(String)json.get("pass_hash") );
                user.admin = Boolean.valueOf( ((String) json.get("admin"))==null?"false":(String) json.get("admin") );
                userList.add(user);
            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
