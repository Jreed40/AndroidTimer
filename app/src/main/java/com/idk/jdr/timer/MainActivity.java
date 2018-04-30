package com.idk.jdr.timer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
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
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navList);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navList =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFrag = null;

                    switch (item.getItemId()) {
                        case R.id.nav_timer:
                            selectedFrag = new TimerFragment();
                            break;
                        case R.id.nav_clock:
                            selectedFrag = new ClockFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();

                    return true;
                }
            };

    public void combineChro(View v) {
        final CharSequence s = "Start";
        final CharSequence p = "Pause";
        if(run) {
            chro.stop();
            offset = SystemClock.elapsedRealtime() - chro.getBase();
            run = false;
            Button start = findViewById(R.id.Start);
            start.setText(s);
        } else {
            chro.setBase(SystemClock.elapsedRealtime() - offset);
            chro.start();
            run = true;
            Button start = findViewById(R.id.Start);
            start.setText(p);
        }
    }

    public void clearChro(View v) {
        chro.setBase(SystemClock.elapsedRealtime());
        offset = 0;
    }

}
