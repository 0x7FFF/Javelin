package com.smakhorin.easycodeandroidtask.main.data.pets;

import static org.junit.Assert.assertEquals;

import com.smakhorin.easycodeandroidtask.core.data.TestException;
import com.smakhorin.easycodeandroidtask.main.domain.PetsDomain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PetsRepositoryTest {

    List<Pet> pets = Arrays.asList(
        new Pet.Base("any","any","any","any"),
        new Pet.Base("any2","any2","any2","any2")
    );

    @Test
    public void testPets_success() throws Exception {
        PetsDomain expected = new PetsDomain.Base(pets);

        PetsDataSource petsDataSource = fileRawId -> new PetsList.Base(pets);
        PetsList.Mapper<PetsDomain> mapper = PetsDomain.Base::new;
        PetsRepository petsRepository = new PetsRepository.Base(petsDataSource, mapper);
        PetsDomain result = petsRepository.pets();

        assertEquals(expected, result);
    }

    @Test(expected = TestException.class)
    public void testPets_dataSourceError() throws Exception {
        PetsDataSource petsDataSource = fileRawId -> {
            throw new TestException();
        };
        PetsList.Mapper<PetsDomain> mapper = PetsDomain.Base::new;
        PetsRepository petsRepository = new PetsRepository.Base(petsDataSource, mapper);
        petsRepository.pets();
    }
}
