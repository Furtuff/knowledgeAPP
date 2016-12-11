package fr.wildcodeschool.eateam.knowledgeishere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Self_Assessment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment);
        this.setTitle("Self Assessment");
         final RadioButton A, B, C, D;


        Button nextBTN = (Button) findViewById(R.id.nextBTN);
        A = (RadioButton) findViewById(R.id.radioButton1);
        B = (RadioButton) findViewById(R.id.radioButton2);
        C = (RadioButton) findViewById(R.id.radioButton3);
        D = (RadioButton) findViewById(R.id.radioButton4);

        nextBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Self_Assessment.this, Assessment.class);
                if (A.isChecked())
                    intent.putExtra("Next", 0);
                else if(B.isChecked())
                        intent.putExtra("Next", 1);
                else if (C.isChecked())
                    intent.putExtra("Next", 2);

                else
                    intent.putExtra("Next", 3);

                startActivity(intent);
            }
        });

    }
}