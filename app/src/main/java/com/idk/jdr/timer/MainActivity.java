package com.idk.jdr.timer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    public static boolean isRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button start = findViewById(R.id.main);
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                isRun = true;
                long start = System.currentTimeMillis();
                long current = System.currentTimeMillis() - start;
                long timetill = 1000 - (current % 1000);
                long stop = 10;
                long d = 0;
                while(d != stop) {
                    try {
                        Thread.sleep(timetill);
                        current = System.currentTimeMillis() - start;
                        d = current / 1000;
                        Log.d("Jason", " " + current);
                        timetill = 1000 - (current % 1000);
                    } catch (Exception e) {
                    }
                }
            }
        });
        final Button clear = findViewById(R.id.Clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                isRun = true;
            }
        });
        Button googleBtn = (Button)findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webaddress = Uri.parse(google);
                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoGoogle.resolveActivity(getPackageManager()) !=null) {
                    startActivity(gotoGoogle);
                }
            }
        });
    }

}
