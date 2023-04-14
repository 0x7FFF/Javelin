package com.smakhorin.easycodeandroidtask.main.presentation;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.presentation.BackPress;
import com.smakhorin.easycodeandroidtask.core.ui.MainFragmentUi;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.MainAdapter;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.OnPetClick;

public class MainFragment extends BackPress.Fragment<MainFragmentUi, MainFragmentViewModel> {

    @Override
    protected Class<MainFragmentViewModel> viewModelClass() {
        return MainFragmentViewModel.class;
    }

    @Override
    protected Integer getLayoutResId() {
        return R.layout.single_recyclerview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        MainAdapter.Base mainAdapter = new MainAdapter.Base(new OnPetClick() {
            @Override
            public void onClick(String content) {
                viewModel.displayPetDetails(content);
            }
        });
        recyclerView.setAdapter(mainAdapter);

        viewModel.observe(this, mainUi -> mainUi.map(mainAdapter));

        viewModel.observeClick(this, withinWorkingHours -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            String message;
            if (withinWorkingHours) {
                message = "Thank you for getting in touch with us. We’ll get back to you as soon as possible";
            } else {
                message = "Work hours has ended. Please contact us again on the next work day";
            }
            builder.setTitle("Information");
            builder.setMessage(message);
            builder.setPositiveButton("OK", (dialog, which) -> {
                dialog.dismiss();
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }
}
