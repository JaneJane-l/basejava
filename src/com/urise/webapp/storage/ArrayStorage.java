package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    //private static final int STORAGE_LIMIT = 10000;

    //Resume[] storage = new Resume[STORAGE_LIMIT];




    /**
     * @return array, contains only Resumes in storage (without null)
     */


    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
                }
        }
        return -1;
        }


    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];

    }

    @Override
    protected void insertElement(Resume r, int index) {
        storage[size] = r;
    }



}
