package com.smakhorin.easycodeandroidtask.core.ui.adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;

import java.util.List;

public class DiffUtilCallback<T extends ItemUi> extends DiffUtil.Callback {
    private final List<T> oldList;
    private final List<T> newList;

    public DiffUtilCallback(List<T> oldList, List<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).id().equals(newList.get(newItemPosition).id());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).content().equals(newList.get(newItemPosition).content());
    }
}
