package io.turntabl;

import java.util.ArrayList;

/**
 *  the care taker
 */
public class Editor {
    ArrayList<Memento> savedMementoList = new ArrayList<>();

    /**
     * add new memento
     * @param memento - the memento to add
     */
    public void addMemento(Memento memento){
        savedMementoList.add(memento);
    }

    /**
     *
     * @param index - get an item from  memento
     * @return  - returns an instance of the memento
     */
    public Memento getMemento(int index){
        return savedMementoList.get(index);
    }
}