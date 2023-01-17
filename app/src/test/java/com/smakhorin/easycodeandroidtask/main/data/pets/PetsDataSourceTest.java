package com.smakhorin.easycodeandroidtask.main.data.pets;

import static org.junit.Assert.*;

import com.smakhorin.easycodeandroidtask.core.data.HandleError;
import com.smakhorin.easycodeandroidtask.core.data.TestException;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetsDataSourceTest {
    private final HandleError handleError = new HandleError.Fake();
    private final PetsDataSource petsDataSource = new PetsDataSource.Fake(handleError);
    private static final int EMPTY_FILE_RAW_ID = 0;
    private static final int NOT_EMPTY_FILE_RAW_ID = 1;
    private static final int INVALID_FILE_RAW_ID = 2;

    @Test
    public void testLatestData_success_emptyList() throws Exception {
        PetsList expected = new PetsList.Base(new ArrayList<>());

        PetsList result = petsDataSource.latestData(EMPTY_FILE_RAW_ID);
        assertEquals(expected, result);
    }

    @Test
    public void testLatestData_success_three_item_list() throws Exception {
        List<Pet> pets = Arrays.asList(
            new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2001"),
            new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2002"),
            new Pet.Base("example.com", "Dog", "wikipedia.org/dog", "01-01-2003")
        );
        PetsList expected = new PetsList.Base(pets);

        PetsList result = petsDataSource.latestData(NOT_EMPTY_FILE_RAW_ID);
        assertEquals(expected, result);
    }

    @Test(expected = TestException.class)
    public void testLatestData_error() throws Exception {
        PetsList result = petsDataSource.latestData(INVALID_FILE_RAW_ID);
        assertNull(result);
    }
}
