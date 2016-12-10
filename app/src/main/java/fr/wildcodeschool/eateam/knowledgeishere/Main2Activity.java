package fr.wildcodeschool.eateam.knowledgeishere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity.MainActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.setTitle("Main");

        TextView txtDasb = (TextView) (findViewById(R.id.txtDasb));
       // TextView txtAct = (TextView) (findViewById(R.id.txtAct));
        txtDasb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
