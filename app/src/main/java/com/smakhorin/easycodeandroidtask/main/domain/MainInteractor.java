package com.smakhorin.easycodeandroidtask.main.domain;

import com.smakhorin.easycodeandroidtask.core.Callback0;
import com.smakhorin.easycodeandroidtask.core.Callback1;
import com.smakhorin.easycodeandroidtask.core.data.HandleError;
import com.smakhorin.easycodeandroidtask.core.ui.MainUi;
import com.smakhorin.easycodeandroidtask.main.data.config.ConfigRepository;
import com.smakhorin.easycodeandroidtask.main.data.pets.PetsRepository;

import java.util.concurrent.Callable;

public interface MainInteractor {

    void localSettings(
        Callback1<MainUi> successful
    );

    void localPets(
        Callback1<MainUi> succsessful
    );

    class Base extends Interactor.Abstract implements MainInteractor {

        private final ConfigRepository configRepository;
        private final ConfigDomain.Mapper<MainUi> configMapper;

        private final PetsRepository petsRepository;

        private final PetsDomain.Mapper<MainUi> petsMapper;


        public Base(HandleError handleError, ConfigRepository configRepository, ConfigDomain.Mapper<MainUi> configMapper, PetsRepository petsRepository, PetsDomain.Mapper<MainUi> petsMapper) {
            super(handleError);
            this.configRepository = configRepository;
            this.configMapper = configMapper;
            this.petsRepository = petsRepository;
            this.petsMapper = petsMapper;
        }

        @Override
        public void localSettings(Callback1<MainUi> successful) {
            execute(
                successful,
                () -> configRepository.config().map(configMapper)
            );
        }

        @Override
        public void localPets(Callback1<MainUi> successful) {
            execute(
                successful,
                () -> petsRepository.pets().map(petsMapper)
            );
        }

    }
}
