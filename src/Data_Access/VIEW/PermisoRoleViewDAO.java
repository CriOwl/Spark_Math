package Data_Access.VIEW;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.IVIEWDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PermisoRoleViewDAO extends Data_Helper_Sqlite implements IVIEWDAO<PermisoRoleViewDTO> {

    @Override
    public PermisoRoleViewDTO readby(Integer id) throws Exception {
        PermisoRoleViewDTO permisoRole = new PermisoRoleViewDTO();
        String query = "SELECT"
                + " pr.id_permission_role, "
                + " r.name, "
                + " p.name, "
                + " FROM vw_permiso_rol pr "
                + " JOIN Role r ON pr.id_role = r.id_role "
                + " JOIN Permission p ON pr.id_permission = p.id_permission "
                + " WHERE pr.state = 1 AND pr.id_permission_role = ? ";

        try (Connection connect = opConnection();
             PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    permisoRole = new PermisoRoleViewDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3)
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permisoRole;
    }

    @Override
    public PermisoRoleViewDTO readby(String id) throws Exception {
        PermisoRoleViewDTO permisoRole = new PermisoRoleViewDTO();
        String query = "SELECT"
                + " pr.id_permission_role, "
                + " r.name, "
                + " p.name, "
                + " FROM vw_permiso_rol pr "
                + " JOIN Role r ON pr.id_role = r.id_role "
                + " JOIN Permission p ON pr.id_permission = p.id_permission "
                + " WHERE pr.state = 1 AND pr.id_permission_role = ? ";

            try {
                Connection connect = opConnection();
                PreparedStatement stmt = connect.prepareStatement(query);
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    permisoRole = new PermisoRoleViewDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3)
                    );
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return permisoRole;
        
    }

    @Override
    public List<PermisoRoleViewDTO> readall() throws Exception {
        List<PermisoRoleViewDTO> permisoRoles = new ArrayList<>();
        String query = "SELECT"
                + " pr.id_permission_role, "
                + " r.name, "
                + " p.name "
                + " FROM vw_permiso_rol pr "
                + " JOIN Role r ON pr.id_role = r.id_role "
                + " JOIN Permission p ON pr.id_permission = p.id_permission "
                + " WHERE pr.state = 1 ";

        try (Connection connect = opConnection();
             PreparedStatement stmt = connect.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PermisoRoleViewDTO permisoRole = new PermisoRoleViewDTO(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3) 
                );
                permisoRoles.add(permisoRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permisoRoles;
    }

    @Override
    public List<PermisoRoleViewDTO> read_column() throws Exception {
        List<PermisoRoleViewDTO> columns = new ArrayList<>();
        PermisoRoleViewDTO column = new PermisoRoleViewDTO();
        String query = "PRAGMA table_info(vw_permiso_rol)";

        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                    column = new PermisoRoleViewDTO(
                        rs.getString(2)
                );
                columns.add(column);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return columns;        
    }

    @Override
    public List<PermisoRoleViewDTO> search_read(String DNI) throws Exception {
        List<PermisoRoleViewDTO> permisoRoles = new ArrayList<>();
        PermisoRoleViewDTO permisoRole = new PermisoRoleViewDTO();
        String query = "SELECT ID, ROL, PERMISO FROM vw_permiso_rol WHERE ROL LIKE ?";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%" + DNI + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                permisoRole = new PermisoRoleViewDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                permisoRoles.add(permisoRole);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return permisoRoles;
        
    }

    @Override
    public List<PermisoRoleViewDTO> read_combobox() throws Exception {
        List<PermisoRoleViewDTO> list_permisoRoles = new ArrayList<>();
        String query = "SELECT "
        + " pr.id_permission_role, "
        + " r.name, "
        + " p.name "
        + " FROM vw_permiso_rol pr "
        + " JOIN Role r ON pr.id_role = r.id_role "
        + " JOIN Permission p ON pr.id_permission = p.id_permission ";
        
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, 3);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PermisoRoleViewDTO permisoRole = new PermisoRoleViewDTO(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3)  
                );
                list_permisoRoles.add(permisoRole);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list_permisoRoles;
    }

}
