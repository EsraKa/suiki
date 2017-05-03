package com.suiki.suiki.Model.Helper;

import android.widget.TextView;

/**
 * Created by Massil on 02/05/2017.
 */

public class Chronometer implements Runnable {

    private int minutes = 0;
    private int seconds = 0;

    @Override
    public void run() {

        System.out.print("coucou");
        try {
            Thread.sleep(1);
            if(seconds++>=60)
            {
                seconds = seconds%60;
                minutes++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void setTextView(TextView text)
    {
        text.setText(String.format("%02d" , minutes) + ":"+String.format("%02d",seconds));
    }
}
