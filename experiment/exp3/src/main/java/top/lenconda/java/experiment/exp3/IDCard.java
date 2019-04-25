package top.lenconda.java.experiment.exp3;
import jdk.nashorn.internal.objects.NativeJSON;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class IDCard {

    private StringBuffer idBuffer;
    private char[] characterCheckValues = {'1', '0', 'x', '9', '8', '7', '6', '5', '4', '3', '2'};
    private int[] wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    public IDCard (String inputIdNumber) {
        this.idBuffer = new StringBuffer(inputIdNumber.toLowerCase());
    }

    public boolean validateLength () {
        if (this.idBuffer.length() != 15 && this.idBuffer.length() != 18)
            return false;
        return true;
    }

    public boolean validateCheckCode () {
        int[] idCardNumbers = new int[17];
        if (this.idBuffer.length() == 18) {
            int summary = 0;
            for (int i = 0; i < 17; i++) {
                idCardNumbers[i] = this.idBuffer.charAt(i) - '0';
                summary += idCardNumbers[i] * this.wi[i];
            }
            int modResult = summary % 11;
            char checkValue = this.idBuffer.charAt(17);
            return checkValue == this.characterCheckValues[modResult];
        }
        return true;
    }

    public boolean validateBirthDay () {
        String birthDay = "";
        if (this.idBuffer.length() == 15)
            birthDay = "19" + this.idBuffer.substring(6, 12);
        if (this.idBuffer.length() == 18)
            birthDay = this.idBuffer.substring(6, 14);
        Birthday birthday = new Birthday(birthDay);
        return birthday.validate();
    }

    public String getIDCardVersion () {
        if (this.idBuffer.length() == 15)
            return "old";
        else if (this.idBuffer.length() == 18)
            return "new";
        else
            return "error";
    }

    public String getGender () {
        int gender = -1;
        if (this.getIDCardVersion() == "old")
            gender = Integer.parseInt(
                    this.idBuffer.substring(this.idBuffer.length() - 1, this.idBuffer.length()));
        else if (this.getIDCardVersion() == "new")
            gender = Integer.parseInt(
                    this.idBuffer.substring(this.idBuffer.length() - 2, this.idBuffer.length() - 1));
        else
            return "unknown";
        if (gender % 2 == 0)
            return "female";
        else
            return "male";
    }

    public String convertToNewVersion () {
        if (this.getIDCardVersion() == "old") {
            int[] kk = new int[17];
            StringBuffer newIdBuffer = this.idBuffer.insert(6, "19");
            int summary = 0;
            for (int i = 0; i < 17; i++) {
                kk[i] = Integer.parseInt(this.idBuffer.substring(i, i + 1));
                summary += kk[i] * wi[i];
            }
            char characterCheckCode = this.characterCheckValues[summary % 11];
            return newIdBuffer.append(characterCheckCode).toString();
        }
        return this.idBuffer.toString();
    }

    public String getBirthday () {
        String birthDay = "";
        if (this.idBuffer.length() == 15)
            birthDay = "19" + this.idBuffer.substring(6, 12);
        if (this.idBuffer.length() == 18)
            birthDay = this.idBuffer.substring(6, 14);
        Birthday birthday = new Birthday(birthDay);
        return birthday.getString();
    }

    public String getProvinceName () throws IOException {
        String province = this.idBuffer.substring(0, 2);
        JSONLoader provincesJsonLoader = new JSONLoader("src/main/java/top/lenconda/java/experiment/exp3/provinces.json");
        JSONArray provinces = provincesJsonLoader.loadJsonArray();
        for (int i = 0; i < provinces.length(); i++) {
            JSONObject provinceObject = provinces.getJSONObject(i);
            if (provinceObject.get("code").equals(province))
                return provinceObject.get("name").toString();
        }
        return "";
    }

    public String getCityName () throws IOException {
        String city = this.idBuffer.substring(0, 4);
        JSONLoader citiesJsonLoader = new JSONLoader("src/main/java/top/lenconda/java/experiment/exp3/cities.json");
        JSONArray cities = citiesJsonLoader.loadJsonArray();
        for (int i = 0; i < cities.length(); i++) {
            JSONObject cityObject = cities.getJSONObject(i);
            if (cityObject.get("code").toString().equals(city))
                return cityObject.get("name").toString();
        }
        return "";
    }

    public String getAreaName () throws IOException {
        String area = this.idBuffer.substring(0, 6);
        JSONLoader areasJsonLoader = new JSONLoader("src/main/java/top/lenconda/java/experiment/exp3/areas.json");
        JSONArray areas = areasJsonLoader.loadJsonArray();
        for (int i = 0; i < areas.length(); i++) {
            JSONObject areaObject = areas.getJSONObject(i);
            if (areaObject.get("code").toString().equals(area))
                return areaObject.get("name").toString();
        }
        return "";
    }

}
