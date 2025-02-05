package UserInterface.Form;


import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.DAO_C.InstitutionDAO;
import Data_Access.DAO.DAO_C.PersonDAO;
import Data_Access.DAO.DAO_C.RoleDAO;
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

public class Update_panel_person extends JPanel {
    private Text_label name_person ;
    private Text_label last_name_person ;
    private Text_label DNI_person ;
    private Text_label Birthdate_person ;
    private Text_label Password_person ;
    private Text_label id_role_person ;
    private Text_label Email_person ;
    private Text_label State_person ;
    private Text_label institution_person;
    private Text_label search_dni;
    private Text_box name_person_box ;
    private Text_box last_name_person_box ;
    private Text_box DNI_person_box ;
    private Text_box Birthdate_person_box ;
    private Text_box Password_person_box ;
    private Text_box Email_person_box ;
    private Text_box search_dni_box;
    private JComboBox<String> State_person_box ;
    private JComboBox<String> role;
    private JComboBox<String> institution;
    private String [] array_institution;
    private String [] array_role;
    private Button_Text send;
    private Button_Text cancel;
    private Button_Text search;
    private HashMap<String, Integer> Institucion_map = new HashMap<>();
    private HashMap<String, Integer> Role_map = new HashMap<>();
    private HashMap<String, Integer> state_map = new HashMap<>();
    Integer id_person;
    
    public Update_panel_person() {
        setup_panel();
    }

    private void setup_panel() {
        setLayout(new GridBagLayout());
        name_person = new Text_label("Nombre:");
        last_name_person = new Text_label("Apellido:");
        DNI_person = new Text_label("DNI:");
        Birthdate_person = new Text_label("Fecha de nacimiento:");
        Password_person = new Text_label("Contraseña:");
        id_role_person = new Text_label("Rol:");
        Email_person = new Text_label("Email:");
        State_person = new Text_label("Estado:");
        institution_person = new Text_label("Institucion:");
        search_dni= new Text_label("Buscar por DNI");
        search_dni_box=new Text_box();
        name_person_box = new Text_box();
        last_name_person_box = new Text_box();
        DNI_person_box = new Text_box();
        Birthdate_person_box = new Text_box();
        Password_person_box = new Text_box();
        Email_person_box = new Text_box();
        State_person_box = new JComboBox<>(data_estado());
        role=new JComboBox<>(data_rol());
        institution=new JComboBox<>(data_institution());
        ((AbstractDocument) DNI_person_box.getDocument()).setDocumentFilter(new Mascaras(10));
        send=new Button_Text("Enviar", Spark_Style.FONT, null);
        send.addActionListener(e->validate_data());
        cancel=new Button_Text("Cancelar", Spark_Style.FONT, null);
        search=new Button_Text("Buscar", Spark_Style.FONT, null);
        search.addActionListener(e->search_data());
        cancel.setBackground(new Color(200,0,0));
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,20,5,20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        add(search_dni, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill=GridBagConstraints.BOTH;
        add(search_dni_box, gbc);
        gbc.gridx = 2;
        gbc.fill=GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        add(search, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(name_person, gbc);
        gbc.gridy = 2;
        add(name_person_box, gbc);
        gbc.gridy = 3;
        add(last_name_person, gbc);
        gbc.gridy = 4;
        add(last_name_person_box, gbc);
        gbc.gridy = 5;
        add(DNI_person, gbc);
        gbc.gridy = 6;
        add(DNI_person_box, gbc);
        gbc.gridy = 7;
        add(Birthdate_person, gbc);
        gbc.gridy = 8;
        add(Birthdate_person_box, gbc);
        gbc.gridy = 9;
        add(Password_person, gbc);
        gbc.gridy = 10;
        add(Password_person_box, gbc);
        gbc.gridy = 11;
        add(id_role_person, gbc);
        gbc.gridy = 12;
        add(role, gbc);
        gbc.gridy = 13;
        add(Email_person, gbc);
        gbc.gridy = 14;
        add(Email_person_box, gbc);
        gbc.gridy = 15;
        add(State_person, gbc);
        gbc.gridy = 16;
        add(State_person_box, gbc);
        gbc.gridy = 17;
        add(institution_person, gbc);
        gbc.gridy = 18;
        add(institution, gbc);
        gbc.gridy = 19;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(send, gbc);
        gbc.gridy = 20;
        gbc.anchor = GridBagConstraints.EAST;
        add(cancel, gbc);
    }

    private String[] data_institution(){
        try {
            BL_generalyTable<InstitutionDTO> bl_institution=new BL_generalyTable<>(InstitutionDAO::new);
            List<InstitutionDTO> list_institution=bl_institution.read_elments();
            array_institution=new String [list_institution.size()];
            for (int index = 0; index < list_institution.size(); index++) {
                array_institution[index]=list_institution.get(index).getName();
                Institucion_map.put(list_institution.get(index).getName(), list_institution.get(index).getId_institution());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return array_institution;
    }

    private String[] data_rol(){
        BL_generalyTable<RoleDTO> bl_rol = new BL_generalyTable<>(RoleDAO::new);
        try {
            List<RoleDTO> list_role=bl_rol.read_elments();
            array_role=new String [list_role.size()];
            for (int index = 0; index < list_role.size(); index++) {
                array_role[index]=list_role.get(index).getName();
                Role_map.put(list_role.get(index).getName(), list_role.get(index).getId_Role());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return array_role;
    }

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
        int id_role= Role_map.get(role.getSelectedItem());
        int id_institution=Institucion_map.get(institution.getSelectedItem());
        int state=state_map.get(State_person_box.getSelectedItem());
        if(name.isEmpty()||last_name.isEmpty()||dni.isEmpty()||birthdat.isEmpty()||password.isEmpty()||email.isEmpty()||id_role==0){
            Spark_Style.show_mesg_advert("Complete todos los campos", "Registrar");
            return;
        }
        PersonDTO person_created = new PersonDTO(id_person,name,last_name,dni,email,password,birthdat,id_role,id_institution,state);
        send_data(person_created);
    }
    public boolean send_data(PersonDTO person){
        BL_generalyTable<PersonDTO> table_person=new BL_generalyTable<>(PersonDAO::new);
        try {
         if(table_person.update_elements(person)){
            Spark_Style.show_mesg_correct("Usuario creado ", "Estado");
            name_person_box.setText("");
            last_name_person_box.setText("");
            DNI_person_box.setText("0");
            Birthdate_person_box.setText("");
            Password_person_box.setText("");
            Email_person_box.setText("");
            return true;
         }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    private void search_data(){
        BL_generalyTable<PersonDTO> bl_person=new BL_generalyTable<>(PersonDAO::new);
        try {
        PersonDTO person= bl_person.search_single(search_dni_box.getText());
        System.out.println(person.getId_institution());
            name_person_box.setText(person.getName());
            last_name_person_box.setText(person.getLast_name());
            DNI_person_box.setText(person.getDNI());
            Birthdate_person_box.setText(person.getBirthdate());
            Password_person_box.setText(person.getPassword());
            Email_person_box.setText(person.getEmail());
            role.setSelectedItem(search(Role_map,person.getId_role()));
            institution.setSelectedItem(search(Institucion_map,person.getId_institution()));
            State_person_box.setSelectedItem(search(state_map,person.getId_state()));
            id_person=person.getId_person();
            System.out.println(person.getId_role());
        } catch (Exception e) {
        }
    }
    private <name,id> name search(Map<name,id> map,id value){
    for (Map.Entry<name, id> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        return null; 
    }
}
