package ru.park.anufriev.homework;


import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NumberListFragment extends Fragment {

    private Integer itemsCount = Constants.DEFAULT_ITEM_COUNT;
    public static final String ITEMS_COUNT_KEY = "items_count_key";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            itemsCount = savedInstanceState.getInt(ITEMS_COUNT_KEY);
        }

        View view = inflater.inflate(R.layout.number_list_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.number_list);

        Integer spanCount = container.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT
                ? Constants.PORTRAIT_COLUMN_COUNT : Constants.LANDSCAPE_COLUMN_COUNT;

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), spanCount));

        ListDataSource dataSource = new ListDataSource(itemsCount);
        NumberListAdapter adapter = new NumberListAdapter(dataSource);
        recyclerView.setAdapter(adapter);

        recyclerView.setPadding(20, 20, 20, 20);
        recyclerView.setClipToPadding(false);
        recyclerView.setClipChildren(false);

        view.findViewById(R.id.add_number_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addNumber();
                itemsCount++;
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ITEMS_COUNT_KEY, itemsCount);
    }
}
