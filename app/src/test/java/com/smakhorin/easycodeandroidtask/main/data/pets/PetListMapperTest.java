package com.smakhorin.easycodeandroidtask.main.data.pets;

import static org.junit.Assert.assertEquals;

import com.smakhorin.easycodeandroidtask.main.domain.PetsDomain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PetListMapperTest {

    @Test
    public void testMapperEmpty() {
        PetsDomain expected = new PetsDomain.Base(new ArrayList<>());

        PetsList.Mapper<PetsDomain> mapper = new PetsList.Mapper.Base();
        List<Pet> pets = new ArrayList<>();
        PetsDomain petsDomain = mapper.map(pets);

        assertEquals(expected, petsDomain);
    }

    @Test
    public void testMapperSingle() {
        PetsDomain expected = new PetsDomain.Base(Collections.singletonList(new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2001")));

        PetsList.Mapper<PetsDomain> mapper = new PetsList.Mapper.Base();
        List<Pet> pets = Collections.singletonList(new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2001"));
        PetsDomain petsDomain = mapper.map(pets);

        assertEquals(expected, petsDomain);
    }

    @Test
    public void testMapperMultiple() {
        PetsDomain expected = new PetsDomain.Base(
            Arrays.asList(
                new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2001"),
                new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2002"),
                new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2003")
            )
        );

        PetsList.Mapper<PetsDomain> mapper = new PetsList.Mapper.Base();
        List<Pet> pets = Arrays.asList(
            new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2001"),
            new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2002"),
            new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2003")
        );
        PetsDomain petsDomain = mapper.map(pets);

        assertEquals(expected, petsDomain);
    }
}
