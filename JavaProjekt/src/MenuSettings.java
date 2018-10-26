import javax.swing.*;
import java.awt.*;

public class MenuSettings extends JavaProjekt {
    public MenuSettings(JFrame hauptWindow, JPanel panel, JLabel titelLabel, JButton Button1, JButton Button2, JButton Button3, JButton Button4, JLabel levelLabel, JLabel einstLabel, JLabel einstLabel1, JLabel einstLabel2){

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
    }
}
