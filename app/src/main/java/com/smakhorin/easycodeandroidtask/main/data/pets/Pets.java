package com.smakhorin.easycodeandroidtask.main.data.pets;


import android.graphics.Bitmap;

import com.smakhorin.easycodeandroidtask.main.domain.ImageDecoder;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDateFormatter;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDateParser;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.PetUi;

import java.io.Serializable;

public interface Pets {

    String getImageUrl();

    <T> T map(Mapper<T> mapper, Bitmap bitmap);

    <T> T oldMap(Mapper<T> mapper);

    class Empty implements Serializable, Pets {

        @Override
        public String getImageUrl() {
            return null;
        }

        @Override
        public <T> T map(Mapper<T> mapper, Bitmap bitmap) {
            return mapper.update(null, null, null, null);
        }

        @Override
        public <T> T oldMap(Mapper<T> mapper) {
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
        public String getImageUrl() {
            return imageUrl;
        }

        @Override
        public <T> T map(Mapper<T> mapper, Bitmap bitmap) {
            return mapper.update(bitmap, title, contentUrl, dateAdded);
        }

        @Override
        public <T> T oldMap(Mapper<T> mapper) {
            return mapper.map(imageUrl, title, contentUrl, dateAdded);
        }
    }

    interface Mapper<T> {
        T map(String imageUrl, String title, String contentUrl, String dateAdded);

        T update(Bitmap image, String title, String contentUrl, String dateAdded);

        abstract class Abstract implements Mapper<PetUi> {
            @Override
            public PetUi map(String imageUrl, String title, String contentUrl, String dateAdded) {
                return null;
            }

            @Override
            public PetUi update(Bitmap image, String title, String contentUrl, String dateAdded) {
                return null;
            }
        }

        class Base extends Abstract {

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
                    imageDecoder.decodeImage(imageUrl),
                    title,
                    contentUrl,
                    petsDateFormatter.format(petsDateParser.convert(dateAdded))
                );
            }

            @Override
            public PetUi update(Bitmap image, String title, String contentUrl, String dateAdded) {
                return new PetUi(
                    image,
                    title,
                    contentUrl,
                    petsDateFormatter.format(petsDateParser.convert(dateAdded))
                );
            }
        }
    }
}
