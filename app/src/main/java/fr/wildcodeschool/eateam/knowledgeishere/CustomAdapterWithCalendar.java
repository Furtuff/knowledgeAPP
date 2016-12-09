package fr.wildcodeschool.eateam.knowledgeishere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by tuffery on 09/12/16.
 */

public class CustomAdapterWithCalendar extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<String> list;
    boolean[] checkBoxState;

    public CustomAdapterWithCalendar(Context context, ArrayList<String> list) {
        //super(context, R.layout.list_view_item);
        this.context = context;
        this.list = list;
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

        customView = inflater.inflate(R.layout.check_listview, parent, false);
        final CheckBox text = (CheckBox) customView.findViewById(R.id.checkBox);

        text.setText(list.get(position));
        if(checkBoxState[position]){
            text.setChecked(true);
        }
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    text.setChecked(true);
                    checkBoxState[position] = true;
                }else{
                    text.setChecked(false);
                    checkBoxState[position] = false;
                }
            }
        });
        return customView;

    }

}

