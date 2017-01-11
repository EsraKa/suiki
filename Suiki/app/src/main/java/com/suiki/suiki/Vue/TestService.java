package com.suiki.suiki.Vue;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.suiki.suiki.Controller.PersonneDal;
import com.suiki.suiki.Model.Personne;
import com.suiki.suiki.R;

import org.w3c.dom.Text;

/**
 * Created by Massil on 11/01/2017.
 */

public class TestService extends Activity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_service_layout);
        text = (TextView) findViewById(R.id.testServiceText);

        PersonneDal dal = new PersonneDal();

        dal.getListPersonnes();
    }
}
