package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyView;
import Data_Access.VIEW.InstitutionViewDAO;
import Data_Access.VIEW.InstitutionViewDTO;
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

public class Manage_panel_institution extends JPanel {
    Button_Text Button_update;
    Button_Text Button_created;
    Button_Text Button_search;
    Button_Text Button_deletd;
    Text_box search_box;
    Text_label search_text;
    JTable table;
    JScrollPane scrollPane;

    public Manage_panel_institution() {
        setLayout(new GridBagLayout());
        Button_update = new Button_Text("Actualizar", Spark_Style.FONT_BOLD, null);
        Button_created = new Button_Text("Crear", Spark_Style.FONT_BOLD, null);
        Button_deletd = new Button_Text("Borrar", Spark_Style.FONT_BOLD, null);
        Button_search = new Button_Text("Buscar", Spark_Style.FONT_BOLD, null);
        search_box = new Text_box(Spark_Style.FONT_BOLD, null);
        search_text = new Text_label("Nombre:");

        Button_search.addActionListener(e -> change_table());

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
        BL_generalyView<InstitutionViewDTO> bl_institution = new BL_generalyView<>(InstitutionViewDAO::new);
        try {
            String[] columns = bl_institution.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);
            List<InstitutionViewDTO> results = bl_institution.getAll();
            Object[][] data = new Object[results.size()][columns.length];

            int index = 0;
            for (InstitutionViewDTO user : results ) {
                data[index][0] = user.getId_institution();
                data[index][1] = user.getName();
                data[index][2] = user.getAmie();
                data[index][3] = user.getName_manager();
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

    private void search(String AMIE) {
        BL_generalyView<InstitutionViewDTO> bl_institution = new BL_generalyView<>(InstitutionViewDAO::new);
        try {
            //
            String[] columns = bl_institution.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);
            List<InstitutionViewDTO> results = bl_institution.search(AMIE);
            Object[][] data = new Object[results.size()][columns.length];

            int index = 0;
            for (InstitutionViewDTO user : results) {
                data[index][0] = user.getId_institution();
                data[index][1] = user.getName();
                data[index][2] = user.getAmie();
                data[index][3] = user.getName_manager();
                index++;
                System.out.println(user.getId_institution());
            }

            //
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
