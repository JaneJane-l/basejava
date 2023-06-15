package com.urise.webapp.model;

import java.util.Objects;

public class TextSection extends Section {
    private static final long serialVersionUID = 1L;

    private String content;

    public TextSection() {
    }

    public TextSection(String content) {
        Objects.requireNonNull(content, "content must not be null");
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextSection)) return false;

        TextSection that = (TextSection) o;

        return getContent().equals(that.getContent());
    }

    @Override
    public int hashCode() {
        return getContent().hashCode();
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }


}
