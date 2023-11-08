package app;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;

public class Main {
  static JLabel indicator;
  static JFrame frame;
  static MyBox[] boxes;
  public static void main(String[] args) {

    frame = new JFrame();
    frame.setSize(650, 700);
    frame.setLayout(new BorderLayout(0, 0));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    JPanel indicatorPanel = new JPanel();
    indicatorPanel.setPreferredSize(new Dimension(30, 50));
    indicatorPanel.setBackground(Color.BLUE);
    frame.add(indicatorPanel, BorderLayout.NORTH);

    indicator = new JLabel("X Turns");
    indicator.setFont(new Font("Sans Serif", Font.PLAIN, 30));
    indicator.setForeground(Color.WHITE);
    indicatorPanel.add(indicator);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(3, 3));
    mainPanel.setBackground(Color.LIGHT_GRAY);
    frame.add(mainPanel, BorderLayout.CENTER);

    boxes = new MyBox[]{
            new MyBox(mainPanel),
            new MyBox(mainPanel),
            new MyBox(mainPanel),
            new MyBox(mainPanel),
            new MyBox(mainPanel),
            new MyBox(mainPanel),
            new MyBox(mainPanel),
            new MyBox(mainPanel),
            new MyBox(mainPanel)
    };

    JButton reset = new JButton("RESET");
    reset.setBackground(Color.RED);
    reset.setFocusable(false);
    reset.setFont(new Font("Sans Serif", Font.ITALIC, 20));
    reset.addActionListener(e -> {
      MyBox.allBox = new String[]{"", "", "", "", "", "", "", "", ""};
      MyBox.playable = true;
      for(MyBox box : boxes) {
        box.setText("");
        box.setBackground(Color.GRAY);
      }
    });
    indicatorPanel.add(reset);

    frame.setVisible(true);

  }
}
