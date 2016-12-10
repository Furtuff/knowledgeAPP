package fr.wildcodeschool.eateam.knowledgeishere;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_calendar);
        this.setTitle("Plan  Dimension A");

        ListView firstListview = (ListView)findViewById(R.id.ListviewCalendar);
        CustomAdapterWithCalendar customAdapter = new CustomAdapterWithCalendar(this,ArrayStatic.fakelist());
        firstListview.setAdapter(customAdapter);
    }
    //animation du menu
    public  void launchCalendar() {
        Fragment f = getFragmentManager().findFragmentByTag("prout");
        if (f != null) {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down)
                    .add(R.id.fragmentContainer, CalendarFragment
                                    .instantiate(this, CalendarFragment.class.getName()),
                            "prout"
                    ).addToBackStack(null).commit();
        }
    }
}
