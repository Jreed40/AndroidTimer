package com.idk.jdr.timer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;

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
    }

}
