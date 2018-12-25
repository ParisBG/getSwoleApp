package com.figurativefootball.howtogetswole;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopWatchFragment extends Fragment implements View.OnClickListener{
    private int seconds = 0;
    private boolean isRunning;
    private boolean wasRunning;
    TextView timeView;

    public StopWatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_stopwatch,
                container,
                false);
        runTimer(layout);

        Button start = layout.findViewById(R.id.start);
        start.setOnClickListener(this);
        Button stop = layout.findViewById(R.id.stop);
        stop.setOnClickListener(this);
        Button reset = layout.findViewById(R.id.reset);
        reset.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                onClickStart();
                break;

            case R.id.stop:
                onClickStop();
                break;

            case R.id.reset:
                onClickReset();
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning)
            isRunning = true;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean("isRunning",isRunning);
        savedInstanceState.putBoolean("wasRunning",wasRunning);
        savedInstanceState.putInt("seconds",seconds);

    }

    private void onClickStart() { isRunning = true; }

    private void onClickStop() {
        isRunning = false;
    }

    private void onClickReset() {
        isRunning = false;
        seconds = 0;
    }

    private void runTimer(View view) {
        //View view = getView();
        timeView = view.findViewById(R.id.viewTimer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run(){
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d",hours,minutes,secs);

                timeView.setText(time);
                if (isRunning) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }

}
