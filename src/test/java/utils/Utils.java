package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.json.simple.JSONArray.toJSONString;

public class Utils {

    public static void saveUser(String firstName, String lastname,String username, String password) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/users.json";

        JSONParser parser = new  JSONParser();

       JSONArray emArray= (JSONArray) parser.parse(new FileReader(fileLocation));

        JSONObject emObj = new JSONObject();
        emObj.put("firstName",firstName);
        emObj.put("lastName",lastname);
        emObj.put("username", username);
        emObj.put("password",password);

        emArray.add(emObj);

        FileWriter writer = new FileWriter(fileLocation);
        writer.write(emArray.toJSONString());
        writer.flush();
        writer.close();

    }
}
