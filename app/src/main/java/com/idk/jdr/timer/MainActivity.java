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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button start = findViewById(R.id.main);
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                try {
                    long start = System.currentTimeMillis();
                    long current = System.currentTimeMillis() - start;
                    String caa = Long.toString(current);
                    Log.d("Jason", caa);
                    long timetill = 1000 - (current % 1000);
                    while(true) {
                        Thread.sleep(timetill);
                        current = System.currentTimeMillis() - start;
                        String c = Long.toString(current);
                        Log.d("Jason", caa);
                        timetill = 1000 - (current % 1000);
                    }
                } catch (InterruptedException e) {
                    Log.d("Jason", "Something broke");
                }
            }
        });
    }

}
