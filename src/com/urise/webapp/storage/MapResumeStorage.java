package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage<Resume> {

    HashMap<String, Resume> resumeHashMap = new LinkedHashMap<>();


    @Override
    public void clear() {

        resumeHashMap.clear();
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        resumeHashMap.put(r.getUuid(),r);

    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return resumeHashMap.get(uuid);
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        resumeHashMap.put(r.getUuid(), r);

    }

    @Override
    protected void doDelete(Resume resume) {
        resumeHashMap.remove((resume).getUuid());

    }

    @Override
    protected Resume doGet(Resume resume) {
        return resumeHashMap.get((resume).getUuid());
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<Resume>(resumeHashMap.values());
    }

    @Override
    public int size() {
        return resumeHashMap.size();
    }

//    @Override
//    public void update(Resume r) {
//            if (getKey(r.getUuid())==null) {
//                throw new NotExistStorageException(r.getUuid());
//            }
//
//        resumeHashMap.put(r.getUuid(), r);
//
//
//    }

//    @Override
//    public void save(Resume r) {
//            if (getKey(r.getUuid())!=null) {
//                throw new ExistStorageException(r.getUuid());
//            }
//        resumeHashMap.put(r.getUuid(), r);
//    }


//    @Override
//    public Resume get(String uuid) {
//        if (getKey(uuid)!=null)
//        {
//            throw new NotExistStorageException(uuid);
//            }
//
//        return resumeHashMap.get(uuid);
//
//
//    }

//    @Override
//    public void delete(String uuid) {
//        Resume r = resumeHashMap.get(uuid);
//        if (!uuid.equals(r.getUuid())) {
//            throw new NotExistStorageException(uuid);
//        } else {
//            resumeHashMap.remove(uuid);
//        }
//
//    }

//    @Override
//    public List<Resume> getAllSorted() {
//        return new ArrayList<>(resumeHashMap.values());
//        return Collections.emptyList();
//    }

    //  @Override
    //public Resume[] getAll() {
      //  Resume[] array = new Resume[resumeHashMap.size()];

        //Collection<Resume> entries = resumeHashMap.values();
        //return entries.toArray(array);
    //}





//    protected String getKey(String uuid) {
//        for (String i : resumeHashMap.keySet()) {
//            if (uuid.equals(i)) {
//                return i;
//            }
//        }
//        return null;
//
//    }
}
