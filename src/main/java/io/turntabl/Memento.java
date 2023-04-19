package io.turntabl;

public class Memento {
    private String text;

    public Memento(String article) {
        this.text = article;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}