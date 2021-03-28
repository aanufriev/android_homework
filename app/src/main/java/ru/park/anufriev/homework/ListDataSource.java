package ru.park.anufriev.homework;

import java.util.ArrayList;
import java.util.List;

public class ListDataSource {
    private final List<Integer> mData;

    public ListDataSource(Integer itemCount) {
        mData = new ArrayList<>();

        for (int i = 1; i <= itemCount; i++) {
            mData.add(i);
        }
    }

    public List<Integer> getData() {
        return mData;
    }

    public void addNumber() {
        Integer last = mData.get(mData.size() - 1);
        mData.add(last + 1);
    }
}
