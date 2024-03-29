package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;



public class ListSection extends Section {
    private static final long serialVersionUID = 1L;

    private  List<String> items;



    public ListSection(String...items){
        this(Arrays.asList(items));

    }
    public ListSection(List<String> items) {
        Objects.requireNonNull(items, "items must not be null");
        this.items = items;
    }

    public ListSection() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListSection)) return false;

        ListSection that = (ListSection) o;

        return getItems().equals(that.getItems());
    }

    @Override
    public int hashCode() {
        return getItems().hashCode();
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
