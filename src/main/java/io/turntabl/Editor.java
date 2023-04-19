package io.turntabl;

import java.util.ArrayList;
import java.util.Stack;

/**
 *  the care taker
 */
public class Editor {
    Stack<Memento> mementoStack = new Stack<>();
    Stack<Memento> redoStack = new Stack<>();

    /**
     * add new memento
     * @param memento - the memento to add
     */
    public void addMemento(Memento memento){
        //savedMementoList.add(memento);
        mementoStack.push(memento);
    }

    /**
     *
     * @param index - get an item from  memento
     * @return  - returns an instance of the memento
     */
    public Memento getMemento(int index){
        return mementoStack.get(index);
    }
}