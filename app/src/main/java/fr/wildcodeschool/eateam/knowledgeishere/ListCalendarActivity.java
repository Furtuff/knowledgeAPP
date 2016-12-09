package fr.wildcodeschool.eateam.knowledgeishere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_calendar);

        ListView firstListview = (ListView)findViewById(R.id.ListviewCalendar);
        CustomAdapterWithCalendar customAdapter = new CustomAdapterWithCalendar(this,ArrayStatic.fakelist());
        firstListview.setAdapter(customAdapter);
    }
}
