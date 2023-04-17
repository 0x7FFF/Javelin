package com.smakhorin.easycodeandroidtask.main.presentation;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.presentation.BackPress;
import com.smakhorin.easycodeandroidtask.core.ui.MainFragmentUi;
import com.smakhorin.easycodeandroidtask.core.ui.WorkingHoursAlertDialog;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.MainAdapter;

public class MainFragment extends BackPress.Fragment<MainFragmentUi, MainFragmentViewModel> {

    RecyclerView recyclerView;
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
        recyclerView = view.findViewById(R.id.recyclerView);
        MainAdapter.Base mainAdapter = new MainAdapter.Base(
            content -> viewModel.displayPetDetails(content)
        );
        recyclerView.setAdapter(mainAdapter);

        viewModel.observe(this, mainUi -> mainUi.map(mainAdapter));

        viewModel.observeClick(this, withinWorkingHours -> {
            new WorkingHoursAlertDialog(getContext(), withinWorkingHours).display();
        });
    }

    @VisibleForTesting
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
