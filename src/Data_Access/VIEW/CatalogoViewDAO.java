package Data_Access.VIEW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.IVIEWDAO;

public class CatalogoViewDAO extends Data_Helper_Sqlite implements IVIEWDAO<CatalogoViewDTO> {

    @Override
    public CatalogoViewDTO readby(String id_catalog) throws Exception {
        CatalogoViewDTO catalog = new CatalogoViewDTO();
        String query = "SELECT "
                + "c.id_catalog,  "
                + "c.name, "
                + "cl.id_catalog_name, "
                + "cl.name, "
                + "c.state "
                + "FROM vw_catalog c "
                + "LEFT JOIN Catalog_level cl ON c.id_catalog_level = cl.id_catalog_level "
                + "WHERE c.state = 1 AND c.id_catalog = ? ";

        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, id_catalog);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                catalog = new CatalogoViewDTO(
                        rs.getInt(1), // id_catalog
                        rs.getString(2), // name
                        rs.getInt(3), // id_catalog_level
                        rs.getString(4), // name_level
                        rs.getInt(5) // state
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return catalog;
    }

    @Override
    public List<CatalogoViewDTO> readall() throws Exception {
        List<CatalogoViewDTO> catalogs = new ArrayList<>();
        CatalogoViewDTO catalog = new CatalogoViewDTO();
        String query = "SELECT c.ID, c.NOMBRE, c.TIPO FROM vw_catalog c";
        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                catalog = new CatalogoViewDTO(
                        rs.getInt(1), // id_catalog
                        rs.getString(2), // name
                        rs.getString(3) // name level
                );
                catalogs.add(catalog);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return catalogs;
    }

    @Override
    public List<CatalogoViewDTO> search_read(String name) throws Exception {
        List<CatalogoViewDTO> catalogs = new ArrayList<>();
        CatalogoViewDTO catalog = new CatalogoViewDTO();
        String query = "SELECT c.ID, c.NOMBRE, c.tipo FROM vw_catalog c WHERE c.NOMBRE LIKE ? ";

        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                catalog = new CatalogoViewDTO(
                        rs.getInt(1), // id_catalog
                        rs.getString(2), // name
                        rs.getString(3) // name level

                );
                catalogs.add(catalog);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return catalogs;
    }

    @Override
    public List<CatalogoViewDTO> read_combobox() throws Exception {
        List<CatalogoViewDTO> list_catalog = new ArrayList<>();
        String query = " SELECT"
                + "c.id_catalog, "
                + "c.name, "
                + "cl.name "
                + "FROM bw_catalog c "
                + "JOIN Catalog_level cl ON c.id_catalog_level = cl.id_catalog_level "
                + " WHERE c.state = 1";
        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, 4);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CatalogoViewDTO catalog = new CatalogoViewDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                list_catalog.add(catalog);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list_catalog;
    }

    @Override
    public CatalogoViewDTO readby(Integer id) throws Exception {
        CatalogoViewDTO catalog = new CatalogoViewDTO();
        String query = "SELECT "
                + "c.id_catalog,  "
                + "c.name, "
                + "cl.id_catalog_name, "
                + "cl.name, "
                + "c.state "
                + "FROM vw_catalog c "
                + "LEFT JOIN Catalog_level cl ON c.id_catalog_level = cl.id_catalog_level "
                + "WHERE c.state = 1 AND c.id_catalog = ? ";

        try {
            Connection connect = opConnection();
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                catalog = new CatalogoViewDTO(
                        rs.getInt(1), // id_catalog
                        rs.getString(2), // name
                        rs.getInt(3), // id_catalog_level
                        rs.getString(4), // name_level
                        rs.getInt(5) // state
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return catalog;
    }

    @Override
    public List<CatalogoViewDTO> read_column() throws Exception {
        List<CatalogoViewDTO> columns = new ArrayList<>();
        CatalogoViewDTO column = new CatalogoViewDTO();
        String query = "PRAGMA table_info(vw_catalog)";

        try {
            Connection connect = opConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                column = new CatalogoViewDTO(
                        rs.getString(2)

                );
                columns.add(column);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return columns;
    }

}
