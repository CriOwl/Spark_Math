package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyView;
import Data_Access.VIEW.PermisoRoleViewDAO;
import Data_Access.VIEW.PermisoRoleViewDTO;
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

public class Manage_panel_permission_role extends JPanel {
    private final Button_Text Button_update;
    private final Button_Text Button_created;
    private final Button_Text Button_search;
    private final Button_Text Button_deletd;
    private final Text_box search_box;
    private final Text_label search_text;
    private JTable table;
    private JScrollPane scrollPane;

    public Manage_panel_permission_role() {
        setLayout(new GridBagLayout());
        Button_update = new Button_Text("Actualizar", Spark_Style.FONT_BOLD, null);
        Button_created = new Button_Text("Crear", Spark_Style.FONT_BOLD, null);
        Button_deletd = new Button_Text("Borrar", Spark_Style.FONT_BOLD, null);
        Button_search = new Button_Text("Buscar", Spark_Style.FONT_BOLD, null);
        search_box = new Text_box(Spark_Style.FONT_BOLD, null);
        search_text = new Text_label("Rol:");

        Button_search.addActionListener(e -> change_table());

        created_table();
        setup_panel();
    }

    private void change_table() {
        String role = search_box.getText().trim();
        if (role.isEmpty() || role.isBlank()) {
            created_table();
        } else {
            search(role);
        }
        table.revalidate();
        table.repaint();
    }

    private void created_table() {
        BL_generalyView<PermisoRoleViewDTO> bl_permission_role = new BL_generalyView<>(PermisoRoleViewDAO::new);
        try {
            String[] columns = bl_permission_role.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);
            Object[][] data = new Object[bl_permission_role.getAll().size()][columns.length];

            int index = 0;
            for (PermisoRoleViewDTO permissionRole : new PermisoRoleViewDAO().readall()) {
                data[index][0] = permissionRole.getId();
                data[index][1] = permissionRole.getRol();
                data[index][2] = permissionRole.getPermiso();
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

    private void search(String role) {
        BL_generalyView<PermisoRoleViewDTO> bl_permission_role = new BL_generalyView<>(PermisoRoleViewDAO::new);
        try {
            String[] columns = bl_permission_role.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);

            List<PermisoRoleViewDTO> results = bl_permission_role.search(role);
            Object[][] data = new Object[results.size()][columns.length];

            int index = 0;
            for (PermisoRoleViewDTO permissionRole : results) {
                data[index][0] = permissionRole.getId();
                data[index][1] = permissionRole.getRol();
                data[index][2] = permissionRole.getPermiso();
                index++;
                System.out.println(permissionRole.getId());
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
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        add(Button_deletd, gbc);
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
}