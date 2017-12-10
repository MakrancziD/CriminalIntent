package com.example.makra.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;
import java.util.UUID;

public class DatePickerActivity extends SingleFragmentActivity {


    public static Intent newIntent(Context packageContext, Date date){
        Intent intent = new Intent(packageContext, DatePickerActivity.class);
        intent.putExtra(DatePickerFragment.EXTRA_DATE, date);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        Date date = (Date) getIntent().getSerializableExtra(DatePickerFragment.EXTRA_DATE);
        return DatePickerFragment.newInstance(date);
    }
}
