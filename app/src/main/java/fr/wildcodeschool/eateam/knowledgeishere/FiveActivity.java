package fr.wildcodeschool.eateam.knowledgeishere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class FiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        ListView firstListview = (ListView)findViewById(R.id.fiveListview);
        CustomAdapter customAdapter = new CustomAdapter(this,ArrayStatic.fakelist());
        firstListview.setAdapter(customAdapter);
    }
}
