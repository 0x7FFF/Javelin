package com.smakhorin.easycodeandroidtask.core.domain;

import android.graphics.Bitmap;

public interface BitmapWrapper {
    Bitmap createBitmap();

    abstract class Abstract implements BitmapWrapper {
        @Override
        public Bitmap createBitmap() {
            return null;
        }
    }

    class Base extends Abstract {
        private final Bitmap bitmap;

        public Base(Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        @Override
        public Bitmap createBitmap() {
            return bitmap;
        }
    }

    class Fake extends Abstract {}
}
