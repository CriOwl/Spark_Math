package Data_Access.DAO.DAO_C;

import Data_Access.DTO.RoleDTO;
import Data_Access.Data_Helper_Sqlite;
import Data_Access.IVIEWDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VWRoleDAO extends Data_Helper_Sqlite implements IVIEWDAO<RoleDTO> {

    @Override
    public RoleDTO readby(Integer id) throws Exception {
        RoleDTO registro = new RoleDTO();
        String query = "SELECT "
                + "r.id_role, "
                + "r.name, "
                + "r.state, "
                + "r.date_created, "
                + "r.date_updated "
                + "FROM role r "
                + "WHERE r.state = 1 AND r.id_role = " + id + ";";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                registro = new RoleDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return registro;
    }

    @Override
    public List<RoleDTO> readall() {
        List<RoleDTO> tabla = new ArrayList<>();
        String query = "SELECT "
                + "r.id_role, "
                + "r.name, "
                + "r.state, "
                + "r.date_created, "
                + "r.date_updated "
                + "FROM role r "
                + "WHERE r.state = 1; ";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RoleDTO list = new RoleDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));
                tabla.add(list);
            }
        } catch (SQLException e) {
            System.out.println(e);
            // throw new PatException(e.getMessage(), getClass().getName(), "readall()");
        }
        return tabla;
    }


    @Override
    public List<RoleDTO> read_combobox() {
        List<RoleDTO> list_role = new ArrayList<>();
        String querry = "SELECT "
                + "r.id_role, "
                + "r.name "
                + "FROM Role r "
                + "WHERE r.state = 1";
        try {
            Connection cone = opConnection();
            Statement stmt = cone.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                RoleDTO roles = new RoleDTO(
                        rs.getInt(1),
                        rs.getString(2));
                        list_role.add(roles);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list_role;
    }

    @Override
    public List<RoleDTO> read_column() throws Exception {
        List<RoleDTO> columns = new ArrayList<>();
        String query = "PRAGMA table_info(Role) ";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RoleDTO column = new RoleDTO(
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
    public List<RoleDTO> search_read(String name) throws Exception {
        List<RoleDTO> tabla = new ArrayList<>();
        RoleDTO registro = new RoleDTO();
        String query = "SELECT "
                + "r.id_role, "
                + "r.name, "
                + "r.state, "
                + "r.date_created, "
                + "r.date_updated "
                + "FROM Role r "
                + "WHERE r.state = 1 AND r.name LIKE ?";
        try {
            Connection conn = opConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%"+name+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                registro = new RoleDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));
                        tabla.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tabla;
    }

    @Override
    public RoleDTO readby(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readby'");
    }
}