package nyc.c4q.weatherapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.weatherapp.R;
import nyc.c4q.weatherapp.WeatherCodedAdaptor;
import nyc.c4q.weatherapp.database.DatabaseInitializer;
import nyc.c4q.weatherapp.database.WeatherDatabase;
import nyc.c4q.weatherapp.model.Periods;


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
        view = inflater.inflate(R.layout.fragment_now, container, false);
        List<Periods> test = DatabaseInitializer.getall(WeatherDatabase.getDatabase(view.getContext()));

        TextView text = view.findViewById(R.id.textView);
        TextView avg = view.findViewById(R.id.textView2);

        TextView weatherprime = view.findViewById(R.id.weatherprime);
        TextView tonight = view.findViewById(R.id.tonight_temp);


        TextView tomorrow = view.findViewById(R.id.tomorrow_temp);
        TextView prime = view.findViewById(R.id.tomorrow_prime);

        ImageView imageView = view.findViewById(R.id.imageView);
        ImageView tonight_icon = view.findViewById(R.id.tonight_icon);
        ImageView tomorrow_icon = view.findViewById(R.id.tomorrow_icon);


        Log.e("Test Size", test.size() + "");
//        Log.e("Test Size", test.get(0).getAvgtempf() + "");
//        Log.e("Test Size", test.get(0).getWeather() + "");
//        Log.e("Test Size", test.get(0).getWeatherprimary() + "");
//        Log.e("Test Size", test.get(0).getIcon() + "");


//        text.setText(test.get(0).getWeather());
//        int i = test.get(0).getAvgtempf();
//
////        avg.setText(i);
//        weatherprime.setText(test.get(0).getWeatherprimary());
//
//        int dot = test.get(0).getIcon().indexOf(".");
//        String cast = test.get(0).getIcon().substring(0, dot);
//        int id = view.getContext().getResources().getIdentifier(cast, "drawable", view.getContext().getPackageName());
//        imageView.setImageResource(id);
//
//        int e = test.get(2).getAvgtempf();
//
//        tonight.setText(test.get(2).getAvgtempf());
//
//        int dot1 = test.get(0).getIcon().indexOf(".");
//        String cast1 = test.get(0).getIcon().substring(0, dot1);
//        int id1 = view.getContext().getResources().getIdentifier(cast1, "drawable", view.getContext().getPackageName());
//        tonight_icon.setImageResource(id1);
//
//
//        tomorrow.setText(test.get(2).getAvgtempf());
//        int hello=test.get(2).getAvgtempf();
//
//        tonight.setText(test.get(2).getAvgtempf());
//
//        int dot2 = test.get(0).getIcon().indexOf(".");
//        String cast3 = test.get(0).getIcon().substring(0, dot2);
//        int id3 = view.getContext().getResources().getIdentifier(cast3, "drawable", view.getContext().getPackageName());
//        tonight_icon.setImageResource(id3);


//        recyclerView.setAdapter(new WeatherCodedAdaptor(test));

        return view;
    }

}
