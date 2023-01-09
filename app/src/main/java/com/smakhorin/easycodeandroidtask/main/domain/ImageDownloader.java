package com.smakhorin.easycodeandroidtask.main.domain;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public interface ImageDownloader {
    List<Bitmap> downloadImages(List<String> imageUrls);

    class Base implements ImageDownloader {

        private static final int NUM_THREADS = 5;

        private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        @Override
        public List<Bitmap> downloadImages(List<String> imageUrls) {
            List<Future<Bitmap>> futures = new ArrayList<>();

            for (String url : imageUrls) {
                futures.add(executor.submit(new ImageDownloadTask(url)));
            }

            List<Bitmap> bitmaps = new ArrayList<>();
            for (Future<Bitmap> future : futures) {
                try {
                    bitmaps.add(future.get());
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return bitmaps;
        }

        private static class ImageDownloadTask implements Callable<Bitmap> {
            private final String url;

            public ImageDownloadTask(String url) {
                this.url = url;
            }

            @Override
            public Bitmap call() throws Exception {
                return BitmapFactory.decodeStream(new URL(url).openStream());
            }
        }
    }

}
