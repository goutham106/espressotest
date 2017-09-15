package com.gm.recyclerdetailtest.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gm.recyclerdetailtest.R;
import com.gm.recyclerdetailtest.databinding.ActivityDetailBinding;
import com.gm.recyclerdetailtest.model.DataItem;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/13/17.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "dataItem";

    public static void startActivity(Context context, DataItem dataItem) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_DATA, dataItem);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        DataItem dataItem = getIntent().getParcelableExtra(EXTRA_DATA);
        binding.setDataItem(dataItem);
    }
}
