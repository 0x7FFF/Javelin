package com.smakhorin.easycodeandroidtask.core.ui.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

abstract class AbstractViewHolder<T> extends RecyclerView.ViewHolder {
    public abstract void bind(T data);

    public AbstractViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
