package fr.wildcodeschool.eateam.knowledgeishere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity.LastTabActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.setTitle("Main");

        TextView txtDasb = (TextView) (findViewById(R.id.txtDasb));
        TextView txtAct = (TextView) (findViewById(R.id.txtAct));
        TextView txtNews = (TextView)findViewById(R.id.txtNews);
        TextView txtSett = (TextView)findViewById(R.id.txtSett);
        TextView txtPoint = (TextView)findViewById(R.id.txtPoint);

        onClick(txtDasb,2);
        onClick(txtAct, 1);
        onClick(txtNews, 3);
        onClick(txtSett, 0);
        onClick(txtPoint, 4);

    }

    public void onClick(TextView textView, final int pos){
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, LastTabActivity.class);
                intent.putExtra("pass",pos);
                startActivity(intent);
            }
        });
    }
}
