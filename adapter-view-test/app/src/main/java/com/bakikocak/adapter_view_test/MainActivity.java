package com.bakikocak.adapter_view_test;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int COUNT = 12;
    private static final String KEY_SELECTED_ITEM = "selectedItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);

        final Item[] items = new Item[COUNT];
        for (int i = 0; i < COUNT; ++i) {
            items[i] = new Item(i);
        }

        ArrayAdapter<Item> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(KEY_SELECTED_ITEM, items[position].toString());
                startActivity(intent);

            }
        });
    }


}
