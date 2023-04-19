package io.turntabl;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame{

    private JButton saveButton, undoButton, redoButton;
    private JTextArea textArea = new JTextArea(50,60);
    private Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();
    int savedFiles, currentArticle = 0;

    public static void main(String[] args) {

        new TextEditor();
    }

    public TextEditor() {
        this.setSize(750,780);
        this.setTitle("Memento Editor X");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("New Article"));
        jPanel.add(textArea);

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
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == saveButton){
                String textInTextArea = textArea.getText();
                originator.set(textInTextArea);
                caretaker.addMemento(originator.storeInMemento());

                savedFiles++;
                currentArticle++;

                System.out.println("Save Files "+savedFiles);

                undoButton.setEnabled(true);
            } else {
                if(e.getSource() == undoButton){
                    if (currentArticle >= 1) {
                        currentArticle--;

                        String textBoxString = originator.restoreFromMemento(
                                caretaker.getMemento(currentArticle)
                        );

                        textArea.setText(textBoxString);

                        redoButton.setEnabled(true);
                    } else{
                        undoButton.setEnabled(false);
                    }
                } else {
                    if(e.getSource() == redoButton){
                        if((savedFiles - 1) > currentArticle){
                            currentArticle++;
                            String textBoxString = originator.restoreFromMemento(
                                    caretaker.getMemento(currentArticle)
                            );

                            textArea.setText(textBoxString);
                            undoButton.setEnabled(true);
                        } else {
                            redoButton.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
}