package com.suiki.suiki;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Massil on 28/12/2016.
 */

public class APIConnection {
    public static URL url;
    public static HttpURLConnection connection;
    public static JSONObject GetJsonObject() throws JSONException {
        try {
            InputStream stream = connection.getInputStream();
            char[] buffer = new char[1024];
            StringBuilder out = new StringBuilder();

            try (Reader in = new InputStreamReader(stream, "UTF-8")) {
                int length = 0;
                while (length >= 0) {
                    length = in.read(buffer, 0, buffer.length);
                    out.append(buffer, 0, length);
                }
            }

            JSONObject json = new JSONObject(out.toString());
            return json;
        }catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONObject("Error: EMPTY");
    }

    public static void PutObject() throws IOException {
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(
                APIConnection.connection.getOutputStream()
        );
        out.write("Ressource content");
        out.close();
        connection.getInputStream();
    }

    public static void Connection(String urlConnect)
    {
        try {
            url = new URL(urlConnect);
            connection = (HttpURLConnection) url.openConnection();
            //connection.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
