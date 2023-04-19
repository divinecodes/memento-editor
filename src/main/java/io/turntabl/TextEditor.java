package io.turntabl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame{

    private JButton saveButton, undoButton, redoButton;
    private JTextArea editorTextArea = new JTextArea(50,60);
    private Editor editor = new Editor();
    private EditorData editorData = new EditorData();
    int savedFiles, currentTextIndex = 0;

    public static void main(String[] args) {

        new TextEditor();
    }

    public TextEditor() {
        this.setSize(750,780);
        this.setTitle("Memento Editor X");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setUpWidgets();
    }

    private void setUpWidgets()
    {
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Untitled Text"));
        jPanel.add(editorTextArea);

        ButtonListener saveListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();
        ButtonListener undoListener = new ButtonListener();

        saveButton = new JButton("Save");
        saveButton.addActionListener(saveListener);

        redoButton = new JButton("Redo");
        redoButton.addActionListener(redoListener);

        undoButton = new JButton("Undo");
        undoButton.addActionListener(undoListener);

        jPanel.add(saveButton);
        jPanel.add(redoButton);
        jPanel.add(undoButton);

        this.add(jPanel);
        this.setVisible(true);
    }

    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){

            if(event.getSource() == saveButton){
                saveAction();
            } else if(event.getSource() == undoButton) {
                undoAction();
            } else {
                redoAction();
            }
        }

        /**
         * save action
         */
        public void saveAction(){
            String inputText = editorTextArea.getText();
            editorData.set(inputText);
            editor.addMemento(editorData.storeInMemento());

            savedFiles++;
            currentTextIndex++;

            System.out.println("Save Files: "+savedFiles);

            undoButton.setEnabled(true); //enable the undo button
        }

        /**
         * perform undo
         */
        public void undoAction() {
            if(currentTextIndex >= 1){
                currentTextIndex--;

                String restoredText = editorData.restoreFromMemento(
                        editor.getMemento(currentTextIndex)
                );

                editorTextArea.setText(restoredText);

                redoButton.setEnabled(true);
            } else {
                undoButton.setEnabled(false);
            }
        }

        /**
         *  perform redo
         */
        public void redoAction() {
            if((savedFiles -1 ) > currentTextIndex){ //
                currentTextIndex++;

                String restoredText = editorData.restoreFromMemento(
                        editor.getMemento(currentTextIndex)
                );

                editorTextArea.setText(restoredText);
                undoButton.setEnabled(false);

            } else {
                redoButton.setEnabled(false);
            }
        }
    }
}