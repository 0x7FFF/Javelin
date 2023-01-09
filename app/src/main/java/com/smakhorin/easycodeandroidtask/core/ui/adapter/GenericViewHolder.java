package com.smakhorin.easycodeandroidtask.core.ui.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;

public abstract class GenericViewHolder<T extends ItemUi> extends RecyclerView.ViewHolder {
    public GenericViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind(T item);
}
