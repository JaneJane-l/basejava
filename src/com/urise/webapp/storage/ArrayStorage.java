package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    private static final int STORAGE_LIMIT = 10000;

    Resume[] storage = new Resume[STORAGE_LIMIT];

    int size = 0;


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
                System.out.println("Resume " + r.getUuid() + " is already exist");
            } else {

                //if (r != null) {
                //for (int i = 0; i < storage.length - 1; i++) {
                //  if (storage[i].getUuid().equals(r.getUuid())) {
                // storage [i] = r;
                //}
                storage[index] = r;
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
        if (index != -1) {
            System.out.println("Resume " + r.getUuid() + " is already exist");
        } else if (size == storage.length) {
            System.out.println("Storage is overflow");
        } else {
            storage[size] = r;
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

    public Resume get(String uuid) {
        int index = getIndex(uuid);
            if (index == -1) {
                System.out.println("Resume "+uuid+ " not exist");
                return null;
            }
            return storage[index];

        }


        //return null;
    //}

    public void delete(String uuid) {
        //if (uuid!=null) {
            int index = getIndex(uuid);
            if (index == -1) {
                System.out.println("ERROR");
            }
            else {
                //if (uuid.equals(storage[index].getUuid())) {
                    storage[index] = storage[size - 1];
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
  //  }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
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



    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                return i;
                }
        }
        return -1;
        }
    }
