package com.smakhorin.easycodeandroidtask.main.data.pets;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.core.data.HandleError;
import com.smakhorin.easycodeandroidtask.core.data.TestException;
import com.smakhorin.easycodeandroidtask.main.data.DataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    final class Fake extends DataSource.Abstract implements PetsDataSource {

        Fake(HandleError handleError) {
            super(handleError);
        }

        @Override
        public PetsList latestData(int fileRawId) throws Exception {
            if (fileRawId == 0) {
                return new PetsList.Base(
                    new ArrayList<>()
                );
            }
            if (fileRawId == 1) {
                List<Pet> pets = Arrays.asList(
                    new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2001"),
                    new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2002"),
                    new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2003")
                );
                return new PetsList.Base(pets);
            }
            throw new TestException();
        }
    }
}
