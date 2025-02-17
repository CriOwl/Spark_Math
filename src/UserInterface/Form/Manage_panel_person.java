package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyView;
import Data_Access.VIEW.LoginDAO;
import Data_Access.VIEW.LoginDTO;
import UserInterface.Customer_control.Button_Text;
import UserInterface.Customer_control.Mascaras;
import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import UserInterface.Spark_Style;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AbstractDocument;

public class Manage_panel_person extends JPanel {
    private final Button_Text Button_update;
    public final Button_Text Button_created;
    private final Button_Text Button_search;
    private final Text_box search_box;
    private final Text_label search_text;
    private JTable table;
    private JScrollPane scrollPane;

    public Manage_panel_person() {
        setLayout(new GridBagLayout());
        Button_update = new Button_Text("Actualizar", Spark_Style.FONT_BOLD, null);
        Button_created = new Button_Text("Crear", Spark_Style.FONT_BOLD, null);
        Button_search = new Button_Text("Buscar", Spark_Style.FONT_BOLD, null);
        search_box = new Text_box(Spark_Style.FONT_BOLD, null);
       ((AbstractDocument) search_box.getDocument()).setDocumentFilter(new Mascaras(10));
        search_text = new Text_label("DNI:");
        Button_search.addActionListener(e -> change_table());
        Button_created.addActionListener(e->change_panel(new Create_panel_person()));
        Button_update.addActionListener(e->change_panel(new Update_panel_person()));
        created_table();
        setup_panel();
    }

    private void change_table() {
        String dni = search_box.getText().trim();
        System.out.println(dni);
        if (dni.isEmpty()||dni.isBlank()) {
            created_table();
        }else{
            search(dni);
        }
        table.revalidate();
        table.repaint();
    }

    private void created_table() {
        BL_generalyView<LoginDTO> bl_login = new BL_generalyView<>(LoginDAO::new);
        try {
            String[] columns = bl_login.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);
            Object[][] data = new Object[bl_login.getAll().size()][columns.length];

            int index = 0;
            for (LoginDTO user : new LoginDAO().readall()) {
                data[index][0] = user.getId_person();
                data[index][1] = user.getName();
                data[index][2] = user.getLast_name();
                data[index][3] = user.getDNI();
                data[index][4] = user.getEmail();
                data[index][5] = user.getPassword();
                data[index][6] = user.getName_role();
                data[index][7] = user.getState();
                index++;

            }
            if (table == null) {
                table = new JTable();
                table = new JTable(new DefaultTableModel(data, columns));
                scrollPane = new JScrollPane(table);
            }
            table.setModel(new DefaultTableModel(data, columns));
            table.revalidate();
            table.repaint();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void search(String DNI) {
        BL_generalyView<LoginDTO> bl_login = new BL_generalyView<>(LoginDAO::new);
        try {
            String[] columns = bl_login.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);
            List<LoginDTO> results = bl_login.search(DNI);
            Object[][] data = new Object[results.size()][columns.length];
            int index = 0;
            for (LoginDTO user : results) {
                data[index][0] = user.getId_person();
                data[index][1] = user.getName();
                data[index][2] = user.getLast_name();
                data[index][3] = user.getDNI();
                data[index][4] = user.getEmail();
                data[index][5] = user.getPassword();
                data[index][6] = user.getName_role();
                data[index][7] = user.getState();
                index++;
            }
            table.setModel(new DefaultTableModel(data, columns));
            table.revalidate();
            table.repaint();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void setup_panel() {
        JTableHeader header = table.getTableHeader();
        header.setFont(Spark_Style.FONT_BOLD);
        scrollPane.setPreferredSize(new Dimension(1000, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(Button_update, gbc);
        gbc.gridx = 1;
        add(Button_created, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(search_box, gbc);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(search_text, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(Button_search, gbc);
    }
    private void change_panel(JPanel newPanel) {
        removeAll(); 
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(newPanel, gbc);
        revalidate();
        repaint(); 
    }
}
