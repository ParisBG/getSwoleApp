package com.figurativefootball.howtogetswole;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";
    WorkoutDetailFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

         frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(
                        R.id.frag_detail);

        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);

        //frag.setWorkout(3);
        frag.setWorkout(workoutId);
    }



}
