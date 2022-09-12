import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    /**
     * @Author : Shyam Mahadevan
     * The getTheListOfValues() method accepts the string of JSON, key of the child entity which is a array with the data required from
     * array of JSON
     * The method returns the complete child entity values of the key passed
     * And assert the child entity key is present in the JSON
     */
    public List<String> getTheListOfValues(Object json, String key, String childEntityKey) {
        List<String> list = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json.toString());
            boolean flag = jsonObject.has(key);
            Assert.assertTrue(flag);
            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray(key));

            for (int i = 0; i <= jsonArray.length() - 1; i++) {
                String values = jsonArray.getJSONObject(i).getString(childEntityKey);
                list.add(values);
            }

        } catch (Exception e) {
            System.out.println("Failed to find the key");
        }
        return list;

    }


    /**
     * @Author : Shyam Mahadevan
     * The method getJsonFile returns the json file as object by parsing with the json parser
     */
    public Object getJsonFile(String fileName) throws IOException {
        JSONParser jsonParser = new JSONParser();
        Object obj = null;
        try (FileReader reader = new FileReader(fileName)) {
            obj = jsonParser.parse(reader);
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
        return obj;

    }
}
