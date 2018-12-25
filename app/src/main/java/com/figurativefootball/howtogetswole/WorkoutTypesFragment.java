package com.figurativefootball.howtogetswole;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ListView;
/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutTypesFragment extends ListFragment {

    static interface Listener {
        void duhItemClicked(long id);
    };

    public WorkoutTypesFragment() {}

    private Listener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Workout.workouts.length];

        for (int oi = 0; oi < names.length; oi++)  {
            names[oi] = Workout.workouts[oi].getName();
        }

        ArrayAdapter<String> workoutAdapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, names);

        setListAdapter(workoutAdapter);

        return super.onCreateView(inflater,container,savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView listView, View itemView,
                                int position, long id) {
        if (listener != null) {
            listener.duhItemClicked(id);
        }
    }

}
