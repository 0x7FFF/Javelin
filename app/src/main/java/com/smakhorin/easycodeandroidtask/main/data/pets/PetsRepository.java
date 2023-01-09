package com.smakhorin.easycodeandroidtask.main.data.pets;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDomain;

import java.util.List;

public interface PetsRepository {

    PetsDomain pets() throws Exception;

    class Base implements PetsRepository {

        @RawRes
        private final int petsRawResId = R.raw.pets;

        private final PetsDataSource petsDataSource;

        private final PetsList.Mapper<PetsDomain> mapper;

        public Base(PetsDataSource petsDataSource, PetsList.Mapper<PetsDomain> mapper) {
            this.petsDataSource = petsDataSource;
            this.mapper = mapper;
        }

        @Override
        public PetsDomain pets() throws Exception {
            return petsDataSource.latestData(petsRawResId).map(mapper);
        }
    }
}
