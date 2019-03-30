package connection;

import com.google.gson.*;
import jdk.nashorn.internal.parser.JSONParser;
import logic.Person;
import logic.PersonSalary;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

public class JsonRead {
    ArrayList<PersonSalary> salaries = new ArrayList<>();

    public JsonRead() {
    }

    public boolean readFile() {
        salaries.clear();
        String url2 = "https://my-json-server.typicode.com/KaJuCave/distribuidos/db";
        String reply = "";
        try {
            reply = petition(url2);
            readJson(reply);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String petition(String urlFile) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlFile);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public void readJson(String json) {
        JsonParser parser = new JsonParser();
        JsonElement data = parser.parse(json);
        JsonObject jsonObject = data.getAsJsonObject();
        JsonArray array = jsonObject.getAsJsonArray("person");
        for (JsonElement obj : array) {
            JsonObject gsonObj = obj.getAsJsonObject();

            String document = gsonObj.get("document").getAsString();
            String salary = gsonObj.get("salary").getAsString();
            salaries.add(new PersonSalary(document, salary));
        }
    }

    public ArrayList<PersonSalary> getSalaries() {
        return salaries;
    }
}
