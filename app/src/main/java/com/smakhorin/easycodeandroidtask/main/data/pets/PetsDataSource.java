package com.smakhorin.easycodeandroidtask.main.data.pets;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.core.data.HandleError;
import com.smakhorin.easycodeandroidtask.main.data.DataSource;

public interface PetsDataSource {
    PetsList latestData(@RawRes int fileRawId) throws Exception;

    class Base extends DataSource.Abstract implements PetsDataSource {
        private final PetsService petsService;

        public Base(HandleError handleError, PetsService petsService) {
            super(handleError);
            this.petsService = petsService;
        }

        @Override
        public PetsList latestData(int fileRawId) throws Exception {
            return handle(() -> petsService.data(fileRawId));
        }
    }
}
