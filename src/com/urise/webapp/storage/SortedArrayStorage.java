package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{





    protected void insertElement(Resume r, int index){
        int insertInd = - index - 1;
        System.arraycopy(storage, insertInd, storage, index, size-insertInd);
        storage[insertInd]=r;
    }



    protected void fillDeletedElement(int index){
       // for (int i = index; i<size-1; i++){
         //   storage[i]=storage[i+1];
        //}
        int numMoved = size-1-index;
        if (numMoved>0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }

    }


       @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);

        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
