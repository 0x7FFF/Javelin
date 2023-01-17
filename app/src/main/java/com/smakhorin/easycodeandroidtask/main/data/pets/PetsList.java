package com.smakhorin.easycodeandroidtask.main.data.pets;

import androidx.annotation.Nullable;

import com.smakhorin.easycodeandroidtask.main.domain.PetsDomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface PetsList {
    <T> T map(Mapper<T> mapper);

    class Empty implements PetsList {

        @Override
        public <T> T map(Mapper<T> mapper) {
            return mapper.map(new ArrayList<>());
        }
    }

    class Base implements Serializable, PetsList {
        private final List<Pet> petList;

        public Base(List<Pet> petList) {
            this.petList = petList;
        }

        @Override
        public <T> T map(Mapper<T> mapper) {
            return mapper.map(petList);
        }

        @Override
        public int hashCode() {
            return Objects.hash(petList);
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == null || getClass() != other.getClass()) return false;
            PetsList.Base otherClass = (PetsList.Base) other;
            if (petList.size() != otherClass.petList.size()) return false;

            boolean ret = true;
            for (int i = 0; i < petList.size(); i++) {
                Pet pet = petList.get(i);
                Pet otherPet = otherClass.petList.get(i);
                if (!pet.equals(otherPet)) {
                    ret = false;
                    break;
                }
            }
            return ret;
        }
    }

    interface Mapper<T> {
        T map(List<Pet> pets);

        class Base implements Mapper<PetsDomain> {
            @Override
            public PetsDomain map(List<Pet> pets) {
                return new PetsDomain.Base(pets);
            }
        }
    }
}
