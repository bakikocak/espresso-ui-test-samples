package com.bakikocak.recyclerview_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<City> cityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSomeDummyData();

        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CityAdapter(this, cityList));
    }

    private void getSomeDummyData() {

        City city = new City("New York");
        cityList.add(city);

        city = new City("Los Angeles");
        cityList.add(city);

        city = new City("Paris");
        cityList.add(city);

        city = new City("Madrid");
        cityList.add(city);

        city = new City("Berlin");
        cityList.add(city);

        city = new City("Rome");
        cityList.add(city);

        city = new City("Istanbul");
        cityList.add(city);

        city = new City("Tokio");
        cityList.add(city);

        city = new City("Beijing");
        cityList.add(city);
    }
}
