package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import android.view.View;

import androidx.annotation.NonNull;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.GenericViewHolder;

public class PetViewHolder extends GenericViewHolder<ItemUi> {
    OnPetClick onItemClick;

    public PetViewHolder(@NonNull View itemView, OnPetClick onItemClick) {
        super(itemView);
        this.onItemClick = onItemClick;
    }

    @Override
    public void bind(ItemUi item) {
        item.show(
            itemView.findViewById(R.id.imageViewPreview),
            itemView.findViewById(R.id.textViewPetName),
            itemView.findViewById(R.id.textViewDateAdded)
        );
        itemView.setOnClickListener(v -> onItemClick.onClick(item.content()));
    }
}
