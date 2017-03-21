package com.suiki.suiki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.suiki.suiki.Vue.AllFiches;


public class Main extends Activity {

    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        intent = new Intent(Main.this , AllFiches.class);
        startActivity(intent);
    }


}
