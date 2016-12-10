package fr.wildcodeschool.eateam.knowledgeishere;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by tuffery on 09/12/16.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<String> list;
    boolean[] checkBoxState;

    public CustomAdapter(Context context, ArrayList<String> list) {
        //super(context, R.layout.list_view_item);
        this.context = context;
        this.list = list;
        list.add("Done");
        checkBoxState = new boolean[list.size()];
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
        View customView;
        if (getItem(position).equals("Done")) {
            customView = inflater.inflate(R.layout.donelayout, parent, false);
            Button buttonDone = (Button)customView.findViewById(R.id.done);
            buttonDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(context,"TADDDAAAA !",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(((Activity)context),SetUp2Activity.class);
                    ((Activity)context).startActivity(intent);
                }
            });
            return customView;

        } else {

            customView = inflater.inflate(R.layout.check_listview, parent, false);
            final CheckBox text = (CheckBox) customView.findViewById(R.id.checkBox);

            text.setText(list.get(position));
            if (checkBoxState[position]) {
                text.setChecked(true);
            }
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
                        text.setChecked(true);
                        checkBoxState[position] = true;
                    } else {
                        text.setChecked(false);
                        checkBoxState[position] = false;
                    }
                }
            });
            return customView;

        }
    }
}