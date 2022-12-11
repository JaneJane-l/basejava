package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;

    public Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

    public int size() {

        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);


        // for (int i = 0; i < storage.length - 1; i++) {
        //  storage[i] = null;
        //}
        size = 0;
    }




    public void update(Resume r) {
        if (size <= STORAGE_LIMIT) {
            int index = getIndex(r.getUuid());
            if (index == -1) {
                throw new NotExistStorageException(r.getUuid());
            } else {
                storage[index] = r;
                //if (r != null) {
                //for (int i = 0; i < storage.length - 1; i++) {
                //  if (storage[i].getUuid().equals(r.getUuid())) {
                // storage [i] = r;
                //}
                // }
            }
        }
        //else {
        //      System.out.print("You print null");
        //}
    }
    //}



    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            throw new ExistStorageException(r.getUuid());
        } else if (size == storage.length) {
            throw new StorageException( "Storage is overflow", r.getUuid());
        } else {
            insertElement(r, index);
            size++;
        }


        //if (size <= 10000) {
        //  if (r != null) {
        //    storage[size] = r;
        //  size++;
        //}
        //else {
        //  System.out.print("You print null");
        //}


        //}
    }
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
        // Resume[] getAllStorage = new Resume[size];
        // for (int i =0; i< size; i++){
        //  if (storage [i] != null){
        //       getAllStorage[i]=storage[i];
        //   }
        //  }

        // return  getAllStorage;

    }
    public void delete(String uuid) {
        //if (uuid!=null) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        else {
            //if (uuid.equals(storage[index].getUuid())) {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
            //}


        }
        //for (int i=0; i< storage.length-1; i++) {
        //  if (storage[i] != null) {
        //    if (uuid.equals(storage[i].getUuid())) {
        //      storage[i] = storage[size-1];
        //    storage[size-1]=null;
        //  size--;
        //}
        //}

        //}
    }



    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);

        }
        return storage[index];

    }





    //  }

    protected abstract int getIndex(String uuid);
    protected abstract void fillDeletedElement(int index);
    protected abstract void insertElement(Resume r, int index);






}
