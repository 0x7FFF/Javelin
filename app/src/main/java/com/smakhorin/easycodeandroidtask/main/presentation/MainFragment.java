package com.smakhorin.easycodeandroidtask.main.presentation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.core.presentation.BackPress;
import com.smakhorin.easycodeandroidtask.core.ui.MainUi;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.MainAdapter;

public class MainFragment extends BackPress.Fragment<MainUi, MainViewModel> {

    @Override
    protected Class<MainViewModel> viewModelClass() {
        return MainViewModel.class;
    }

    @Override
    protected Integer getLayoutResId() {
        return R.layout.single_recyclerview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        MainAdapter.Real mainAdapter = new MainAdapter.Real();
        recyclerView.setAdapter(mainAdapter);

        viewModel.observe(this, mainUi -> mainUi.map(mainAdapter));
    }
}
