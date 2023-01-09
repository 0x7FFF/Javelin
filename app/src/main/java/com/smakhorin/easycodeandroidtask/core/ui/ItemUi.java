package com.smakhorin.easycodeandroidtask.core.ui;

public interface ItemUi {
    Integer type();
    void show(BaseView... views);

    String id();

    String content();

    abstract class Static implements ItemUi {
        @Override
        public String id() {
            return type().toString();
        }

        @Override
        public String content() {
            return type().toString();
        }
    }
}
