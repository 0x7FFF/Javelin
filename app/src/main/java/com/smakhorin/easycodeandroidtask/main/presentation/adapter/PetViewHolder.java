package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import android.view.View;

import androidx.annotation.NonNull;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.GenericViewHolder;

public class PetViewHolder extends GenericViewHolder<ItemUi> {
    public PetViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(ItemUi item) {
        item.show(
            itemView.findViewById(R.id.imageViewPreview),
            itemView.findViewById(R.id.textViewPetName),
            itemView.findViewById(R.id.textViewDateAdded)
        );
    }
}
