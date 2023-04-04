package com.urise.webapp.model;

import java.io.Serializable;
import java.util.Objects;

public class Link implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String url;


    public Link(String name, String url) {
        Objects.requireNonNull(name, "must not be null");
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;
        Link link = (Link) o;
        return getName().equals(link.getName()) && Objects.equals(getUrl(), link.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUrl());
    }

    @Override
    public String toString() {
        return "Link{" + name + url +'}';
    }
}
