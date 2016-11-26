package com.berstek.uhacpayso.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.berstek.uhacpayso.fragments.WelcomeMainFragment;
import com.berstek.uhacpayso.fragments.WelcomeManageFragment;
import com.berstek.uhacpayso.fragments.WelcomeMonitorFragment;
import com.berstek.uhacpayso.fragments.WelcomeQuoteFragment;
import com.berstek.uhacpayso.fragments.WelcomeTrackFragment;

/**
 * Created by John on 11/26/2016.
 * Github error. Comment Test
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new WelcomeMainFragment();
            case 1: return new WelcomeTrackFragment();
            case 2: return new WelcomeMonitorFragment();
            case 3: return new WelcomeManageFragment();
            case 4: return new WelcomeQuoteFragment();
        }
        return new WelcomeQuoteFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }
}
