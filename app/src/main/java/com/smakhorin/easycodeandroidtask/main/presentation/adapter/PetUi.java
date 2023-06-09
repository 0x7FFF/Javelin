package com.smakhorin.easycodeandroidtask.main.presentation.adapter;

import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import com.smakhorin.easycodeandroidtask.core.ui.BaseView;
import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;

import java.util.Objects;

public class PetUi implements ItemUi {
    private final Bitmap image;
    private final String name;
    private final String date;
    private final String url;

    private static final Integer TYPE = 3;

    public PetUi(Bitmap image, String name, String date, String url) {
        this.image = image;
        this.name = name;
        this.date = date;
        this.url = url;
    }

    @Override
    public Integer type() {
        return TYPE;
    }

    @Override
    public void show(BaseView... views) {
        views[0].show(image);
        views[1].show(name);
        views[2].show(url);
    }

    @Override
    public String id() {
        return TYPE.toString();
    }

    @Override
    public String content() {
        return url;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        PetUi otherClass = (PetUi) other;
        return Objects.equals(image, otherClass.image) &&
            Objects.equals(name, otherClass.name) &&
            Objects.equals(date, otherClass.date) &&
            Objects.equals(url, otherClass.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, name, date, url);
    }
}
