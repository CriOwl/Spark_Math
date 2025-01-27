package Data_Access.DAO;

import Data_Access.DTO.Permission_roleDTO;
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

public class PermissionRoleDAO extends Data_Helper_Sqlite implements IDAO<Permission_roleDTO> {

    @Override
<<<<<<< HEAD
    public Permission_roleDTO readBy(Integer id) throws Exception {
=======
    public Permission_roleDTO readby(Integer id) throws Exception {
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
        Permission_roleDTO registro = new Permission_roleDTO();
        String query = "SELECT "
                        + "pr.id_permission_role, "
                        + "pr.id_role, "
                        + "pr.id_permission, "
                        + "pr.state, "
                        + "pr.date_created, "
                        + "pr.date_updated "
                        + "FROM permission_role pr "
<<<<<<< HEAD
=======
                        + "JOIN Role r ON pr.id_role = r.id_role "
                        + "JOIN Permission p ON pr.id_permission = p.id_permission "
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
                        + "WHERE pr.state = 1 AND pr.id_permission_role = " + id + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
<<<<<<< HEAD
                registro = new Permission_roleDTO(rs.getInt(1),
                                                rs.getInt(2),
                                                rs.getInt(3),
                                                rs.getInt(4),
                                                rs.getString(5),
                                                rs.getString(6));
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
=======
                registro = new Permission_roleDTO(  
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
            //throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
        }
        return registro;
    }

    @Override
<<<<<<< HEAD
    public List<Permission_roleDTO> readAll() {
=======
    public List<Permission_roleDTO> readall() {
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
        List<Permission_roleDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                        + "pr.id_permission_role, "
                        + "pr.id_role, "
                        + "pr.id_permission, "
                        + "pr.state, "
                        + "pr.date_created, "
                        + "pr.date_updated "
<<<<<<< HEAD
                        + "FROM permission_role pr;";
=======
                        + "FROM permission_role pr;"
                        + "JOIN Role r ON pr.id_role = r.id_role "
                        + "JOIN Permission p ON pr.id_permission = p.id_permission "
                        + "WHERE pr.state = 1;";
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
<<<<<<< HEAD
                Permission_roleDTO list = new Permission_roleDTO(rs.getInt(1),
                                                                rs.getInt(2),
                                                                rs.getInt(3),
                                                                rs.getInt(4),
                                                                rs.getString(5),
                                                                rs.getString(6));
                tabla.add(list);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
=======
                Permission_roleDTO list = new Permission_roleDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)
                );
                tabla.add(list);
            }
        } catch (SQLException e) {
            System.out.println(e);
            //throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
        }
        return tabla;
    }

    @Override
<<<<<<< HEAD
    public boolean create(Permission_roleDTO entity) throws Exception {
        String query = "INSERT INTO permission_role (id_role, id_permission, state, date_created, date_updated) VALUES (?, ?, ?, ?, ?);";
=======
    public boolean created(Permission_roleDTO entity) throws Exception {
        String query = "INSERT INTO permission_role (id_role, id_permission) VALUES (?, ?);";
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_role());
            pstmt.setInt(2, entity.getId_permission());
<<<<<<< HEAD
            pstmt.setInt(3, entity.getState());
            pstmt.setString(4, entity.getDate_created());
            pstmt.setString(5, entity.getDate_updated());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
=======
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "create()");
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
        }
    }

    @Override
    public boolean update(Permission_roleDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
<<<<<<< HEAD
        String query = "UPDATE permission_role SET id_role = ?, id_permission = ?, state = ?, date_updated = ? WHERE id_permission_role = ?;";
=======
        String query = "UPDATE permission_role SET id_role = ?, id_permission = ?, date_updated = ? WHERE id_permission_role = ?;";
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_role());
            pstmt.setInt(2, entity.getId_permission());
<<<<<<< HEAD
            pstmt.setInt(3, entity.getState());
            pstmt.setString(4, dtf.format(now));
            pstmt.setInt(5, entity.getId_permission_role());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
=======
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt(4, entity.getId_permission_role());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "update()");
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
<<<<<<< HEAD
        String query = "UPDATE permission_role SET state = 0, date_updated = ? WHERE id_permission_role = ?;";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, dtf.format(now));
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public List<Permission_roleDTO> role_permission_read(Integer id_role) throws Exception {
        List<Permission_roleDTO> tabla=new ArrayList<>();
        Permission_roleDTO registro=new Permission_roleDTO();
        String query = "SELECT "
                        + "p.name, "
                        + "pr.state "
                        + "FROM Permission_role pr "
                        + "JOIN Permission p ON pr.id_permission=p.id_permission "
                        + "WHERE pr.state = 1 AND pr.id_role = " + id_role + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro=new Permission_roleDTO(rs.getString(1));
                tabla.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla;
    }
=======
        String query = "UPDATE permission_role SET state = ?, date_updated = ? WHERE id_permission_role = ?;";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
>>>>>>> 0296549c0af69ea1b3dd04b65d95e26a3442a689
}