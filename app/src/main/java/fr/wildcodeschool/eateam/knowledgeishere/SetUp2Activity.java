package fr.wildcodeschool.eateam.knowledgeishere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetUp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up2);
        this.setTitle("Set Up");

        Button nextBTN2 = (Button) findViewById(R.id.nextBTN3);
        nextBTN2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SetUp2Activity.this, SetTargetActivity.class);
                startActivity(intent);
            }
        });
    }
}
