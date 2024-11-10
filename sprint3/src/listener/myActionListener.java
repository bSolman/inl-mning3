package listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class myActionListener implements ActionListener {

    JButton label;
    JButton[] buttons;
    JButton newGameButton;
    public myActionListener(JButton label, JButton[] buttons, JButton newGameButton) {
        this.label = label;
        this.buttons = buttons;
        this.newGameButton = newGameButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == label) {
            swapPosition();
        } else if (e.getSource() == newGameButton) {
            System.out.println("New Game Button clicked");
            setNewPanel();
        }
        if (isGameFinished()){
            JOptionPane.showMessageDialog(null, "Congratulations! You have finished the game!");
        }
    }

    private void setNewPanel(){
        int[] randomArray = createRandomPattern();
        for (int i = 0; i < randomArray.length; i++) {
            buttons[i].setText(String.valueOf(randomArray[i]));
        }
        buttons[15].setText("X");
    }

    public int[] createRandomPattern(){
        int[] NumberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random rnd = new Random();
        for (int i = NumberArray.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = NumberArray[index];
            NumberArray[index] = NumberArray[i];
            NumberArray[i] = a;
        }
        return NumberArray;
    }

    private void swapPosition() {
        String buttonText = label.getText();
        int currentPos;
        if (!buttonText.equals("X")){
            currentPos = getPos(buttonText);
            int swapSquare = checkForX(currentPos);
            System.out.println(swapSquare);
            if (swapSquare != -1){
                buttons[swapSquare].setText(buttonText);
                buttons[currentPos].setText("X");
            }
        }
    }

    private int getPos(String x) {
        int retVal = -1;
        for (int i = 0; i < 16; i++) {
            if (x.equals(buttons[i].getText())){
                 return i;
            }
        }
        return retVal;
    }

    private int checkForX(int i) {
        if (i + 4 <= 15){
            if (buttons[i+4].getText().equals("X")){
                return i + 4;
            }
        }
        if (i - 4 >= 0){
            if (buttons[i-4].getText().equals("X")){
                return i - 4;
            }
        }
        if (i - 1 >= 0){
            if (buttons[i-1].getText().equals("X")){
                return i - 1;
            }
        }
        if (i + 1 <= 15){
            if (buttons[i+1].getText().equals("X")){
                return i + 1;
            }
        }
        return -1;
    }

    private boolean isGameFinished(){
        boolean isCompleted = true;
        for (int i = 0; i < 15; i++) {
            if (!Objects.equals(buttons[i].getText(), String.valueOf(i + 1))){
                return false;
            }
        }
        return isCompleted;
    }
}
