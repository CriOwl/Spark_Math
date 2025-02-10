package Data_Access.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Data_Access.Data_Helper_Sqlite;
import Data_Access.DAO.DAO_C.IDAO;
import Data_Access.DTO.CourseDTO;

public class CourseDAO extends Data_Helper_Sqlite implements IDAO<CourseDTO>{
    
    @Override
    public CourseDTO readby(Integer id) throws Exception {
        CourseDTO oS = new CourseDTO();
        String query =" SELECT id_course                     " 
                     +" ,id_teacher                          "
                     +" ,id_catalog_level                    "
                     +" ,id_catalog_parallel                 "
                     +" ,id_institution                      "
                     +" ,id_catalog_time                     "
                     +" ,id_catalog_period                   "
                     +" ,state                               " 
                     +" ,date_created                        " 
                     +" ,date_updated                        "
                     +" FROM    Course                       "
                     +" WHERE   state ='1' AND id_course =   "+ id.toString() ;
        try {
            Connection conn = opConnection();            // conectar a DB     
            Statement  stmt = conn.createStatement();    // CRUD : select * ...    
            ResultSet rs    = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new CourseDTO(rs.getInt(1)          // Id_course
                                  ,rs.getInt(2)          // id_teacher 
                                  ,rs.getInt(3)          // id_catalog_level
                                  ,rs.getInt(4)          // id_catalog_parallel
                                  ,rs.getInt(5)          // id_institution
                                  ,rs.getInt(6)          // id_catalog_time 
                                  ,rs.getInt(7)          // id_catalog_period 
                                  ,rs.getInt(8)          // state        
                                  ,rs.getString(9)       // date_created      
                                  ,rs.getString(10));    // date_update
            }
        } 
        catch (SQLException e) {
            throw e;                                     // new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<CourseDTO> readall() throws Exception {
        List <CourseDTO> lst = new ArrayList<>();
        String query =" SELECT id_course         " 
                     +" ,id_teacher              "
                     +" ,id_catalog_level        "
                     +" ,id_catalog_parallel     "
                     +" ,id_institution          "
                     +" ,id_catalog_time         "
                     +" ,id_catalog_period       "
                     +" ,state                   " 
                     +" ,date_created            " 
                     +" ,date_updated            "
                     +" FROM    Course           "
                     +" WHERE   state ='1'       ";

        try {
            Connection conn = opConnection();                     // conectar a DB     
            Statement  stmt = conn.createStatement();             // CRUD : select * ...    
            ResultSet rs    = stmt.executeQuery(query);           // ejecutar la
            while (rs.next()) {
                CourseDTO s = new CourseDTO(rs.getInt(1)          // Id_course
                                           ,rs.getInt(2)          // id_teacher 
                                           ,rs.getInt(3)          // id_catalog_level
                                           ,rs.getInt(4)          // id_catalog_parallel
                                           ,rs.getInt(5)          // id_institution
                                           ,rs.getInt(6)          // id_catalog_time 
                                           ,rs.getInt(7)          // id_catalog_period 
                                           ,rs.getInt(8)          // state        
                                           ,rs.getString(9)       // date_created      
                                           ,rs.getString(10));    // date_update
             lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;                                               // new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean created(CourseDTO entity) throws Exception {
        String query = " INSERT INTO Course (id_teacher, id_catalog_level, id_catalog_parralel, id_institution, id_catalog_time, id_catalog_period) VALUES (?)";
        try {
            Connection        conn  = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_teacher());
            pstmt.setInt(2, entity.getId_catalog_level());
            pstmt.setInt(3, entity.getId_catalog_parallel());
            pstmt.setInt(4, entity.getId_institution());
            pstmt.setInt(5, entity.getId_catalog_time());
            pstmt.setInt(6, entity.getId_catalog_period());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;                                               // new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(CourseDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Course SET id_teacher = ?, id_catalog_level = ?, id_catalog_parallel = ?, id_institution = ?, id_catalog_time = ?, id_catalog_period = ?, date_updated = ? WHERE id_course = ?";
        try {
            Connection          conn = opConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getId_teacher());
            pstmt.setInt(2, entity.getId_catalog_level());
            pstmt.setInt(3, entity.getId_catalog_parallel());
            pstmt.setInt(4, entity.getId_institution());
            pstmt.setInt(5, entity.getId_catalog_time());
            pstmt.setInt(6, entity.getId_catalog_period());
            pstmt.setString(7, dtf.format(now).toString());
            pstmt.setInt(8, entity.getId_course());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;                                               // new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Course SET state = ? WHERE id_course = ?";
        try {
            Connection          conn = opConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;                                               // new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM Course "
                     +" WHERE   state ='A' ";
        try {
            Connection conn = opConnection();            // conectar a DB     
            Statement  stmt = conn.createStatement();    // CRUD : select * ...    
            ResultSet rs    = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                     // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e;                                               // new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }

    @Override
    public List<CourseDTO> read_combobox() throws Exception {
        List<CourseDTO> list_course = new ArrayList<>();
        String querry = "SELECT c.id_course, " 
                 + " cl.name AS level_name, "   
                 + " cp.name AS parallel_name " 
                 + " FROM Course c "
                 + " JOIN Catalog cl ON c.id_catalog_level = cl.id_catalog " 
                 + " JOIN Catalog cp ON c.id_catalog_parallel = cp.id_catalog " 
                 + " WHERE c.state = '1'";
        try {
            Connection cone = opConnection();
            Statement stmt = cone.createStatement();
            ResultSet rs = stmt.executeQuery(querry);
            while (rs.next()) {
                CourseDTO course = new CourseDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            list_course.add(course);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list_course;
    }

    @Override
    public List<CourseDTO> read_combobox2() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_combobox2'");
    }

    @Override
    public List<CourseDTO> read_column() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read_column'");
    }

    @Override
    public List<CourseDTO> search_read(String DNI) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search_read'");
    }

    @Override
    public CourseDTO search_read_single(String DNI) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search_read_single'");
    }
}
