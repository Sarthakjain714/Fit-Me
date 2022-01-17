package com.example.fitme.Activities.Bmi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitme.Activities.Meditation.Menu;
import com.example.fitme.R;

import java.util.ArrayList;

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.ViewHolder> {
    ArrayList<Menu> menuArrayList;
    Context context;

    public ChartAdapter(ArrayList<Menu> menuArrayList, Context context) {
        this.menuArrayList = menuArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_print, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChartAdapter.ViewHolder holder, int position) {
        Menu menu = menuArrayList.get(position);
        holder.time.setText(menu.getTime());
        holder.menu.setText(menu.getMenu());

    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView time, menu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time1);
            menu = itemView.findViewById(R.id.menu);
        }
    }
}
