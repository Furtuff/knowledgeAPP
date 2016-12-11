package fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.cardiomood.android.controls.gauge.SpeedometerGauge;


import fr.wildcodeschool.eateam.knowledgeishere.ArrayStatic;
import fr.wildcodeschool.eateam.knowledgeishere.CustomAdapter;
import fr.wildcodeschool.eateam.knowledgeishere.CustomAdapterDashBoard;
import fr.wildcodeschool.eateam.knowledgeishere.R;

public class DashBoardActivity extends AppCompatActivity {
    private SpeedometerGauge speedometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);



        // Customize SpeedometerGauge
        speedometer = (SpeedometerGauge) findViewById(R.id.speedometer);

        // Add label converter
        speedometer.setLabelConverter(new SpeedometerGauge.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                int chmok = (int)progress;
                return String.valueOf((chmok));
            }
        });

        speedometer.setLabelTextSize(30);
        // configure value range and ticks
        speedometer.setAlpha(0.9f);
        speedometer.setMaxSpeed(100);
        speedometer.setMajorTickStep(20);
        speedometer.setMinorTicks(2);


        // Configure value range colors
        speedometer.addColoredRange(0, 10, Color.CYAN);
        speedometer.addColoredRange(10, 40, Color.GREEN);
        speedometer.addColoredRange(40, 80, Color.YELLOW);
        speedometer.addColoredRange(80, 100, Color.RED);
        speedometer.setLabelConverter(new SpeedometerGauge.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                return String.valueOf(progress);
            }
        });
        speedometer.setSpeed(200,true);


        ListView dashListview = (ListView)findViewById(R.id.dashList);
        CustomAdapterDashBoard customAdapter = new CustomAdapterDashBoard(this, ArrayStatic.fakelistDimension());
        dashListview.setAdapter(customAdapter);

    }
}
