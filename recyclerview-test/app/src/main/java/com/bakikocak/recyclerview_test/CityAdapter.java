package com.bakikocak.recyclerview_test;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder>{

    Context context;
    List<City> cityList;

    public CityAdapter(Context context, List<City> cityList) {
        this.context = context;
        this.cityList = cityList;
    }

    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.list_item_layout, parent, shouldAttachToParentImmediately);
        CityViewHolder viewHolder = new CityViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.cityTitleTextView.setText(cityList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {

        private final TextView cityTitleTextView;
        private static final String KEY_SELECTED_ITEM = "selectedItem";


        public CityViewHolder(View itemView) {
            super(itemView);

            cityTitleTextView = (TextView) itemView.findViewById(R.id.tv_city_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, cityList.get(getAdapterPosition()).getTitle() + " is selected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, SecondActivity.class);
                    intent.putExtra(KEY_SELECTED_ITEM, cityList.get(getAdapterPosition()).getTitle());
                    context.startActivity(intent);
                }
            });
        }

    }
}
