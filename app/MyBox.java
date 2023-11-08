package app;

import javax.swing.*;
import java.awt.*;

public class MyBox extends JButton {
  int id = 0;
  String innerText = "";
  static boolean isX = true, playable = true;
  static String[] allBox = {"", "", "", "", "", "", "", "", ""};
  static int totalBox = 0;
  static String winner = "";
  MyBox(JPanel pane) {
    this.id = MyBox.totalBox;
    System.out.println(this.id);
    MyBox.totalBox++;
    this.setBackground(Color.GRAY);
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    this.setFont(new Font("Lucida Console", Font.PLAIN, 170));
    this.setForeground(Color.WHITE);
    this.setFocusable(false);
    this.addActionListener(e -> {
      if(this.getText().isEmpty()) {
        if(isX && playable) {
          this.setText("X");
          MyBox.allBox[this.id] = "X";
          Main.indicator.setText("O Turns");
        } else if(!isX && playable) {
          this.setText("O");
          MyBox.allBox[this.id] = "O";
          Main.indicator.setText("X Turns");
        }
        MyBox.isX = !MyBox.isX;
        if(
                MyBox.check(1, 2, 3, "X") ||
                MyBox.check(4, 5, 6, "X") ||
                MyBox.check(7, 8, 9, "X") ||
                MyBox.check(1, 5, 9, "X") ||
                MyBox.check(3, 5, 7, "X") ||
                MyBox.check(1, 4, 7, "X") ||
                MyBox.check(2, 5, 8, "X") ||
                MyBox.check(3, 6, 9, "X")
        ) {
          JOptionPane.showMessageDialog(
                  null,
                  "Player1(X)",
                  "The Winner Is",
                  JOptionPane.PLAIN_MESSAGE);
          Main.indicator.setText("X is Winner");
          MyBox.playable = false;
          for(MyBox box : Main.boxes) {
            if(box.getText().isEmpty()) {
              box.setText("~");
            }
          }
        }
        if(
                MyBox.check(1, 2, 3, "O") ||
                MyBox.check(4, 5, 6, "O") ||
                MyBox.check(7, 8, 9, "O") ||
                MyBox.check(1, 5, 9, "O") ||
                MyBox.check(3, 5, 7, "O") ||
                MyBox.check(1, 4, 7, "O") ||
                MyBox.check(2, 5, 8, "O") ||
                MyBox.check(3, 6, 9, "O")
        ) {
          JOptionPane.showMessageDialog(
                  null,
                  "Player2(O)",
                  "The Winner Is",
                  JOptionPane.PLAIN_MESSAGE);
          Main.indicator.setText("O is Winner");
          MyBox.playable = false;
          for(MyBox box : Main.boxes) {
            if(box.getText().isEmpty()) {
              box.setText("~");
            }
          }
        }
      }
    });
    pane.add(this);
  }
  static boolean check(int a, int b, int c, String str) {
   if(MyBox.allBox[a-1].equals(MyBox.allBox[b-1]) &&
      MyBox.allBox[b-1].equals(MyBox.allBox[c-1]) &&
      MyBox.allBox[a-1].equals(str)
   ) {
     Main.boxes[a-1].setBackground(Color.GREEN);
     Main.boxes[b-1].setBackground(Color.GREEN);
     Main.boxes[c-1].setBackground(Color.GREEN);
     return true;
   }
   return false;
  }
}
