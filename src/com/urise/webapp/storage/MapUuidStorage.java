package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String>{

    private Map<String, Resume> mapUuid = new HashMap<>();


    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        mapUuid.put( uuid, r);
    }

    @Override
    protected boolean isExist(String uuid) {

        return mapUuid.containsKey( uuid);
    }


    @Override
    protected void doSave(Resume r, String uuid) {
        mapUuid.put( uuid, r);
    }

    @Override
    protected void doDelete(String uuid) {
        mapUuid.remove(uuid);
    }

    @Override
    protected Resume doGet(String uuid) {

        return mapUuid.get(uuid);
    }

    @Override
    public void clear() {
        mapUuid.clear();

    }

    @Override
    public List<Resume> doCopyAll() {

        return new ArrayList<>(mapUuid.values());
    }

   // @Override
    //public Resume[] getAll() {
     //   return new Resume[0];
  //  }

    @Override
    public int size() {

        return mapUuid.size();
    }
}
