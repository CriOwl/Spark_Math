package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import UserInterface.Spark_Style;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class MainFrame extends JFrame {
    private  final JButton change_themes = new JButton();
    private  final ImageIcon moon_theme_icon = new ImageIcon (new ImageIcon(Spark_Style.URL_MOON_THEMES).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    private  final ImageIcon sun_theme_icon = new ImageIcon(new ImageIcon(Spark_Style.URL_SUN_THEMES).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    private  final ImageIcon logo = new ImageIcon(Spark_Style.URL_LOGO);
    private Login_panel login;
    private Menu_panel menu;
    private JFrame main_windown;
    private boolean is_dark=true;

    public MainFrame(String name_app) {
        created_windown(name_app);
    }

    public void created_windown(String name_app) {
        try {
        UIManager.setLookAndFeel(new FlatArcDarkIJTheme()); 
        main_windown = new JFrame(name_app);
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void  change_icon_themes(boolean is_dark) {
            try {
                if (is_dark) {
                    change_themes.setIcon(moon_theme_icon);
                    UIManager.setLookAndFeel(new FlatCyanLightIJTheme());
                } else {
                    change_themes.setIcon(sun_theme_icon);
                    UIManager.setLookAndFeel(new FlatMonokaiProIJTheme());
                }
            } catch (Exception e) {
                System.out.println("No se puede cargar el tema");
            }
        SwingUtilities.updateComponentTreeUI(main_windown);
        this.is_dark=!is_dark;
    }
    
    private void menu_panel(List<String> permisos, Integer userId){
        System.out.println("Panel del menu");
        main_windown.remove(login);
        System.out.println("cargando menu");
        menu=new Menu_panel(permisos, userId);
        Container container=getContentPane();
        container.setLayout(new BorderLayout());
        container.add(menu,BorderLayout.WEST);
        container.setPreferredSize(new Dimension(300,getHeight()));
        main_windown.add(container);
        main_windown.revalidate();
        //Cambiar main_panel--
        Manage_panel_docente update_panel = new Manage_panel_docente();
        container.add(update_panel,BorderLayout.CENTER);
        main_windown.add(container);
        main_windown.revalidate();
    }
    private void change_panel_menu(JPanel panel){
        main_windown.remove(panel);
        main_windown.add(panel,BorderLayout.CENTER);
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
        menu_panel(login.getList_permissions(), login.getUser_id());
    }
    
}
