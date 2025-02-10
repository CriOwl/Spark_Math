package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyView;
import Data_Access.VIEW.DocenteViewDAO;
import Data_Access.VIEW.DocenteViewDTO;
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

public class Manage_panel_docent extends JPanel {
    private final Button_Text Button_update;
    private final Button_Text Button_created;
    private final Button_Text Button_search;
    private final Button_Text Button_deletd;
    private final Text_box search_box;
    private final Text_label search_text;
    private JTable table;
    private JScrollPane scrollPane;

    public Manage_panel_docent() {
        setLayout(new GridBagLayout());
        Button_update = new Button_Text("Actualizar", Spark_Style.FONT_BOLD, null);
        Button_created = new Button_Text("Crear", Spark_Style.FONT_BOLD, null);
        Button_deletd = new Button_Text("Borrar", Spark_Style.FONT_BOLD, null);
        Button_search = new Button_Text("Buscar", Spark_Style.FONT_BOLD, null);
        search_box = new Text_box(Spark_Style.FONT_BOLD, null);
        search_text = new Text_label("DNI:");

        Button_search.addActionListener(e -> change_table());

        created_table();
        setup_panel();
    }

    private void change_table() {
        String dni = search_box.getText().trim();
        if (dni.isEmpty() || dni.isBlank()) {
            created_table();
        } else {
            search(dni);
        }
        table.revalidate();
        table.repaint();
    }

    private void created_table() {
        BL_generalyView<DocenteViewDTO> bl_docente = new BL_generalyView<>(DocenteViewDAO::new);
        try {
            String[] columns = bl_docente.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);
            Object[][] data = new Object[bl_docente.getAll().size()][columns.length];

            int index = 0;
            for (DocenteViewDTO docente : new DocenteViewDAO().readall()) {
                data[index][0] = docente.getId();
                data[index][1] = docente.getProfesor();
                data[index][2] = docente.getInstitucion();
                data[index][3] = docente.getAmie();
                data[index][4] = docente.getPeriodo();
                data[index][5] = docente.getJornada();
                data[index][6] = docente.getCurso();
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
        BL_generalyView<DocenteViewDTO> bl_docente = new BL_generalyView<>(DocenteViewDAO::new);
        try {
            String[] columns = bl_docente.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);
            List<DocenteViewDTO> results = bl_docente.search(DNI);
            Object[][] data = new Object[results.size()][columns.length];

            int index = 0;
            for (DocenteViewDTO docente : results) {
                data[index][0] = docente.getId();
                data[index][1] = docente.getProfesor();
                data[index][2] = docente.getInstitucion();
                data[index][3] = docente.getAmie();
                data[index][4] = docente.getPeriodo();
                data[index][5] = docente.getJornada();
                data[index][6] = docente.getCurso();
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