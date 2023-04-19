package io.turntabl;

import java.util.ArrayList;
import java.util.Stack;

public class Caretaker {
    ArrayList<Memento> savedArticles = new ArrayList<>();

    public void addMemento(Memento memento){
        savedArticles.add(memento);
    }

    public Memento getMemento(int index){
        return savedArticles.get(index);
    }
}