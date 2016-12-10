package fr.wildcodeschool.eateam.knowledgeishere.LastTabActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import fr.wildcodeschool.eateam.knowledgeishere.FirstActivity;
import fr.wildcodeschool.eateam.knowledgeishere.FiveActivity;
import fr.wildcodeschool.eateam.knowledgeishere.FourActivity;
import fr.wildcodeschool.eateam.knowledgeishere.R;
import fr.wildcodeschool.eateam.knowledgeishere.SecondActivity;
import fr.wildcodeschool.eateam.knowledgeishere.SixActivity;
import fr.wildcodeschool.eateam.knowledgeishere.ThirdActivity;


public class LastTabActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);
        TabHost mTabHost = getTabHost();
        mTabHost.setTextAlignment(TabHost.TEXT_ALIGNMENT_CENTER);


        mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("Main").setContent(new Intent(this  ,MainActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("Action Plan").setContent(new Intent(this , ActionPlanActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("third").setIndicator("Dash-Board").setContent(new Intent(this , DashBoardActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("four").setIndicator("News Feed").setContent(new Intent(this , NewsFeedActivity.class )));
        mTabHost.addTab(mTabHost.newTabSpec("five").setIndicator("...").setContent(new Intent(this , ThreePointActivity.class )));
        mTabHost.setCurrentTab(0);
    }
}
