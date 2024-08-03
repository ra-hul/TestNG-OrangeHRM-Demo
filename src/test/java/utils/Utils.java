package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import setup.EmployeeModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.json.simple.JSONArray.toJSONString;

public class Utils {

    public static void saveUser(EmployeeModel model) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/users.json";

        JSONParser parser = new  JSONParser();

       JSONArray emArray= (JSONArray) parser.parse(new FileReader(fileLocation));

        JSONObject emObj = new JSONObject();
        emObj.put("firstName",model.getFirstName());
        emObj.put("lastName",model.getLastName());
        emObj.put("username",model.getUsername());
        emObj.put("password",model.getPassword());

        emArray.add(emObj);

        FileWriter writer = new FileWriter(fileLocation);
        writer.write(emArray.toJSONString());
        writer.flush();
        writer.close();
    }

    public static JSONArray readJSONData() throws IOException, ParseException {
        String fileLocation = "./src/test/resources/users.json";
        JSONParser parser = new  JSONParser();
        JSONArray emArray= (JSONArray) parser.parse(new FileReader(fileLocation));
        return emArray;
    }

    public static void main(String[] args) throws IOException, ParseException {


    }
}
