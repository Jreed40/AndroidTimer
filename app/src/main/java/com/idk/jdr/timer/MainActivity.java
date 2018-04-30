package com.idk.jdr.timer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer chro;
    private long offset;
    private boolean run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chro = findViewById(R.id.chronometer);
        Button pause = findViewById(R.id.Pause);
        pause.setVisibility(View.INVISIBLE);
        View googleBtn = (Button)findViewById(R.id.googleBtn);
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

    public void startChro(View v) {
        if(!run) {
            chro.setBase(SystemClock.elapsedRealtime() - offset);
            chro.start();
            run = true;
            Button start = findViewById(R.id.Start);
            start.setVisibility(View.INVISIBLE);
            Button pause = findViewById(R.id.Pause);
            pause.setVisibility(View.VISIBLE);
        }
    }

    public void pauseChro(View v) {
        if(run) {
            chro.stop();
            offset = SystemClock.elapsedRealtime() - chro.getBase();
            run = false;
            Button start = findViewById(R.id.Start);
            start.setVisibility(View.VISIBLE);
            Button pause = findViewById(R.id.Pause);
            pause.setVisibility(View.INVISIBLE);
        }
    }
    public void clearChro(View v) {
        chro.setBase(SystemClock.elapsedRealtime());
        offset = 0;
    }

}
