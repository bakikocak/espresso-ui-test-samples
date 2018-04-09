package com.bakikocak.recyclerview_test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.tv_selected_item);
        Bundle bundle = getIntent().getExtras();
        String selectedItem = bundle.getString("selectedItem");

        if(selectedItem != null){
            textView.setText(selectedItem);
        }


    }
}
