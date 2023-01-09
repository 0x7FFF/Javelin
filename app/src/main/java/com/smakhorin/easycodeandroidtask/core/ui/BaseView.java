package com.smakhorin.easycodeandroidtask.core.ui;

import android.graphics.Bitmap;
import android.view.View;

import androidx.annotation.DrawableRes;

public interface BaseView {
    void show(CharSequence text);
    void show(Integer textId);
    void loadImage(String url);
    void show(Bitmap image);
    void showImageResource(@DrawableRes Integer id);
    void enable(Boolean isEnabled);
    void check(Boolean isChecked);
    void handleClick(View.OnClickListener listener);
    void changeIsVisible(Boolean isVisible);

}

