package io.turntabl;

public class Memento {
    private String article;

    public Memento(String article) {
        this.article = article;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}