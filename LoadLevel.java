import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;

public class LoadLevel {

    public LoadLevel(int width, int height, String title, Game game){

        //creates the window for the level
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setLayout(null);

        //ImageIcon level = new ImageIcon("C:\\Users\\User\\IdeaProjects\\javaracinggame\\src\\TestLevel.png");

        //JLabel levelLabel = new JLabel(level);
        //levelLabel.setBounds(0,0, 2000, 2000);
        //levelLabel.setVisible(true);

        frame.add(game);
        //frame.add(levelLabel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
