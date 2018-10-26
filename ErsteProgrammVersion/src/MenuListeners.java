import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListeners extends ErsteProgrammVersion {
    public MenuListeners( JButton Button1, JButton Button2, JButton Button3, JButton Button4, JLabel einstLabel, JLabel einstLabel1, JLabel einstLabel2, JLabel levelLabel, JFrame hauptWindow){

        //Wenn Button1 geklickt wurde dann wird ein neues Fenster für das Spiel geöffnet
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher();
            }
        });

        //Wenn Button2 geklickt wird dann erscheinen die Einstellungen
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                einstLabel.setText("Einstellungen");
                einstLabel1.setText("Button Farbe ändern");
                einstLabel2.setText("Hintergrundfarbe ändern");

                levelLabel.setText("");
            }
        });

        //Wenn Button3 geklickt wird dann erscheinen die Levels
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BufferedImage img = ImageIO.read(this.getClass().getResource("level1_thumbnail.png"));
                JLabel imgLabel = new JLabel(new ImageIcon("/res/textures/level1_thumbnail.png"));
                levelLabel.setText("Levels");

                einstLabel.setText("");
                einstLabel1.setText("");
                einstLabel2.setText("");

                hauptWindow.add(imgLabel);
            }
        });

        //Wenn Button4 geklickt wurde dann wird die App geschlossen
        Button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
