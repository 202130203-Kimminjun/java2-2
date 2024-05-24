import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class RandomColorPanel extends JFrame {
    private JPanel contentPane;
    private Random random;

    public RandomColorPanel() {
        setTitle("Random Color Panel");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        random = new Random();

        contentPane = new JPanel();
        contentPane.setFocusable(true);
        contentPane.requestFocusInWindow();
        contentPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER) {
                    int r = random.nextInt(256);
                    int g = random.nextInt(256);
                    int b = random.nextInt(256);
                    Color randomColor = new Color(r, g, b);
                    contentPane.setBackground(randomColor);
                } else if (keyCode == KeyEvent.VK_Q) {
                    System.exit(0);
                }
            }
        });

        add(contentPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RandomColorPanel());
    }
}
