package com.figurativefootball.howtogetswole;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements WorkoutTypesFragment.Listener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    public void showDetail(View view) {
        Intent intent = new Intent (this, DetailActivity.class);
        startActivity(intent);
    } */

    @Override
    public void duhItemClicked(long id) {
        View fragContainer = findViewById(R.id.frameContainer);
        if (fragContainer != null) {

            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWorkout(id);
            //ft.add(R.id.frameContainer, details);
            ft.replace(R.id.frameContainer, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack(null);
            ft.commit();


        } else {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
        /*
    @Override
    public void onDestroy() {
        super.onDestroy();
        AlertDialog shit = new AlertDialog.Builder(MainActivity.this).create();
        shit.setMessage("Oh Shit! Android Has No Idea What The Fuck Just Happened...");
        shit.setButton(AlertDialog.BUTTON_NEUTRAL,
                "ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });}
*/

}
