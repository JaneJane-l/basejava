package com.urise.webapp.model;

import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;

    private final String fullName;

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "fullName must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");

        this.uuid = uuid;
        this.fullName = fullName;
    }


    public Resume(String fullName) {
        this.uuid = UUID.randomUUID().toString();
        this.fullName=fullName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;

        Resume resume = (Resume) o;

        if (!getUuid().equals(resume.getUuid())) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = getUuid().hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    public String getUuid() {
        return uuid;
    }

    

    @Override
    public String toString() {
        return uuid+ '(' + fullName+')';
    }

    @Override
    public int compareTo(Resume o) {
        int cmp =  fullName.compareTo(o.fullName);
        return cmp != 0? cmp:uuid.compareTo(o.uuid);

    }



}
