package com.smakhorin.easycodeandroidtask.main.domain;

import com.smakhorin.easycodeandroidtask.core.callback.Callback1;
import com.smakhorin.easycodeandroidtask.core.data.HandleError;
import com.smakhorin.easycodeandroidtask.core.ui.MainFragmentUi;
import com.smakhorin.easycodeandroidtask.main.data.config.ConfigRepository;
import com.smakhorin.easycodeandroidtask.main.data.pets.PetsRepository;

public interface MainInteractor {

    void localSettings(
        Callback1<MainFragmentUi> successful
    );

    void localPets(
        Callback1<MainFragmentUi> succsessful
    );

    class Base extends Interactor.Abstract implements MainInteractor {

        private final ConfigRepository configRepository;
        private final ConfigDomain.Mapper<MainFragmentUi> configMapper;

        private final PetsRepository petsRepository;

        private final PetsDomain.Mapper<MainFragmentUi> petsMapper;


        public Base(HandleError handleError, ConfigRepository configRepository, ConfigDomain.Mapper<MainFragmentUi> configMapper, PetsRepository petsRepository, PetsDomain.Mapper<MainFragmentUi> petsMapper) {
            super(handleError);
            this.configRepository = configRepository;
            this.configMapper = configMapper;
            this.petsRepository = petsRepository;
            this.petsMapper = petsMapper;
        }

        @Override
        public void localSettings(Callback1<MainFragmentUi> successful) {
            execute(
                successful,
                () -> configRepository.config().map(configMapper)
            );
        }

        @Override
        public void localPets(Callback1<MainFragmentUi> successful) {
            execute(
                successful,
                () -> petsRepository.pets().map(petsMapper)
            );
        }

    }
}
