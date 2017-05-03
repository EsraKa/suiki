package com.suiki.suiki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.suiki.suiki.Vue.AllFiches;
import com.suiki.suiki.Vue.Connexion;


public class Main extends Activity {

    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = new Intent(Main.this , Connexion.class);
        startActivity(intent);
    }
}
