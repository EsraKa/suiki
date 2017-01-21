package com.suiki.suiki.Vue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.suiki.suiki.Dal.PersonneDal;
import com.suiki.suiki.R;

/**
 * Created by Massil on 11/01/2017.
 */

public class TestService extends Activity {

    TextView text;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_service_layout);
        text = (TextView) findViewById(R.id.testServiceText);
        button = (Button) findViewById(R.id.app);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonneDal dal = new PersonneDal();

                dal.getPersonne();
            }
        });

    }
}
