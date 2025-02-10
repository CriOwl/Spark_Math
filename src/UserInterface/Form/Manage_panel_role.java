package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyView;
import Data_Access.DAO.DAO_C.VWRoleDAO;
import Data_Access.DTO.RoleDTO;
import UserInterface.Customer_control.Button_Text;
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

public class Manage_panel_role extends JPanel {
    private final Button_Text Button_update;
    private final Button_Text Button_created;
    private final Button_Text Button_search;
    private final Text_box search_box;
    private final Text_label search_text;
    private JTable table;
    private JScrollPane scrollPane;

    public Manage_panel_role() {
        setLayout(new GridBagLayout());
        Button_update = new Button_Text("Actualizar", Spark_Style.FONT_BOLD, null);
        Button_created = new Button_Text("Crear", Spark_Style.FONT_BOLD, null);
        Button_search = new Button_Text("Buscar", Spark_Style.FONT_BOLD, null);
        search_box = new Text_box(Spark_Style.FONT_BOLD, null);
        search_text = new Text_label("Nombre:");
        Button_created.addActionListener(e->change_panel(new Create_panel_rol()));
        Button_update.addActionListener(e->change_panel(new Update_panel_rol()));
        Button_search.addActionListener(e -> change_table());

        created_table();
        setup_panel();
    }

    private void change_table() {
        String name = search_box.getText().trim();
        if (name.isEmpty() || name.isBlank()) {
            created_table();
        } else {
            search(name);
        }
        table.revalidate();
        table.repaint();
    }

    private void created_table() {
        BL_generalyView<RoleDTO> bl_role = new BL_generalyView<>(VWRoleDAO::new);
        try {
            String[] columns = {"ID", "Nombre", "Estado", "Fecha Creación", "Fecha Actualización"};
            List<RoleDTO> roles = bl_role.getAll();
            Object[][] data = new Object[roles.size()][columns.length];

            int index = 0;
            for (RoleDTO role : roles) {
                data[index][0] = role.getId_Role();
                data[index][1] = role.getName();
                data[index][2] = role.getState() == 1 ? "Activo" : "Inactivo";
                data[index][3] = role.getDate_created();
                data[index][4] = role.getDate_created();
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

    private void search(String name) {
        BL_generalyView<RoleDTO> bl_role = new BL_generalyView<>(VWRoleDAO::new);
        try {
            String[] columns = {"ID", "Nombre", "Estado", "Fecha Creación", "Fecha Actualización"};
            List<RoleDTO> results = bl_role.search(name);
            Object[][] data = new Object[results.size()][columns.length];

            int index = 0;
            for (RoleDTO role : results) {
                data[index][0] = role.getId_Role();
                data[index][1] = role.getName();
                data[index][2] = role.getState() == 1 ? "Activo" : "Inactivo";
                data[index][3] = role.getDate_created();
                data[index][4] = role.getDate_created();
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