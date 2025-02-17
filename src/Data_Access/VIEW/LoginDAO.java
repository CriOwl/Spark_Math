package Data_Access.VIEW;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.IVIEWDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO extends Data_Helper_Sqlite implements IVIEWDAO<LoginDTO> {
    @Override
    public LoginDTO readby(String DNI) throws Exception {
        LoginDTO person = new LoginDTO();
        String query = "SELECT "
                + "p.id_person, "
                + "p.name, "
                + "p.last_name, "
                + "p.DNI, "
                + "p.email, "
                + "p.password, "
                + "p.id_role, "
                + "r.name, "
                + "p.state "
                + "FROM  vw_persona p "
                + "JOIN Role r ON p.id_role=r.id_role "
                + "WHERE p.state= 1 AND p.DNI = ?";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, DNI);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                person = new LoginDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return person;
    }

    @Override
    public List<LoginDTO> readall() throws Exception {
        List<LoginDTO> persons = new ArrayList<>();
        LoginDTO person = new LoginDTO();
        String query = "SELECT "
                + "ID, "
                + "NOMBRE, "
                + "APELLIDO, "
                + "CEDULA, "
                + "EMAIL, "
                + "CLAVE, "
                + "ROL, "
                + "ESTADO "
                + "FROM  vw_persona  ";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                person = new LoginDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
                persons.add(person);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return persons;
    }

    @Override
    public List<LoginDTO> read_column() throws Exception {
        List<LoginDTO> columns = new ArrayList<>();
        LoginDTO column = new LoginDTO();
        String query = "PRAGMA table_info(vw_persona) ";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                column = new LoginDTO(
                        rs.getString(2)

                );
                columns.add(column);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return columns;
    }
    @Override
    public List<LoginDTO> search_read(String DNI) throws Exception {
        List<LoginDTO> persons = new ArrayList<>();
        LoginDTO person = new LoginDTO();
        String query = "SELECT "
                + "ID, "
                + "NOMBRE, "
                + "APELLIDO, "
                + "CEDULA, "
                + "EMAIL, "
                + "CLAVE, "
                + "ROL, "
                + "ESTADO "
                + "FROM  vw_persona  "
                + "WHERE ESTADO= 1 AND CEDULA LIKE ? ";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%"+DNI+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                person = new LoginDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getInt(8));
                persons.add(person);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return persons;
    }
    @Override
    public LoginDTO readby(Integer id) throws Exception {
        LoginDTO person = new LoginDTO();
        String query = "SELECT "
                + "p.id_person, "
                + "p.name, "
                + "p.last_name, "
                + "p.DNI, "
                + "p.email, "
                + "p.password, "
                + "p.id_role, "
                + "r.name, "
                + "p.state "
                + "FROM  vw_persona p "
                + "JOIN Role r ON p.id_role=r.id_role "
                + "WHERE p.state= 1 AND p.id_person = ?";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                person = new LoginDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return person;
    }
    @Override
    public List<LoginDTO> read_combobox() throws Exception {
        List<LoginDTO> list_person=new ArrayList<>();
        String query = "SELECT "
                        + "p.id_person, "
                        + "p.name, "
                        + "p.last_name, "
                        + "p.DNI "
                        + "FROM  vw_persona p "
                        + "WHERE p.state= 1";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1,4);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LoginDTO person = new LoginDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                        list_person.add(person);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list_person;
    }
    public LoginDTO login(String DNI, String password){
        LoginDTO persona= new LoginDTO();
        String query= "SELECT "
                      +"p.id_person, "
                      +"p.id_role,"   
                      +"r.name "   
                      +"From Persona p "   
                      +"JOIN Role r ON p.id_role=r.id_role "   
                      +"WHERE p.DNI= ? AND p.password= ? ";
        try {
            Connection conect=opConnection();
            PreparedStatement pst=conect.prepareStatement(query);
            pst.setString(1, DNI);
            pst.setString(2, password);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                persona = new LoginDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3)
                    );
                    return persona;
            }
        } catch (Exception e) {
            System.out.println(e);
        }       
        return persona;
    }

}
