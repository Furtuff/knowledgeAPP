package fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fr.wildcodeschool.eateam.knowledgeishere.R;

/**
 * Created by tuffery on 11/12/16.
 */

public class SimpleAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<String> list;
    boolean[] checkBoxState;

    public SimpleAdapter(Context context, ArrayList<String> list) {
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

    public View getView(final int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //(LayoutInflater.from(getContext()));
        final View customView;

            customView = inflater.inflate(R.layout.simple_list, parent, false);
        TextView textView = (TextView)customView.findViewById(R.id.simple);
        textView.setText(list.get(position));
        ViewGroup.LayoutParams params = customView.getLayoutParams();
        params.height = 200;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Interfesse)context).onclick(list.get(position));

            }
        });
        return customView;

    }
}