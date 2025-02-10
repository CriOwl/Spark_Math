package UserInterface.Form;

import UserInterface.Spark_Style;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
    public MainPanel() {
        ccCustomize();
    }

    private void ccCustomize(){
        try {
            ImageIcon imageIcon = new ImageIcon(Spark_Style.URL_MAIN);
            add(new JLabel(imageIcon), BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
