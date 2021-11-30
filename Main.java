import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Content for gui is not showing up on everyones computer
class Main {
  public static void main(String args[]) {
   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        new Game();
     }
   });
 }
}