package com.berstek.uhacpayso.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.fragments.CurrencySelectionFragment;

public class InitialSetupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_setup);

        Fragment fragment = new CurrencySelectionFragment();
        FragmentManager fn = getFragmentManager();
        fn.beginTransaction().replace(R.id.fragment_setup_fragment, fragment).commit();
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
