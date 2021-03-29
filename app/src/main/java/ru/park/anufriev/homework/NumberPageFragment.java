package ru.park.anufriev.homework;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NumberPageFragment extends Fragment {
    private Integer number = 0;
    private static final String NUMBER_STATE_KEY = "number_state_key";

    public static NumberPageFragment Create(Integer number) {
        NumberPageFragment fragment = new NumberPageFragment();
        fragment.number = number;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(NUMBER_STATE_KEY);
        }

        View view = inflater.inflate(R.layout.number_page_fragment, container, false);

        TextView textView = view.findViewById(R.id.number_page_text_view);
        textView.setText(number.toString());

        if (number % 2 == 0) {
            textView.setTextColor(Color.RED);
        } else {
            textView.setTextColor(Color.BLUE);
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(NUMBER_STATE_KEY, number);
    }
}
