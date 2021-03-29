package ru.park.anufriev.homework;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class NumberViewHolder extends RecyclerView.ViewHolder {

    private TextView numberTextView;

    public NumberViewHolder(@NonNull View itemView) {
        super(itemView);

        numberTextView = itemView.findViewById(R.id.number_item);
    }

    public void bind(Integer data) {
        numberTextView.setText(data.toString());

        if (data % 2 == 0) {
            numberTextView.setTextColor(Color.RED);
        } else {
            numberTextView.setTextColor(Color.BLUE);
        }

        numberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((AppCompatActivity) numberTextView.getContext()).getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, NumberPageFragment.Create(data))
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
