package Data_Access.DAO;

import Data_Access.DTO.PersonDTO;
import Data_Access.Data_Helper_Sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends Data_Helper_Sqlite implements IDAO <PersonDTO>{
    @Override
    public PersonDTO readby(Integer id)throws Exception{
        PersonDTO registro=new PersonDTO();
        String query=  "SELECT "
                        +"p.id_person, "
                        +"p.name, "
                        +"p.last_name, "
                        +"p.DNI, "
                        +"p.email, "
                        +"p.password, "
                        +"p.birthdate, "
                        +"r.name," 
                        +"p.state, "
                        +"p.date_created, "
                        +"p.date_updated "
                        +"FROM Persona p "
                        +"JOIN Role r ON p.id_role=r.id_role "
                        +"WHERE p.state= 1 AND p.id_person = "+id;
        try {
            Connection connect= opConnection();
            Statement stmt= connect.createStatement();
            //System.out.println(query);
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()) {
                registro= new PersonDTO(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(5),
                                        rs.getString(6),
                                        rs.getString(7),
                                        rs.getString(8),
                                        rs.getInt(9),
                                        rs.getString(10),
                                        rs.getString(11));          
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return registro;
    }

    @Override
    public List<PersonDTO> readall(){
        List<PersonDTO> tabla=new ArrayList<>();
        String query=   "SELECT "
                        +"p.id_person, "
                        +"p.name, "
                        +"p.last_name, "
                        +"p.DNI, "
                        +"p.email, "
                        +"p.password, "
                        +"p.birthdate, "
                        +"r.name," 
                        +"p.state, "
                        +"p.date_created, "
                        +"p.date_updated "
                        +"FROM Persona p "
                        +"JOIN Role r ON p.id_role=r.id_role "
                        +"WHERE p.state= 1 ";
        try {
            Connection conn = opConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()) {
                PersonDTO list = new PersonDTO(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getString(6),
                                    rs.getString(7),
                                    rs.getString(8),
                                    rs.getInt(9),
                                    rs.getString(10),
                                    rs.getString(11));   
                tabla.add(list);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla;
    }

    @Override
    public boolean created(PersonDTO entity) throws Exception{
        String query="INSERT INTO Person (name, last_name,DNI,email,password,birthdate,id_role) VALUES(?,?,?,?,?,?,?);";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt= conn.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getLast_name());
            pstmt.setString(3, entity.getDNI());
            pstmt.setString(4, entity.getEmail());
            pstmt.setString(5, entity.getPassword());
            pstmt.setString(6, entity.getBirthdate());
            pstmt.setInt(7, (int)entity.getId_role());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(PersonDTO entity)throws Exception{
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        String query="UPDATE Person SET name=?,last_name=?,DNI=?,email=?,password=?,id_role=?,date_update=? Where id_person=?";
        try {
            Connection conect= opConnection();
            PreparedStatement pstmt= conect.prepareStatement(query);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getLast_name());
            pstmt.setString(3, entity.getDNI());
            pstmt.setString(4, entity.getEmail());
            pstmt.setString(5, entity.getPassword());
            pstmt.setInt(6, (int)entity.getId_role());
            pstmt.setString(7, dtf.format(now).toString());
            pstmt.setInt(8, entity.getId_person());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }
    
    @Override
    public boolean delete(Integer id)throws Exception{
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        String query="UPDATE Person SET state=?,date_update=? Where id_person=?";
        try {
            Connection conect= opConnection();
            PreparedStatement pstmt= conect.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.setString(2,dtf.format(now).toString());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
}