package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializer.StreamSerializer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;
    private String dir;
    private StreamSerializer streamSerializer;

    protected PathStorage(String dir, StreamSerializer streamSerializer) {
        Objects.requireNonNull(dir, "directory must not be null");

        directory = Paths.get(dir);

        this.streamSerializer=streamSerializer;

        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "is not directory or is not writable");
        }
        this.directory = directory;
    }



    @Override
    protected Path getSearchKey(String uuid) {
//        return new Path(directory, uuid);
        //return Paths.get(dir, uuid);
        return directory.resolve(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Path path) {

        try {
            streamSerializer.doWrite(r, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("File write error ", r.getUuid(), e);
        }

    }

    @Override
    protected boolean isExist(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            Files.createFile(path);

        } catch (IOException e) {
            throw new StorageException("Path create error"+path, getFileName(path), e);
        }
        doUpdate(r, path );

    }



    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", getFileName(path), e);
        }
    }


    protected Resume doGet(Path path) {
                try {
            return streamSerializer.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("File read error ", getFileName(path), e);
        }


    }



    @Override
    protected List<Resume> doCopyAll() {
        return getFilesList().map(this::doGet).collect(Collectors.toList());

    }


    @Override
    public void clear() {
       getFilesList().forEach(this::doDelete);

    }




    @Override
    public int size() {
        return (int) getFilesList().count();
    }


    private Stream<Path> getFilesList() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Directory read error", e);
        }
    }

    private String getFileName( Path path){
        return path.getFileName().toString();

    }





}
