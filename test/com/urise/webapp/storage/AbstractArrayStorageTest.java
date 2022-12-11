package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_4 = "uuid4" ;
    private static final Resume RESUME_4 = new Resume(UUID_4);


    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3);


    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }



    @Before
    public void setUp()  throws Exception{

        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }


    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Assert.assertEquals(3, storage.size());

    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(RESUME_4, storage.get(RESUME_4.getUuid()));

    }

    @Test
    public void getAll() {
        Resume[] array = storage.getAll();
        Assert.assertEquals(3, array.length);
        Assert.assertEquals(RESUME_1, array [0]);
        Assert.assertEquals(RESUME_2, array [1]);
        Assert.assertEquals(RESUME_3, array [2]);

        }


    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test
    public void get() {
        Assert.assertEquals(RESUME_1, storage.get(RESUME_1.getUuid()));
        Assert.assertEquals(RESUME_2, storage.get(RESUME_2.getUuid()));
        Assert.assertEquals(RESUME_3, storage.get(RESUME_3.getUuid()));
    }
    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);

    }
    @Test
    public void saveOverflow(){
        try{
            for (int i=4; i<=AbstractArrayStorage.STORAGE_LIMIT+1; i++);
            storage.save(new Resume());
        }
        catch (StorageException e){
            Assert.fail();
        }

    }

    @Test
    public void getNotExist() {
        try {
            storage.get("dummy");
            Assert.fail("should not happen");
        } catch (NotExistStorageException e) {
           Assert.assertEquals("Resume dummy not exist", e.getMessage());
        }

    }
}