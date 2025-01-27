package Data_Access.VIEW;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.DTO.PersonDTO;
import Data_Access.VIEW.*;
import java.awt.Graphics;
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
import java.sql.SQLException;


public class LoginDAO extends Data_Helper_Sqlite {

    public LoginDTO login(String DNI){
        LoginDTO person=new LoginDTO();
        String query="SELECT "
                    +"p.id_person, "
                    +"p.name, "
                    +"p.last_name, "
                    +"p.DNI, "
                    +"p.email, "
                    +"p.password, "
                    +"p.id_role, "
                    +"r.name, " 
                    +"p.state "
                    +"FROM  vw_persona p "
                    +"JOIN Role r ON p.id_role=r.id_role "
                    +"WHERE p.state= 1 AND p.DNI = ?";
        try {
            Connection connect= opConnection();
            PreparedStatement stmt= connect.prepareStatement(query);
            stmt.setString(1, DNI);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                person= new LoginDTO(
                    rs.getInt(1),
                    rs.getString(2)+" "+rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7),
                    rs.getString(8),
                    rs.getInt(9)
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return person;
    }
}
