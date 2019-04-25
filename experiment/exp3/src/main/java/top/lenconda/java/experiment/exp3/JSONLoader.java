package top.lenconda.java.experiment.exp3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.json.*;

public class JSONLoader {

    public String location = "";

    public JSONLoader (String location) {
        this.location = location;
    }

    public JSONObject loadJsonObject () throws IOException {
        Scanner scanner = new Scanner(new File(this.location));
        String content = scanner.nextLine();
        JSONObject jsonObject = new JSONObject(content);
        return jsonObject;
    }

    public JSONArray loadJsonArray () throws IOException {
        Scanner scanner = new Scanner(new File(this.location));
        String content = scanner.nextLine();
        JSONArray jsonArray = new JSONArray(content);
        return jsonArray;
    }

}
