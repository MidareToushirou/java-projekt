import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import static javax.imageio.ImageIO.read;

public class ErsteProgrammVersion{

    public static void main(String[] args){
        //Objekte erstellen
        String[] farbe={
                "Rot", "Blau","Gelb","Weiß","Schwarz","Grün"

        };

        JFrame hauptWindow = new JFrame("CenTurY");
        JPanel panel = new JPanel();
        JButton Button1 = new JButton("Start");
        JButton Button2 = new JButton("Einstellungen");
        JButton Button3 = new JButton("Levels");
        JButton Button4 = new JButton("Schließen");
        JLabel titelLabel = new JLabel("CenTurY's Application");
        JLabel levelLabel = new JLabel("");
        JLabel einstLabel = new JLabel("");

        JLabel einstLabel1 = new JLabel("");
        JLabel einstLabel2 = new JLabel("");
        //JOptionPane.showOptionDialog(null,"Farbe auswählen","Farbe",0,JOptionPane.QUESTION_MESSAGE,null,farbe,0);

        //Icon ändern
        ImageIcon icon1 = new ImageIcon("/Bilder/AvatarElemente.png");
        hauptWindow.setIconImage(icon1.getImage());

        //Notwendige Parameter (Sichtbar, Größe, Fenstergröße veränderbar, Schließaktion)
        hauptWindow.setVisible(true);
        hauptWindow.setSize(1250,750);
        hauptWindow.setResizable(false);
        hauptWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Startet das Fenster in der Mitte des Bildschirms
        hauptWindow.setLocationRelativeTo(null);

        //Layout setzen
        panel.setLayout(null);

        //Position und Größe der Objekte
        titelLabel.setBounds(450,-200,500,500);
        Button1.setBounds(750,175,500,75);
        Button2.setBounds(750,275,500,75);
        Button3.setBounds(750,375,500,75);
        Button4.setBounds(750,475,500,75);
        levelLabel.setBounds(250, 10, 250, 400);
        einstLabel.setBounds(250,10,250,400);
        einstLabel1.setBounds(100,125,250,300);
        einstLabel2.setBounds(100,175,250,300);

        //Textfont, Textformatierung, Textgröße
        titelLabel.setFont(new Font("Trebuchet MS", Font.BOLD,40));
        Button1.setFont(new Font("Trebuchet MS", Font.PLAIN,20));
        Button2.setFont(new Font("Trebuchet MS", Font.PLAIN,20));
        Button3.setFont(new Font("Trebuchet MS", Font.PLAIN,20));
        Button4.setFont(new Font("Trebuchet MS", Font.PLAIN,20));
        levelLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
        einstLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
        einstLabel1.setFont(new Font("Trebuchet MS", Font.PLAIN,17));
        einstLabel2.setFont(new Font("Trebuchet MS", Font.PLAIN,17));

        //Farbe der Objekte
        Button1.setBackground(Color.lightGray);
        Button2.setBackground(Color.lightGray);
        Button3.setBackground(Color.lightGray);
        Button4.setBackground(Color.lightGray);

        //Objekte zum Panel hinzufügen
        hauptWindow.add(panel);
        panel.add(Button1);
        panel.add(Button2);
        panel.add(Button3);
        panel.add(Button4);
        panel.add(titelLabel);
        panel.add(levelLabel);
        panel.add(einstLabel);
        panel.add(einstLabel1);
        panel.add(einstLabel2);

        //Wenn Button1 geklickt wurde dann wird ein neues Fenster für das Spiel geöffnet
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame spielWindow = new JFrame("CenTurY");
                JPanel spielPanel = new JPanel();

                spielWindow.setVisible(true);
                spielWindow.setResizable(false);
                spielWindow.setSize(1250,750);
                spielWindow.setLayout(null);
                spielWindow.setLocationRelativeTo(null);

                ImageIcon icon2 = new ImageIcon("/Bilder/AvatarElemente.png");
                spielWindow.setIconImage(icon2.getImage());

                spielWindow.add(spielPanel);
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
                JPanel levelPanel = new JPanel();
                levelPanel.setBackground(Color.PINK);
                levelPanel.setBounds(0,0,400,400);
                hauptWindow.add(levelPanel);
                levelLabel.setText("Levels");

                einstLabel.setText("");
                einstLabel1.setText("");
                einstLabel2.setText("");
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