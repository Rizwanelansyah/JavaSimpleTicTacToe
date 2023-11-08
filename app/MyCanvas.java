package app;

import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JComponent {
  public static int x1, x2, y1, y2;
  public void paint(Graphics g)
  {
    g.drawLine(x1, y1, x2, y2);
  }
}
