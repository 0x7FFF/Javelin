package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import com.smakhorin.easycodeandroidtask.core.ui.BaseView;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;

public class WorkingHoursUi extends ItemUi.Static {

    private final boolean workingHours;

    public static final Integer TYPE = 2;

    public WorkingHoursUi(boolean workingHours) {
        this.workingHours = workingHours;
    }


    @Override
    public Integer type() {
        return TYPE;
    }

    @Override
    public void show(BaseView... views) {
        views[0].changeIsVisible(workingHours);
    }
}
