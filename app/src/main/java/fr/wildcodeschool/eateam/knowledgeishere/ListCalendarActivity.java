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

        ListView firstListview = (ListView)findViewById(R.id.ListviewCalendar);
        CustomAdapterWithCalendar customAdapter = new CustomAdapterWithCalendar(this,ArrayStatic.fakelist());
        firstListview.setAdapter(customAdapter);
    }
    //animation du menu
    private void toggleList() {
        Fragment f = getFragmentManager().findFragmentByTag(LIST_FRAGMENT_TAG);
        if (f != null) {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down)
                    .add(R.id.fragmentContainer, SlidingListFragment
                                    .instantiate(this, SlidingListFragment.class.getName()),
                            "prout"
                    ).addToBackStack(null).commit();
        }
    }
}
