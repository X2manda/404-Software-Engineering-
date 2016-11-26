package com.berstek.uhacpayso.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.adapters.PagerAdapter;

/**
 * Created by John on 11/26/2016.
 */

public class WelcomePagerActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_pager);
        ViewPager viewPager = (ViewPager) findViewById(R.id.activity_welcome_pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
