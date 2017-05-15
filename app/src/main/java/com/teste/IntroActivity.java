package com.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class IntroActivity extends Activity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        IniciaSplash();
    }

    public void IniciaSplash (){

        setContentView(R.layout.activity_intro);

        new Thread(new Runnable() {
            @Override
            public void run() {

                counter ++;

                try{
                    while (counter == 1 || counter <= 5) {
                        Thread.sleep(500);
                        counter++;

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (counter == 6) {
                    Intent it = new Intent(IntroActivity.this, MainActivity.class);
                    startActivity(it);

                    counter++;

                }
            }
        }).start();
    }
}