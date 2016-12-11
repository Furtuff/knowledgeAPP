package fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fr.wildcodeschool.eateam.knowledgeishere.R;

public class DashAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    /**
     * Created by tuffery on 11/12/16.
     */

    public static class CustomAdapterDashBoard extends BaseAdapter {
        Context context;
        LayoutInflater inflater;
        ArrayList<String> list;


        public CustomAdapterDashBoard(Context context, ArrayList<String> list) {
            //super(context, R.layout.list_view_item);
            this.context = context;
            this.list = list;


        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView, final ViewGroup parent) {
            inflater = (LayoutInflater) this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
            //(LayoutInflater.from(getContext()));
            final int[] percent = {50,60,80,40};
            final View customView = inflater.inflate(R.layout.dashlist_element, parent, false);
            ViewGroup.LayoutParams params = customView.getLayoutParams();
            params.height = 200;
            PieGraph pie = (PieGraph) customView.findViewById(R.id.pieChart);
            float[] data = {percent[position],100-percent[position]};
            pie.setData(data);

            TextView textView = (TextView)customView.findViewById(R.id.textViewDash);
            textView.setText(list.get(position));
            customView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Bidouille)context).speed(percent[position]);
                }
            });
            return customView;
        }
    }
}
