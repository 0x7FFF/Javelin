package com.smakhorin.easycodeandroidtask.main.data.pets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.graphics.Bitmap;

import com.smakhorin.easycodeandroidtask.core.domain.BitmapWrapper;
import com.smakhorin.easycodeandroidtask.main.domain.ImageDecoder;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDateFormatter;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDateParser;
import com.smakhorin.easycodeandroidtask.main.presentation.adapter.PetUi;

import org.junit.Test;

import java.util.Date;

public class PetsMapperTest {
    @Test
    public void testMapper() {
        PetUi expected = new PetUi(
            null,
            "title",
            "formatted date",
            "content url"
        );

        PetsDateFormatter petsDateFormatter = date -> "formatted date";
        PetsDateParser petsDateParser = dateString -> new Date();
        ImageDecoder imageDecoder = imageUrl -> new BitmapWrapper.Fake();

        Pets.Mapper.Base mapper = new Pets.Mapper.Base(petsDateFormatter, petsDateParser, imageDecoder);

        PetUi result = mapper.map("image url", "title", "content url", "date added");

        assertEquals(expected, result);
    }
}

