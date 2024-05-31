import javax.swing.*;
import java.awt.*;
public class ButtonImage extends JFrame {
public ButtonImage() {
    setTitle("아버지가방에서");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    ImageIcon normalIcon = new ImageIcon("akumamemcho.gif");
    ImageIcon rolloverIcon = new ImageIcon("kawaiimemcho.gif");
    ImageIcon pressedIcon = new ImageIcon("tanoshimemcho.gif");
    JButton btn = new JButton("call~~", normalIcon);
    btn.setPressedIcon(pressedIcon);
    btn.setRolloverIcon(rolloverIcon);
    c.add(btn);
    setSize(250,150);
    setVisible(true);
    }
public static void main(String [] args) {
    new ButtonImage();
    }
}
