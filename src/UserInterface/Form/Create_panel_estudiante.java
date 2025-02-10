package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.DAO_C.InstitutionDAO;
import Data_Access.DAO.DAO_C.PersonDAO;
import Data_Access.DAO.DAO_C.RoleDAO;
import Data_Access.DTO.InstitutionDTO;
import Data_Access.DTO.PersonDTO;
import Data_Access.DTO.RoleDTO;
import Data_Access.DTO.Student_courseDTO;
import Data_Access.DAO.Student_courseDAO;
import Data_Access.DTO.CourseDTO;
import Data_Access.DAO.CourseDAO;
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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument;

public class Create_panel_estudiante extends JPanel {
    private Text_label name_person ;
    private Text_label last_name_person ;
    private Text_label DNI_person ;
    private Text_label Birthdate_person ;
    private Text_label Password_person ;
    private Text_label Email_person ;
    private Text_label State_person ;
    private Text_label course_person;
    private Text_box name_person_box ;
    private Text_box last_name_person_box ;
    private Text_box DNI_person_box ;
    private Text_box Birthdate_person_box ;
    private Text_box Password_person_box ;
    private Text_box Email_person_box ;
    private JComboBox<String> State_person_box ;
    private JComboBox<String> course;
    private String [] array_course;
    private Button_Text send;
    private Button_Text cancel;
    private HashMap<String, Integer> Course_map = new HashMap<>();
    private HashMap<String, Integer> state_map = new HashMap<>();
    public Create_panel_estudiante() {
        setup_panel();
    }

    private void setup_panel() {
        setLayout(new GridBagLayout());
        name_person = new Text_label("Nombre:");
        last_name_person = new Text_label("Apellido:");
        DNI_person = new Text_label("DNI:");
        Birthdate_person = new Text_label("Fecha de nacimiento:");
        Password_person = new Text_label("Contraseña:");
        Email_person = new Text_label("Email:");
        State_person = new Text_label("Estado:");
        course_person = new Text_label("Curso:");
        name_person_box = new Text_box();
        last_name_person_box = new Text_box();
        DNI_person_box = new Text_box();
        Birthdate_person_box = new Text_box();
        Password_person_box = new Text_box();
        Email_person_box = new Text_box();
        State_person_box = new JComboBox<>(data_estado());
        course=new JComboBox<>(data_course());
        ((AbstractDocument) DNI_person_box.getDocument()).setDocumentFilter(new Mascaras(10));
        send=new Button_Text("Enviar", Spark_Style.FONT, null);
        send.addActionListener(e->validate_data());
        cancel=new Button_Text("Cancelar", Spark_Style.FONT, null);
        cancel.setBackground(new Color(200,0,0));
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Primera columna (Labels)
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(name_person, gbc);

        gbc.gridy = 1;
        add(last_name_person, gbc);

        gbc.gridy = 2;
        add(DNI_person, gbc);

        gbc.gridy = 3;
        add(Birthdate_person, gbc);

        gbc.gridy = 4;
        add(Password_person, gbc);

        gbc.gridy = 5;
        add(Email_person, gbc);

        gbc.gridy = 6;
        add(State_person, gbc);

        gbc.gridy = 7;
        add(course_person, gbc);

        // Segunda columna (Text boxes y ComboBoxes)
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(name_person_box, gbc);

        gbc.gridy = 1;
        add(last_name_person_box, gbc);

        gbc.gridy = 2;
        add(DNI_person_box, gbc);

        gbc.gridy = 3;
        add(Birthdate_person_box, gbc);

        gbc.gridy = 4;
        add(Password_person_box, gbc);

        gbc.gridy = 5;
        add(Email_person_box, gbc);

        gbc.gridy = 6;
        add(State_person_box, gbc);

        gbc.gridy = 7;
        add(course, gbc);

        // Botones
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.fill = GridBagConstraints.NONE; // No estirar
        gbc.anchor = GridBagConstraints.CENTER; // Centrar
        add(send, gbc);

        gbc.gridy = 9;
        add(cancel, gbc);
        
    }

    private String[] data_course(){
        BL_generalyTable<CourseDTO> bl_course = new BL_generalyTable<>(CourseDAO::new);
        try {
            List<CourseDTO> list_course=bl_course.read_elments();
            array_course=new String [list_course.size()];
            for (int index = 0; index < list_course.size(); index++) {
                array_course[index]=list_course.get(index).getLevel() + " - " + list_course.get(index).getParallel();
                Course_map.put(list_course.get(index).getLevel(), list_course.get(index).getId_course());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return array_course;
    }

    // private String[] data_rol(){
    //     BL_generalyTable<RoleDTO> bl_rol = new BL_generalyTable<>(RoleDAO::new);
    //     try {
    //         List<RoleDTO> list_role=bl_rol.read_elments();
    //         array_role=new String [list_role.size()];
    //         for (int index = 0; index < list_role.size(); index++) {
    //             array_role[index]=list_role.get(index).getName();
    //             Role_map.put(list_role.get(index).getName(), list_role.get(index).getId_Role());
    //         }

    //     } catch (Exception e) {
    //         System.out.println(e);
    //     }
    //     return array_role;
    // }

    private String[] data_estado(){
        String[] data_es={"Activo","Inactivo"};
        state_map.put("Activo", 1);
        state_map.put("Inactivo", 0);
        return data_es;
    }

    private void validate_data(){
         String name=name_person_box.getText(); 
         String last_name=last_name_person_box.getText(); 
         String dni=DNI_person_box.getText(); 
         String birthdat=Birthdate_person_box.getText(); 
         String password=Password_person_box.getText(); 
         String email=Email_person_box.getText(); 
        int id_course=Course_map.get(course.getSelectedItem());
        if(name.isEmpty()||last_name.isEmpty()||dni.isEmpty()||birthdat.isEmpty()||password.isEmpty()||email.isEmpty()){
            Spark_Style.show_mesg_advert("Complete todos los campos", "Registrar");
            return;
        }
        if(!(Mascaras.validate_DNI(dni))){
            Spark_Style.show_mesg_advert("Ingrese una cedula correcta", "Registrar");
            return;
        }
        PersonDTO person_created = new PersonDTO(name,last_name,dni,email,password,birthdat, 4,null);
        Student_courseDTO student_course = new Student_courseDTO(1,id_course);
        send_data(person_created,student_course);
    }
    public boolean send_data(PersonDTO person, Student_courseDTO student_courseDTO){
        BL_generalyTable<PersonDTO> table_person=new BL_generalyTable<>(PersonDAO::new);
        BL_generalyTable<Student_courseDTO> table_course=new BL_generalyTable<>(Student_courseDAO::new);
        try {
         if(table_person.cretated_elements(person) && table_course.cretated_elements(student_courseDTO)){
            Spark_Style.show_mesg_correct("Usuario creado ", "Estado");
            name_person_box.setText("");
            last_name_person_box.setText("");
            DNI_person_box.setText("0");
            Birthdate_person_box.setText("");
            Password_person_box.setText("");
            Email_person_box.setText("");
            return true;
         }
         Spark_Style.show_mesg_advert("El usuario que quiere crear tiene una cedula ya registrado", "Estado");
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}