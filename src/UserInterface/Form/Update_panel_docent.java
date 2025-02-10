package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.DAO_C.InstitutionDAO;
import Data_Access.DAO.DAO_C.PersonDAO;
import Data_Access.DAO.DAO_C.RoleDAO;
import Data_Access.VIEW.DocenteViewDTO;
import Data_Access.DTO.InstitutionDTO;
import Data_Access.DTO.PersonDTO;
import Data_Access.DTO.RoleDTO;
import UserInterface.Customer_control.Button_Text;
import UserInterface.Customer_control.Mascaras;
import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import UserInterface.Spark_Style;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument;

public class Update_panel_docent extends JPanel {
    private Text_label name_person;
    private Text_label institution_person;
    private Text_label period_person;
    private Text_label jornada_person;
    private Text_label curso_person;
    private Text_box name_person_box;
    private Text_box last_name_person_box;
    private JComboBox<String> institution_box;
    private JComboBox<String> period_box;
    private JComboBox<String> jornada_box;
    private JComboBox<String> curso_box;
    private Button_Text send;
    private Button_Text cancel;
    private final HashMap<String, Integer> Institucion_map = new HashMap<>();
    private final HashMap<String, Integer> Period_map = new HashMap<>();
    private final HashMap<String, Integer> Jornada_map = new HashMap<>();
    private final HashMap<String, Integer> Curso_map = new HashMap<>();
    Integer id_docente;

    public Update_panel_docent() {
        setup_panel();
    }

    private void setup_panel() {
        setLayout(new GridBagLayout());
        name_person = new Text_label("Nombre:");
        institution_person = new Text_label("Institución:");
        period_person = new Text_label("Período:");
        jornada_person = new Text_label("Jornada:");
        curso_person = new Text_label("Curso:");
        name_person_box = new Text_box();
        institution_box = new JComboBox<>(data_institution());
        period_box = new JComboBox<>(data_period());
        jornada_box = new JComboBox<>(data_jornada());
        curso_box = new JComboBox<>(data_curso());
        send = new Button_Text("Enviar", Spark_Style.FONT, null);
        send.addActionListener(e -> validate_data());
        cancel = new Button_Text("Cancelar", Spark_Style.FONT, null);
        cancel.setBackground(new Color(200, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(name_person, gbc);
        gbc.gridx = 1;
        add(name_person_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(last_name_person_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(institution_person, gbc);
        gbc.gridx = 1;
        add(institution_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(period_person, gbc);
        gbc.gridx = 1;
        add(period_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(jornada_person, gbc);
        gbc.gridx = 1;
        add(jornada_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(curso_person, gbc);
        gbc.gridx = 1;
        add(curso_box, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(send, gbc);
        gbc.gridy = 7;
        add(cancel, gbc);
    }

    private String[] data_institution() {
        // Lógica para cargar las instituciones desde la base de datos
        return new String[]{"Institución 1", "Institución 2"};
    }

    private String[] data_period() {
        // Lógica para cargar los períodos desde la base de datos
        return new String[]{"Período 1", "Período 2"};
    }

    private String[] data_jornada() {
        // Lógica para cargar las jornadas desde la base de datos
        return new String[]{"Jornada 1", "Jornada 2"};
    }

    private String[] data_curso() {
        // Lógica para cargar los cursos desde la base de datos
        return new String[]{"Curso 1", "Curso 2"};
    }

    private void validate_data() {
        String name = name_person_box.getText();
        String last_name = last_name_person_box.getText();
        int id_institution = Institucion_map.get(institution_box.getSelectedItem());
        int id_period = Period_map.get(period_box.getSelectedItem());
        int id_jornada = Jornada_map.get(jornada_box.getSelectedItem());
        int id_curso = Curso_map.get(curso_box.getSelectedItem());

        if (name.isEmpty() || last_name.isEmpty()) {
            Spark_Style.show_mesg_advert("Complete todos los campos", "Registrar");
            return;
        }

        DocenteViewDTO docente = new DocenteViewDTO(id_docente, name, last_name, id_institution, id_period, id_jornada, id_curso);
        send_data(docente);
    }

    public boolean send_data(DocenteViewDTO docente) {
        // Lógica para enviar los datos a la base de datos
        return true;
    }
}