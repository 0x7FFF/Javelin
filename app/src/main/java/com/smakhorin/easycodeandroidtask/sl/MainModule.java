package com.smakhorin.easycodeandroidtask.sl;

import com.smakhorin.easycodeandroidtask.HandleUiError;
import com.smakhorin.easycodeandroidtask.core.module.Module;
import com.smakhorin.easycodeandroidtask.main.data.DateGenerator;
import com.smakhorin.easycodeandroidtask.main.data.config.Config;
import com.smakhorin.easycodeandroidtask.main.data.config.ConfigDataSource;
import com.smakhorin.easycodeandroidtask.main.data.config.ConfigRepository;
import com.smakhorin.easycodeandroidtask.main.data.StringConcatenator;
import com.smakhorin.easycodeandroidtask.main.data.StringSplitter;
import com.smakhorin.easycodeandroidtask.main.data.pets.PetsDataSource;
import com.smakhorin.easycodeandroidtask.main.data.pets.PetsList;
import com.smakhorin.easycodeandroidtask.main.data.pets.PetsRepository;
import com.smakhorin.easycodeandroidtask.main.domain.ConfigTimeIntervalParser;
import com.smakhorin.easycodeandroidtask.main.data.TimeIntervalNow;
import com.smakhorin.easycodeandroidtask.main.domain.ConfigDomain;
import com.smakhorin.easycodeandroidtask.main.domain.ImageDecoder;
import com.smakhorin.easycodeandroidtask.main.domain.ImageDownloader;
import com.smakhorin.easycodeandroidtask.main.domain.MainInteractor;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDateFormatter;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDateParser;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDomain;
import com.smakhorin.easycodeandroidtask.main.presentation.MainCommunication;
import com.smakhorin.easycodeandroidtask.main.presentation.MainViewModel;

public class MainModule implements Module<MainViewModel>, ProvideTimeIntervalParser, ProvideTimeIntervalNow {
    private final CoreModule coreModule;
    private final ConfigDataSource configDataSource;

    private final ConfigTimeIntervalParser configTimeIntervalParser;

    private final TimeIntervalNow timeIntervalNow;

    private final HandleUiError handleError;

    private final PetsDataSource petsDataSource;

    public MainModule(CoreModule coreModule, ConfigDataSource configDataSource, PetsDataSource petsDataSource) {
        this.coreModule = coreModule;
        this.configDataSource = configDataSource;
        handleError = new HandleUiError(coreModule, coreModule.provideGlobalErrorCommunication());
        this.petsDataSource = petsDataSource;
        timeIntervalNow = new TimeIntervalNow.Base();
        configTimeIntervalParser = new ConfigTimeIntervalParser.Base(
                new StringSplitter.Base(),
                new StringConcatenator.Base(),
                new DateGenerator.Base()
        );
    }
    @Override
    public MainViewModel viewModel() {
        ConfigRepository configRepository = new ConfigRepository.Base(configDataSource, new Config.Mapper.Base());
        PetsRepository petsRepository = new PetsRepository.Base(petsDataSource, new PetsList.Mapper.Base());


        return new MainViewModel(
                new MainCommunication.Base(),
                coreModule.provideCanGoBack(),
                new MainInteractor.Base(
                    handleError,
                    configRepository,
                    new ConfigDomain.Mapper.Base(configDataSource, configTimeIntervalParser, timeIntervalNow),
                    petsRepository,
                    new PetsDomain.Mapper.Base(
                            new PetsDateParser.Base(),
                            new PetsDateFormatter.Base(),
                            new ImageDecoder.Pets(),
                            new ImageDownloader.Base()
                    )
                ),
                coreModule.provideProgressCommunication()
        );
    }

    @Override
    public ConfigTimeIntervalParser provideTimeIntervalParser() {
        return configTimeIntervalParser;
    }

    @Override
    public TimeIntervalNow provideTimeIntervalNow() {
        return timeIntervalNow;
    }
}

interface ProvideTimeIntervalParser {
    ConfigTimeIntervalParser provideTimeIntervalParser();
}

interface ProvideTimeIntervalNow {
    TimeIntervalNow provideTimeIntervalNow();
}
