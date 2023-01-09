package com.smakhorin.easycodeandroidtask.core.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.smakhorin.easycodeandroidtask.core.Mapper;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericAdapter<T extends ItemUi> extends RecyclerView.Adapter<GenericViewHolder<T>> implements Mapper.Unit<List<T>> {

    private final ViewHolderFactoryChain<T> viewHolderFactoryChain;
    ArrayList<T> list = new ArrayList<>();

    public GenericAdapter(ViewHolderFactoryChain<T> viewHolderFactoryChain) {
        this.viewHolderFactoryChain = viewHolderFactoryChain;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public GenericViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return viewHolderFactoryChain.viewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder<T> holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public Void map(List<T> data) {
        DiffUtilCallback<T> diffUtilCallback = new DiffUtilCallback<T>(list, data);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(diffUtilCallback);
        list.clear();
        list.addAll(data);
        result.dispatchUpdatesTo(this);
        return null;
    }

    public void add(List<T> data) {
        DiffUtilCallback<T> diffUtilCallback = new DiffUtilCallback<T>(list, data);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(diffUtilCallback);
        list.addAll(data);
        result.dispatchUpdatesTo(this);
    }

    public abstract static class Base extends GenericAdapter<ItemUi> {
        public Base(ViewHolderFactoryChain<ItemUi> viewHolderFactoryChain) {
            super(viewHolderFactoryChain);
        }
    }
}
