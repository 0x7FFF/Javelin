package com.smakhorin.easycodeandroidtask.main.data.pets;


import com.smakhorin.easycodeandroidtask.main.domain.ImageDecoder;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDateFormatter;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDateParser;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.PetUi;

import java.io.Serializable;

public interface Pets {

    <T> T map(Mapper<T> mapper);

    class Empty implements Serializable, Pets {

        @Override
        public <T> T map(Mapper<T> mapper) {
            return null;
        }
    }

    class Base implements Serializable, Pets {
        private final String imageUrl;
        private final String title;
        private final String contentUrl;
        private final String dateAdded;

        public Base(String imageUrl, String title, String contentUrl, String dateAdded) {
            this.imageUrl = imageUrl;
            this.title = title;
            this.contentUrl = contentUrl;
            this.dateAdded = dateAdded;
        }

        @Override
        public <T> T map(Mapper<T> mapper) {
            return mapper.map(imageUrl, title, contentUrl, dateAdded);
        }
    }

    interface Mapper<T> {
        T map(String imageUrl, String title, String contentUrl, String dateAdded);

        class Base implements Mapper<PetUi> {

            private final PetsDateFormatter petsDateFormatter;

            private final PetsDateParser petsDateParser;

            private final ImageDecoder imageDecoder;


            public Base(PetsDateFormatter petsDateFormatter, PetsDateParser petsDateParser, ImageDecoder imageDecoder) {
                this.petsDateFormatter = petsDateFormatter;
                this.petsDateParser = petsDateParser;
                this.imageDecoder = imageDecoder;
            }

            @Override
            public PetUi map(String imageUrl, String title, String contentUrl, String dateAdded) {
                return new PetUi(
                    imageDecoder.decodeImage(imageUrl).createBitmap(),
                    title,
                    petsDateFormatter.format(petsDateParser.convert(dateAdded)),
                    contentUrl
                );
            }
        }
    }
}
