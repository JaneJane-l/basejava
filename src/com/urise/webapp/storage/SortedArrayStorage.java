package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage{

  /*  private static class ResumeComparator implements Comparator<Resume>{

        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }*/

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    protected void insertElement(Resume r, int index){
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx]=r;
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
    protected Integer getSearchKey(String uuid) {
           Resume searchKey = new Resume(uuid, "dummy");
           return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
       }

}

