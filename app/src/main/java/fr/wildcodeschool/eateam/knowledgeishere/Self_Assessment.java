package fr.wildcodeschool.eateam.knowledgeishere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Self_Assessment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment);
        this.setTitle("Self Assessment");

        Button nextBTN = (Button) findViewById(R.id.nextBTN);
        nextBTN.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Self_Assessment.this, Assessment.class);
                startActivity(intent);
            }
        });

    }
}