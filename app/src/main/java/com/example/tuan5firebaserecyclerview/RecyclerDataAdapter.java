package com.example.tuan5firebaserecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.DataViewHolder> {

    private List<Person> people;
    private Context context;

    public RecyclerDataAdapter(List<Person> people, Context context) {
        this.people = people;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;

        switch (viewType){
            case 1:
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_name, parent, false);
                break;
            case 2:
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_name_female, parent, false);
                break;
            default:
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_name, parent, false);
                break;
        }

        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        String name = people.get(position).getName();
        holder.tvname.setText(name);
    }

    @Override
    public int getItemViewType(int position) {
        if (people.get(position).isMale()){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        return people == null? 0 :people.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView tvname;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tvname);
        }
    }
}
