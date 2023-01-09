package com.smakhorin.easycodeandroidtask.main.domain;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.URL;

public interface ImageDecoder {
    Bitmap decodeImage(String imageUrl);

    class Pets implements ImageDecoder {

        @Override
        public Bitmap decodeImage(String imageUrl) {
            try {
                InputStream inputStream = new URL(imageUrl).openStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                return bitmap;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
}
