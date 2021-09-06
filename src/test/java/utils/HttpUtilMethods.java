package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtilMethods {

	public static int getResponseCode(String url) throws MalformedURLException, IOException{

        URL u=new URL(url);
        HttpURLConnection huc=(HttpURLConnection)u.openConnection();
        huc.setRequestMethod("GET");
        huc.setRequestProperty("Content-Type", "application/json");
        huc.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36");
        huc.connect();
        return huc.getResponseCode();
    }
}
