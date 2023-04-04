package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File>{
    private File directory;

    protected AbstractFileStorage(File directory){
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()){
            throw new IllegalArgumentException(directory.getAbsolutePath()+"is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()){
            throw new IllegalArgumentException(directory.getAbsolutePath()+"is not readable/writeable");
        }
        this.directory = directory;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try{
            doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO error", r.getUuid(), e);
        }

    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(r, file);


    }

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    @Override
    protected void doDelete(File file) {
        if (! file.delete()){
            throw new StorageException("file delete error", file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return doRead(new BufferedInputStream(new FileInputStream(file)));
        }
        catch (IOException e){
            throw new StorageException("File read error ", file.getName());
        }


    }

    protected abstract Resume doRead(InputStream is) throws IOException;

    @Override
    protected List<Resume> doCopyAll() {
        File[] file = directory.listFiles();
        if (file == null){
            throw new StorageException("doCopyAll is error ");
        }
        else {
            List<Resume> lists = new ArrayList<>();
            for ( File files : file){
                lists.add(doGet(files));
            }
            return lists;
        }

    }



    @Override


    public void clear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                doDelete(file);
            }
        }

    }

    @Override
    public int size() {
        String[] list =directory.list();
        if (list == null ) {
            throw  new StorageException("Directory read error");
        }
        return list.length;
    }
}
