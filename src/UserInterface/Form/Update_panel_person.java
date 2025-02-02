package UserInterface.Form;

import BusinessLogic.BL_USER.BL_generalyTable;
import Data_Access.DAO.DAO_C.InstitutionDAO;
import Data_Access.DTO.InstitutionDTO;
import UserInterface.Customer_control.Text_box;
import UserInterface.Customer_control.Text_label;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Update_panel_person extends JPanel {
    Text_label name_person ;
    Text_label last_name_person ;
    Text_label DNI_person ;
    Text_label Birthdate_person ;
    Text_label Password_person ;
    Text_label id_role_person ;
    Text_label Email_person ;
    Text_label State_person ;
    Text_label institution_person;
    Text_box name_person_box ;
    Text_box last_name_person_box ;
    Text_box DNI_person_box ;
    Text_box Birthdate_person_box ;
    Text_box Password_person_box ;
    Text_box id_role_person_box ;
    Text_box Email_person_box ;
    Text_box State_person_box ;
    Text_box institution_person_box;
    JComboBox<String> id_role;
    JComboBox<String> institution;
    String [] array_institution;
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
        name_person_box = new Text_box();
        last_name_person_box = new Text_box();
        DNI_person_box = new Text_box();
        Birthdate_person_box = new Text_box();
        Password_person_box = new Text_box();
        id_role_person_box = new Text_box();
        Email_person_box = new Text_box();
        State_person_box = new Text_box();
        institution_person_box = new Text_box();
        id_role=new JComboBox<>();
        institution=new JComboBox<>(data_institution());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,20,5,20);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(name_person,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        add(name_person_box,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        add(last_name_person,gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        add(last_name_person_box,gbc);
        gbc.gridx=0;
        gbc.gridy=4;
        add(DNI_person,gbc);
        gbc.gridx=0;
        gbc.gridy=5;
        add(DNI_person_box,gbc);
        gbc.gridx=0;
        gbc.gridy=6;
        add(Birthdate_person,gbc);
        gbc.gridx=0;
        gbc.gridy=7;
        add(Birthdate_person_box,gbc);
        gbc.gridx=0;
        gbc.gridy=8;
        add(Password_person,gbc);
        gbc.gridx=0;
        gbc.gridy=9;
        add(Password_person_box,gbc);
        gbc.gridx=0;
        gbc.gridy=10;
        add(id_role_person,gbc);
        gbc.gridx=0;
        gbc.gridy=11;
        add(id_role,gbc);
        gbc.gridx=0;
        gbc.gridy=12;
        add(Email_person,gbc);
        gbc.gridx=0;
        gbc.gridy=13;
        add(Email_person_box,gbc);
        gbc.gridx=0;
        gbc.gridy=14;
        add(State_person,gbc);
        gbc.gridx=0;
        gbc.gridy=15;
        add(State_person_box,gbc);
        gbc.gridx=0;
        gbc.gridy=16;
        add(institution_person,gbc);
        gbc.gridx=0;
        gbc.gridy=17;
        add(institution,gbc);
    }
    private String[] data_institution(){
        BL_generalyTable<InstitutionDTO> bl_institution = new BL_generalyTable<>(InstitutionDAO::new);
        try {
            List<InstitutionDTO> list_institution=bl_institution.read_elments();
            array_institution=new String [list_institution.size()];
            for (int index = 0; index < list_institution.size(); index++) {
                array_institution[index]=list_institution.get(index).getName();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return array_institution;
    }
    private String[] data_rol(){
        BL_generalyTable<RoleDTO> bl_institution = new BL_generalyTable<>(RoleDAO::new);
        try {
            List<InstitutionDTO> list_institution=bl_institution.read_elments();
            array_institution=new String [list_institution.size()];
            for (int index = 0; index < list_institution.size(); index++) {
                array_institution[index]=list_institution.get(index).getName();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return array_institution;
    }
}
