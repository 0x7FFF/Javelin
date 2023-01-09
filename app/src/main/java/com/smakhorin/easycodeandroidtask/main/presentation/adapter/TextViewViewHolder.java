package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import android.view.View;

import androidx.annotation.NonNull;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.ui.adapter.GenericViewHolder;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;

public class TextViewViewHolder extends GenericViewHolder<ItemUi> {

    public TextViewViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(ItemUi item) {
        item.show(
            itemView.findViewById(R.id.officeHoursTextView)
        );
    }
}
