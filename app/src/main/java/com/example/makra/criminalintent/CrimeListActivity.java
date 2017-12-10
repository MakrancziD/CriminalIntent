package com.example.makra.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by makra on 2017. 08. 13..
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
