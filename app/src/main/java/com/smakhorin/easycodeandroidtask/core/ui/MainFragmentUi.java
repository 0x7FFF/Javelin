package com.smakhorin.easycodeandroidtask.core.ui;

import androidx.annotation.NonNull;

import com.smakhorin.easycodeandroidtask.core.Mapper;

import java.util.List;

public interface MainFragmentUi extends Mapper.Unit<Mapper.Unit<List<ItemUi>>> {

    List<ItemUi> getList();

    class Base implements MainFragmentUi {
        private final List<ItemUi> list;

        public Base(List<ItemUi> list) {
            this.list = list;
        }

        @Override
        public Void map(@NonNull Unit<List<ItemUi>> data) {
            return data.map(list);
        }

        @Override
        public List<ItemUi> getList() {
            return list;
        }
    }
}
