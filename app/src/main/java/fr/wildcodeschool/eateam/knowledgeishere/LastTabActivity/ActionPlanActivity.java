package fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import fr.wildcodeschool.eateam.knowledgeishere.ArrayStatic;
import fr.wildcodeschool.eateam.knowledgeishere.CustomAdapterWithCalendar;
import fr.wildcodeschool.eateam.knowledgeishere.R;

public class ActionPlanActivity extends AppCompatActivity implements Interfesse{
    ListView actionListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_plan);
        this.setTitle("Action Plan");
        actionListView = (ListView)findViewById(R.id.actionPlanList);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,ArrayStatic.fakelistDimension());
        actionListView.setAdapter(simpleAdapter);

    }

    @Override
    public void onclick(String dimension) {
        this.setTitle(dimension);
        CustomAdapterWithCalendar customAdapterWithCalendar = new CustomAdapterWithCalendar(this,ArrayStatic.fakelist());
        actionListView.setAdapter(customAdapterWithCalendar);

    }
    @Override
    public void onResume(){
        super.onResume();
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,ArrayStatic.fakelistDimension());
        actionListView.setAdapter(simpleAdapter);
    }
}
