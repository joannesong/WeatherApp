package nyc.c4q.weatherapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        view=inflater.inflate(R.layout.fragment_now, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.now_rv);
        LinearLayoutManager layout = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layout);
        List<Periods> test= DatabaseInitializer.getall(WeatherDatabase.getDatabase(view.getContext()));

        TextView text= view.findViewById(R.id.textView);
        TextView avg= view.findViewById(R.id.textView2);

        TextView  weatherprime= view.findViewById(R.id.weatherprime);
        TextView tonight= view.findViewById(R.id.tonight_temp);


        TextView tomorrow= view.findViewById(R.id.tomorrow_temp);
        TextView prime= view.findViewById(R.id.tomorrow_prime);

        ImageView imageView = view.findViewById(R.id.imageView);








        for (int i = 0; i <test.size() ; i++) {
//           text.setText(test.get(0).getAvgtempf());
           avg.setText(test.get(0).getWeatherprimary());
           weatherprime.setText(test.get(0).getWeatherprimary());

            int dot=test.get(1).getIcon().indexOf(".");
            String cast=test.get(1).getIcon().substring(0,dot);
            int id = view.getContext().getResources().getIdentifier(cast, "drawable", view.getContext().getPackageName());
            imageView.setImageResource(id);

//           tonight.setText(test.get(1).getMaxtempf());
           test.get(1).getWeatherprimary();

//           tomorrow.setText(test.get(2).getMaxtempf());




        }





//        recyclerView.setAdapter(new WeatherCodedAdaptor(test));

        return  view;
    }

}
