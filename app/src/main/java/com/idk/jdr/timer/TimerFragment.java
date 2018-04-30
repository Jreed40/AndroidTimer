package com.idk.jdr.timer;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

public class TimerFragment extends Fragment {

    private Chronometer chro;
    private long offset;
    private boolean run;
    private Button start;
    private Button clear;
    final private CharSequence s = "Start";
    final private CharSequence p = "Pause";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        start = view.findViewById(R.id.Star);
        clear = view.findViewById(R.id.Clea);
        chro = view.findViewById(R.id.chronomete);
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chro.setBase(SystemClock.elapsedRealtime());
                offset = 0;
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(run) {
                    chro.stop();
                    offset = SystemClock.elapsedRealtime() - chro.getBase();
                    run = false;
                    start.setText(s);
                } else {
                    chro.setBase(SystemClock.elapsedRealtime() - offset);
                    chro.start();
                    run = true;
                    start.setText(p);
                }
            }
        });
        return view;
    }
}
