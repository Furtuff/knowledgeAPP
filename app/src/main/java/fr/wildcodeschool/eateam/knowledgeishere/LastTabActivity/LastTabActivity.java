package fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import fr.wildcodeschool.eateam.knowledgeishere.R;

import static android.R.attr.width;


public class LastTabActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_tab);
        TabHost mTabHost = getTabHost();
        mTabHost.setTextAlignment(TabHost.TEXT_ALIGNMENT_CENTER);
        Intent intent = getIntent();
        int clicked = intent.getIntExtra("pass",0);


        mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("Main").setContent(new Intent(this  ,TheLastMain.class )));
        mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("Action Plan").setContent(new Intent(this , ActionPlanActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("third").setIndicator("Dash-Board").setContent(new Intent(this , DashBoardActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("four").setIndicator("News Feed").setContent(new Intent(this , NewsFeedActivity.class )));
/*
        mTabHost.addTab(mTabHost.newTabSpec("five").setIndicator("...").setContent(new Intent(this , ThreePointActivity.class )));
*/
        mTabHost.setCurrentTab(clicked);
for (int i = 0; i<4;i++) {
    TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
    tv.setAllCaps(false);
/*    mTabHost.getTabWidget().getChildAt(i).setLayoutParams(new
            LinearLayout.LayoutParams((width/5)-2,50));*/
}
    }
}
