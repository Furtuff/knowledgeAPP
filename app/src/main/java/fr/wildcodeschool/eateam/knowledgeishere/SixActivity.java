package fr.wildcodeschool.eateam.knowledgeishere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        ListView firstListview = (ListView)findViewById(R.id.sixListview);
        CustomAdapter customAdapter = new CustomAdapter(this,ArrayStatic.fakelist());
        firstListview.setAdapter(customAdapter);
    }
}
