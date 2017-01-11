package com.suiki.suiki;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Massil on 28/12/2016.
 */

public class Personne {
    private static String URL = "http://localhost:53776/api/Personne";
    public static void PutPersonne(String nom , String prenom , String mail) throws IOException {
        URL += "/"+nom + "/" + prenom + "/"+mail + "/" + "P";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                APIConnection.Connection(URL);
                try {
                    APIConnection.PutObject();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }
}