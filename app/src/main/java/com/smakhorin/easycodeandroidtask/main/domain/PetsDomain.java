package com.smakhorin.easycodeandroidtask.main.domain;

import androidx.annotation.NonNull;

import com.smakhorin.easycodeandroidtask.core.ui.ItemUi;
import com.smakhorin.easycodeandroidtask.core.ui.MainUi;
import com.smakhorin.easycodeandroidtask.main.data.pets.Pets;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.PetUi;

import java.util.ArrayList;
import java.util.List;

public interface PetsDomain {

    <T> T map(Mapper<T> mapper);

    class Base implements PetsDomain {
        private final List<Pets> petsList;

        public Base(List<Pets> petsList) {
            this.petsList = petsList;
        }

        @Override
        public <T> T map(@NonNull Mapper<T> mapper) {
            return mapper.map(petsList);
        }
    }

    interface Mapper<T> {
        T map(List<Pets> petsList);

        class Base implements Mapper<MainUi> {

            private final PetsDateParser petsDateParser;

            private final PetsDateFormatter petsDateFormatter;

            private final ImageDecoder petsImageDecoder;

            private final Pets.Mapper<PetUi> petsMapper;

            public Base(PetsDateParser petsDateParser, PetsDateFormatter petsDateFormatter, ImageDecoder petsImageDecoder) {
                this.petsDateParser = petsDateParser;
                this.petsDateFormatter = petsDateFormatter;
                this.petsImageDecoder = petsImageDecoder;
                ImageDecoder imageDecoder = new ImageDecoder.Pets();
                petsMapper = new Pets.Mapper.Base(petsDateFormatter, petsDateParser, imageDecoder);
            }

            @Override
            public MainUi map(List<Pets> petsList) {
                List<ItemUi> uiList = new ArrayList<>(petsList.size());
                for (Pets pets : petsList) {
                    uiList.add(pets.map(petsMapper));
                }
                return new MainUi.Base(uiList);
            }
        }
    }
}
