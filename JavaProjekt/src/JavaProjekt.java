import javax.swing.*;

public class JavaProjekt {

    public static void main(String[] args){

        JFrame hauptWindow = new JFrame("CenTurY");
        JPanel panel = new JPanel();
        JButton Button0 = new JButton("Start");
        JButton Button1 = new JButton("Einstellungen");
        JButton Button2 = new JButton("Levels");
        JButton Button3 = new JButton("Schließen");
        JLabel titelLabel = new JLabel("CenTurY's Application");
        JLabel levelLabel = new JLabel("");
        JLabel einstLabel = new JLabel("");

        JLabel einstLabel1 = new JLabel("");
        JLabel einstLabel2 = new JLabel("");
        //JOptionPane.showOptionDialog(null,"Farbe auswählen","Farbe",0,JOptionPane.QUESTION_MESSAGE,null,farbe,0);

        //Objekte zum Panel hinzufügen
        hauptWindow.add(panel);
        panel.add(Button0);
        panel.add(Button1);
        panel.add(Button2);
        panel.add(Button3);
        panel.add(titelLabel);
        panel.add(levelLabel);
        panel.add(einstLabel);
        panel.add(einstLabel1);
        panel.add(einstLabel2);

        //Icon ändern
        ImageIcon icon1 = new ImageIcon("textures/AvatarElemente.png");
        hauptWindow.setIconImage(icon1.getImage());

        new MenuListeners( Button0, Button1, Button2, Button3, einstLabel, einstLabel1, einstLabel2, levelLabel, hauptWindow);
        new MenuSettings(hauptWindow, panel, titelLabel, Button0, Button1, Button2, Button3, levelLabel, einstLabel, einstLabel1, einstLabel2);
    }
}
