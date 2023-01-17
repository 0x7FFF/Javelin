package com.smakhorin.easycodeandroidtask.main.data.pets;

import androidx.annotation.RawRes;

import com.smakhorin.easycodeandroidtask.core.domain.JSONWrapper;
import com.smakhorin.easycodeandroidtask.main.data.FileReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public interface PetsService {
    PetsList data(@RawRes int fileRawId) throws IOException, JSONException;

    class Base implements PetsService {

        private final FileReader.Json jsonReader;

        public Base(FileReader.Json jsonReader) {
            this.jsonReader = jsonReader;
        }

        @Override
        public PetsList data(int fileRawId) throws IOException, JSONException {
            JSONWrapper rawData = jsonReader.readRawFile(fileRawId);
            JSONArray pets = rawData.getJSONArray("pets");
            pets.remove(pets.length()-1); // Eliminate null entry.
            ArrayList<Pet> result = new ArrayList<>(pets.length());

            for (int i = 0; i < pets.length(); i++) {
                JSONObject petObject = pets.getJSONObject(i);
                String imageUrl = petObject.getString("image_url");
                String title = petObject.getString("title");
                String contentUrl = petObject.getString("content_url");
                String dateAdded = petObject.getString("date_added");
                result.add(
                    new Pet.Base(imageUrl,title,contentUrl,dateAdded)
                );
            }
            return new PetsList.Base(result);
        }
    }
}
