package com.smakhorin.easycodeandroidtask;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.IdlingResource;

public class RecyclerViewIdlingResource implements IdlingResource {

    private final RecyclerView recyclerView;
    private ResourceCallback resourceCallback;

    public RecyclerViewIdlingResource(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public String getName() {
        return "RecyclerViewIdlingResource";
    }

    @Override
    public boolean isIdleNow() {
        boolean idle = recyclerView.getAdapter() != null && recyclerView.getAdapter().getItemCount() > 0;

        if (idle && resourceCallback != null) {
            resourceCallback.onTransitionToIdle();
        }

        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.resourceCallback = callback;
    }
}
