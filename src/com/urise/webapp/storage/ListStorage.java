package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> list = new ArrayList<>();

    @Override
    public void clear() {
        list.clear();
    }




    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        list.set(searchKey, r);

    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (uuid.equals(list.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        list.add(r);

    }

    @Override
    protected void doDelete(Integer searchKey) {
        list.remove(( searchKey).intValue());

    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return list.get((Integer) searchKey);
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(list);
    }

//    @Override
//    public void update(Resume r) {
//        int index = getIndexList(r.getUuid());
//        if (index<0){
//            throw new NotExistStorageException(r.getUuid());
//        }
//        list.add(index, r);
//    }

//    @Override
//    public void save(Resume r) {
//        for (Resume i : list) {
//            if (r.getUuid().equals(i.getUuid())){
//                throw new ExistStorageException(r.getUuid());
//            }
//        }
//        list.add(r);
//    }

    //  @Override
    //public Resume get(String uuid) {
//        int index = getIndexList(uuid);
//        if (index<0){
//            throw new NotExistStorageException(uuid);
//        }
//        return list.get(index);
//    }

//    @Override
//    public void delete(String uuid) {
//        if (getIndexList(uuid)<0){
//            throw new NotExistStorageException(uuid);
//        }
//        else {
//            list.remove(getIndexList(uuid));
//        }
//    }


   // public Resume[] getAll() {
     //   Resume[] array = new Resume[list.size()];

       // return   list.toArray(array);


    //}




    @Override
    public int size() {
        return list.size();
    }


//    protected int getIndexList(String uuid) {
//        for (int i = 0; i < list.size(); i++) {
//            if (uuid.equals(list.get(i).getUuid())) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
