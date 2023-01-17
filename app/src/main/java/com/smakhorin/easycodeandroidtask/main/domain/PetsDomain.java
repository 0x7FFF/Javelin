package com.smakhorin.easycodeandroidtask.main.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.MainUi;
import com.smakhorin.easycodeandroidtask.main.data.pets.Pet;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.PetUi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface PetsDomain {

    <T> T map(Mapper<T> mapper);

    class Base implements PetsDomain {
        private final List<Pet> petList;

        public Base(List<Pet> petList) {
            this.petList = petList;
        }

        @Override
        public <T> T map(@NonNull Mapper<T> mapper) {
            return mapper.map(petList);
        }

        @Override
        public boolean equals(@Nullable Object other) {
            if (other == null || getClass() != other.getClass()) return false;
            PetsDomain.Base otherClass = (PetsDomain.Base) other;
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

        @Override
        public int hashCode() {
            return Objects.hash(petList);
        }
    }

    interface Mapper<T> {
        T map(List<Pet> petList);

        class Base implements Mapper<MainUi> {

            private final Pet.Mapper<PetUi> petsMapper;

            public Base(PetsDateParser petsDateParser, PetsDateFormatter petsDateFormatter, ImageDecoder imageDecoder) {
                petsMapper = new Pet.Mapper.Base(petsDateFormatter, petsDateParser, imageDecoder);
            }

            @Override
            public MainUi map(List<Pet> petList) {
                List<ItemUi> uiList = new ArrayList<>(petList.size());
                for (Pet pet : petList) {
                    uiList.add(pet.map(petsMapper));
                }
                return new MainUi.Base(uiList);
            }
        }
    }
}
