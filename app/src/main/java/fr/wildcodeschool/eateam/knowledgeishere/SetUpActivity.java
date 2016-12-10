package fr.wildcodeschool.eateam.knowledgeishere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        this.setTitle("Set Up");

        Button next = (Button) findViewById(R.id.nextBTN2);
        next.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SetUpActivity.this, Self_Assessment.class);
                startActivity(intent);
            }
        });
    }
}
