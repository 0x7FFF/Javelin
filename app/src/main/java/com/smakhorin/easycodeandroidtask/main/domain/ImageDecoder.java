package com.smakhorin.easycodeandroidtask.main.domain;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.smakhorin.easycodeandroidtask.core.domain.BitmapWrapper;

import java.io.InputStream;
import java.net.URL;

public interface ImageDecoder {
    BitmapWrapper decodeImage(String imageUrl);

    class Pets implements ImageDecoder {

        @Override
        public BitmapWrapper decodeImage(String imageUrl) {
            try {
                InputStream inputStream = new URL(imageUrl).openStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                return new BitmapWrapper.Base(bitmap);
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
}
