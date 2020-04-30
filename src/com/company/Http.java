package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Http {

    public static void print() {
        System.out.println("This feature is still under construction. Stay tuned!");
    }

    public void makeUrl(){
        URL url = null;
        try {
            url = new URL("https://www.bilsvar.se/api/carmodel/search?brand=BMW&model=X3&fuelgroup=Diesel&gearb" +
                    "oxtype=Manuell&searchgroup=1&pagesize=15&pagenumber=1&sortField=environmentalPosition&sortOrder=1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            if(con.getResponseCode() == 200){
                while ((inputLine = in.readLine()) != null){
                    content.append(inputLine);
                    System.out.println(content.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
