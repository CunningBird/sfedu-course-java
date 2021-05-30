package com.cunningbird;

import java.util.Objects;

public class Document {

    private String name;

    private String text;

    public Document(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return name.equals(document.name) && text.equals(document.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text);
    }
}
