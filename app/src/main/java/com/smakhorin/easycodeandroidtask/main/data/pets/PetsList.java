package com.smakhorin.easycodeandroidtask.main.data.pets;

import com.smakhorin.easycodeandroidtask.main.domain.ImageDownloader;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface PetsList {
    <T> T map(Mapper<T> mapper);

    class Empty implements PetsList {

        @Override
        public <T> T map(Mapper<T> mapper) {
            return mapper.map(new ArrayList<>());
        }
    }

    class Base implements Serializable, PetsList {
        private final List<Pets> petsList;

        public Base(List<Pets> petsList) {
            this.petsList = petsList;
        }

        @Override
        public <T> T map(Mapper<T> mapper) {
            return mapper.map(petsList);
        }
    }

    interface Mapper<T> {
        T map(List<Pets> pets);

        class Base implements Mapper<PetsDomain> {
            @Override
            public PetsDomain map(List<Pets> pets) {
                return new PetsDomain.Base(pets);
            }
        }
    }
}
