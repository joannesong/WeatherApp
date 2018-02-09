package nyc.c4q.weatherapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.weatherapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {


    View view;
    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_map, container, false);
        return view;
    }

}
