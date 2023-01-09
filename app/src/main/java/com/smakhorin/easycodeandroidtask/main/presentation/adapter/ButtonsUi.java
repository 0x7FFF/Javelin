package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import com.smakhorin.easycodeandroidtask.core.ui.BaseView;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;

public class ButtonsUi extends ItemUi.Static {

    private final Boolean[] buttons;
    private static final Integer TYPE = 1;

    public ButtonsUi(Boolean isShowCall, Boolean isShowChat) {
        buttons = new Boolean[2];
        buttons[0] = isShowChat;
        buttons[1] = isShowCall;
    }

    @Override
    public Integer type() {
        return TYPE;
    }

    @Override
    public void show(BaseView... views) {
        for (int i = 0; i < buttons.length; i++) {
            views[i].changeIsVisible(buttons[i]);
        }
    }

}
