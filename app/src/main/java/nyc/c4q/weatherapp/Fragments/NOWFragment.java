package nyc.c4q.weatherapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.weatherapp.R;
import nyc.c4q.weatherapp.WeatherCodedAdaptor;


/**
 * A simple {@link Fragment} subclass.
 */
public class NOWFragment extends Fragment {

    View view;

    public NOWFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_now, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.now_rv);
        LinearLayoutManager layout = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layout);
        List<Integer> test=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            test.add(i);
        }
        recyclerView.setAdapter(new WeatherCodedAdaptor(test));

        return  view;
    }

}
