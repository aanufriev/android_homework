package ru.park.anufriev.homework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberListAdapter extends RecyclerView.Adapter<NumberViewHolder> {

    private ListDataSource dataSource;

    public NumberListAdapter(ListDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.number_list_item,
                parent,
                false
        );

        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        Integer data = dataSource.getData().get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataSource.getData().size();
    }

    public void addNumber() {
        dataSource.addNumber();
        notifyItemInserted(dataSource.getData().size() - 1);
    }
}
