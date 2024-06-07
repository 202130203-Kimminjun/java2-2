import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class VibratingFrame extends JFrame implements Runnable {
    private Thread th;

    public VibratingFrame() {
        setTitle("진동하는 프레임 만들기");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400,400);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    ImageIcon normalIcon = new ImageIcon("akumamemcho.gif");
    ImageIcon rolloverIcon = new ImageIcon("kawaiimemcho.gif");
    ImageIcon pressedIcon = new ImageIcon("tanoshimemcho.gif");
    JButton btn = new JButton("call~~", normalIcon);
    btn.setPressedIcon(pressedIcon);
    btn.setRolloverIcon(rolloverIcon);
    c.add(btn);
    
    setLocation(400,400); 
    setVisible(true);
    getContentPane().addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            if(!th.isAlive())
            return;
            th.interrupt(); 
            }
        }
        );
    th = new Thread(this);
    th.start();
    }

@Override
public void run() {
    Random r = new Random();
    while(true) {
        try {
            Thread.sleep(20);
        }
        catch(InterruptedException e){
            return;
        }
        int x = getX() + r.nextInt()%20;
        int y = getY() + r.nextInt()%20;
        setLocation(x, y); 
        }
    }
public static void main(String [] args) {
    new VibratingFrame();

    }
}
