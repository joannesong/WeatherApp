package nyc.c4q.weatherapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jervon.arnoldd on 2/8/18.
 */

public class WeatherCodedAdaptor extends RecyclerView.Adapter<WeatherCodedAdaptor.WeatherCodedHolder> {
   List<Integer> test;

    public WeatherCodedAdaptor(List<Integer> test) {
        this.test = test;
    }

    @Override
    public WeatherCodedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weathercoded_item_view,parent,false);

        Log.e("sizw",test.size()+"");
        return new WeatherCodedHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherCodedHolder holder, int position) {
       int y =test.get(position);
       holder.onBind(y);
    }

    @Override
    public int getItemCount() {
        return test.size();
    }

    public class WeatherCodedHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image;

        public WeatherCodedHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.time);
            image = itemView.findViewById(R.id.icon);
        }

        public void onBind(int y) {
            final Class drawableClass = R.drawable.class;
            final Field[] fields = drawableClass.getFields();

            final Random rand = new Random();
            int rndInt = rand.nextInt(fields.length);
            try {
                int resID = fields[rndInt].getInt(drawableClass);
                image.setImageResource(resID);
            } catch (Exception e) {
                e.printStackTrace();
            }



            text.setText(y+"pm");
//            image.setBackground(R.drawable.);
        }
    }
}
