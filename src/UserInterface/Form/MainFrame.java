package UserInterface.Form;

import UserInterface.Customer_control.Table_Spark;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.naming.spi.ObjectFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import UserInterface.Spark_Style;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Window;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class MainFrame extends JFrame {
    private JButton change_themes = new JButton();
    private  ImageIcon moon_theme_icon = new ImageIcon (new ImageIcon(Spark_Style.URL_MOON_THEMES).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    private  ImageIcon sun_theme_icon = new ImageIcon(new ImageIcon(Spark_Style.URL_SUN_THEMES).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    private  ImageIcon logo = new ImageIcon(Spark_Style.URL_LOGO);
    private Login_panel login;
    private Menu_panel menu;
    private JFrame main_windown;
    private boolean is_dark=true;

    public MainFrame(String name_app) {
        created_windown(name_app);
    }

    public void created_windown(String name_app) {
        try {
            UIManager.setLookAndFeel(new FlatCarbonIJTheme());
        } catch (Exception e) {
        }
        main_windown = new JFrame(name_app);
        main_windown.setLocation(700, 0);
        main_windown.setExtendedState(JFrame.MAXIMIZED_BOTH);
        main_windown.setIconImage(logo.getImage());
        main_windown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel themes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        themes.setOpaque(false);
        main_windown.add(themes, BorderLayout.NORTH);
        themes.add(change_themes);
        change_themes.setPreferredSize(new Dimension(40, 40));
        change_themes.setIcon(sun_theme_icon);
        change_themes.addActionListener(e -> change_icon_themes(this.is_dark));
        Login_panel();
        main_windown.setVisible(true);
    }

    private void  change_icon_themes(boolean is_dark) {
            try {
                if (is_dark) {
                    change_themes.setIcon(moon_theme_icon);
                    UIManager.setLookAndFeel(new FlatCyanLightIJTheme());
                } else {
                    change_themes.setIcon(sun_theme_icon);
                    UIManager.setLookAndFeel(new FlatCarbonIJTheme());
                }
            } catch (Exception e) {
                System.out.println("No se puede cargar el tema");
            }
        SwingUtilities.updateComponentTreeUI(main_windown);
        this.is_dark=!is_dark;
    }
    private void menu_panel(List<String> permisos){
        System.out.println("Panel del menu");
        main_windown.remove(login);
        System.out.println("cargando menu");
        menu=new Menu_panel(permisos);
        Container container=getContentPane();
        container.setLayout(new BorderLayout());
        container.add(menu,BorderLayout.WEST);
        container.setPreferredSize(new Dimension(300,getHeight()));
        main_windown.add(container);
        main_windown.revalidate();
        //Cambiar main_panel--
<<<<<<< HEAD
        
        Update_panel_role update_panel = new Update_panel_role();
=======
        Manage_panel_institution update_panel = new Manage_panel_institution();
>>>>>>> PanelCatalogo
        container.add(update_panel,BorderLayout.CENTER);
        main_windown.add(container);
        main_windown.revalidate();

       /*  JPanel panel=new JPanel();
        main_windown.add(panel,BorderLayout.CENTER); */
    }
    private void change_panel(Component panel){
        Manage_panel manage_panel=new Manage_panel();
        //main_windown.remove(panel);
        main_windown.add(manage_panel,BorderLayout.CENTER);
    
        main_windown.revalidate();
    }
    private void Login_panel(){
        login=new Login_panel();
        main_windown.add(login);
        login.login_button.addActionListener(e->change_panel(login.login_bl()));
    }
    private void change_panel(boolean state_login){
        if(!state_login){
            System.out.println("datos fallido");
            return;
        }
        System.out.println("cambiando de panel");
        menu_panel(login.getList_permissions());
    }
    
}
