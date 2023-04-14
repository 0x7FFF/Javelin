package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import com.smakhorin.easycodeandroidtask.core.ui.BaseView;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.main.presentation.DisplayDialog;

public class ButtonsUi extends ItemUi.Static {

    private final Boolean[] buttons;
    private static final Integer TYPE = 1;

    private final Boolean isWithinWorkingHours;

    private final DisplayDialog displayDialog;

    public ButtonsUi(Boolean isShowCall, Boolean isShowChat, Boolean isWithinWorkingHours, DisplayDialog displayDialog) {
        this.displayDialog = displayDialog;
        this.isWithinWorkingHours = isWithinWorkingHours;
        this.buttons = new Boolean[2];
        this.buttons[0] = isShowChat;
        this.buttons[1] = isShowCall;
    }

    @Override
    public Integer type() {
        return TYPE;
    }

    @Override
    public void show(BaseView... views) {
        for (int i = 0; i < buttons.length; i++) {
            views[i].changeIsVisible(buttons[i]);
            views[i].handleClick(v -> displayDialog.show(isWithinWorkingHours));
        }
    }
}
