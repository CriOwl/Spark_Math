package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyView;
import Data_Access.VIEW.EstudianteViewDAO;
import Data_Access.VIEW.EstudianteViewDTO;
import UserInterface.Customer_control.Button_Text;
import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import UserInterface.Spark_Style;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Manage_panel_estudiante extends JPanel {
    private final Button_Text Button_created;
    private final Button_Text Button_search;
    private final Button_Text Button_deletd;
    private final Text_box search_box;
    private final Text_label search_text;
    private JTable table;
    private JScrollPane scrollPane;

    

    public Manage_panel_estudiante() {
        setLayout(new GridBagLayout());
        Button_created = new Button_Text("Crear", Spark_Style.FONT_BOLD, null);
        Button_deletd = new Button_Text("Borrar", Spark_Style.FONT_BOLD, null);
        Button_search = new Button_Text("Buscar", Spark_Style.FONT_BOLD, null);
        search_box = new Text_box(Spark_Style.FONT_BOLD, null);
        search_text = new Text_label("DNI:");
        Button_created.addActionListener(e->change_panel(new Create_panel_estudiante()));
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
        BL_generalyView<EstudianteViewDTO> bl_estudiante = new BL_generalyView<>(EstudianteViewDAO::new);
        try {
            String[] columns = bl_estudiante.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);
            Object[][] data = new Object[bl_estudiante.getAll().size()][columns.length];

            int index = 0;
            for (EstudianteViewDTO user : new EstudianteViewDAO().readall()) {
                data[index][0] = user.getId_student_course();
                data[index][1] = user.getEstudiante();
                data[index][2] = user.getDni();
                data[index][3] = user.getEmail();
                data[index][4] = user.getInstitucion();
                data[index][5] = user.getAmie();
                data[index][6] = user.getPeriodo();
                data[index][7] = user.getJornada();
                data[index][8] = user.getCurso();
                data[index][9] = user.getProfesor();
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
        BL_generalyView<EstudianteViewDTO> bl_estudiante = new BL_generalyView<>(EstudianteViewDAO::new);
        try {
            String[] columns = bl_estudiante.getColumn().stream().map(c -> c.getName_column()).toArray(String[]::new);
            Object[][] data = new Object[bl_estudiante.getAll().size()][columns.length];

            int index = 0;
            for (EstudianteViewDTO user : new EstudianteViewDAO().readall()) {
                data[index][0] = user.getId_student_course();
                data[index][1] = user.getEstudiante();
                data[index][2] = user.getDni();
                data[index][3] = user.getEmail();
                data[index][4] = user.getInstitucion();
                data[index][5] = user.getAmie();
                data[index][6] = user.getPeriodo();
                data[index][7] = user.getJornada();
                data[index][8] = user.getCurso();
                data[index][9] = user.getProfesor();
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