package fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.wildcodeschool.eateam.knowledgeishere.Main2Activity;
import fr.wildcodeschool.eateam.knowledgeishere.R;

public class TheLastMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_last_main);


    }

    public void onResume(){
        super.onResume();
        startActivity(new Intent(TheLastMain.this, Main2Activity.class));
        finish();
    }
}
