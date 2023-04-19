package io.turntabl;

// The originator
public class EditorData {
    private String text;

    /**
     * set a new text
     * @param text - text to save
     */
    public void set(String text){
        System.out.println("From Originator: Current Version:\n"+text+"\n");

        this.text = text;
    }

    /**
     * store memento
     * @return - returns a new memento
     */
    public Memento storeInMemento(){
        System.out.println("From Originator: Saving to Memento");

        return new Memento(text);
    }

    /**
     * restore memento
     * @param memento - memento to restore
     * @return - returns the text to restore
     */
    public String restoreFromMemento(Memento memento){
        text = memento.getText();

        System.out.println("From Originator: Previous Text Saved in Memento\n"+ text +"\n");

        return text;
    }
}