package fr.wildcodeschool.eateam.knowledgeishere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ListView firstListview = (ListView)findViewById(R.id.firstListview);
        CustomAdapter customAdapter = new CustomAdapter(this,ArrayStatic.fakelist());
        firstListview.setAdapter(customAdapter);
    }
}
