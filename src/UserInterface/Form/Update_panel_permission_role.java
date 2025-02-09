package UserInterface.Form;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class Update_panel_permission_role extends JPanel {
    private JCheckBox test;
    public Update_panel_permission_role(){
       panel();
    }
    private void panel(){
        Checkbox test=new Checkbox("tetsasdads");
       Checkbox test1=new Checkbox("tetsasdads");
       Checkbox test2=new Checkbox("tetsasdads");
       Checkbox test3=new Checkbox("tetsasdads");
       Checkbox test4=new Checkbox("tetsasdads");
       add(stylishCheckBox);
       add(stylishCheckBox);
       add(stylishCheckBox);
       add(stylishCheckBox);
       add(stylishCheckBox);
        stylishCheckBox.setFont(new Font("Arial", Font.BOLD, 14));
        stylishCheckBox.setForeground(Color.WHITE);
        stylishCheckBox.setOpaque(false);
        stylishCheckBox.setFocusPainted(false);
        stylishCheckBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        stylishCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                stylishCheckBox.setForeground(Color.YELLOW);
            } else {
                stylishCheckBox.setForeground(Color.WHITE);
            }
        });
    }
    JCheckBox stylishCheckBox = new JCheckBox("Aceptar términos y condiciones") {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Fondo degradado
            GradientPaint gradient = new GradientPaint(0, 0, Color.CYAN, getWidth(), getHeight(), Color.BLUE);
            g2.setPaint(gradient);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

            // Dibujar borde redondeado
            g2.setColor(Color.WHITE);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

            super.paintComponent(g);
        }
    };
}
