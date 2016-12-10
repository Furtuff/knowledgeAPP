package fr.wildcodeschool.eateam.knowledgeishere;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Assessment extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Assessment");

        TabHost mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("A").setContent(new Intent(this  ,FirstActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("B").setContent(new Intent(this , SecondActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("third").setIndicator("C").setContent(new Intent(this , ThirdActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("four").setIndicator("D").setContent(new Intent(this , FourActivity.class )));

        mTabHost.setCurrentTab(0);

    }
}
