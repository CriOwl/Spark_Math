import Data_Access.DTO.Game1DTO;
import Data_Access.Data_Helper_Sqlite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Game1DAO extends Data_Helper_Sqlite implements IDAO<Game1DTO>{
    
    @Override
    public Game1DTO readby(Integer id) throws Exception {
        Game1DTO oS = new Game1DTO();
        String query =" SELECT id_game1      " 
                     +" ,question            " 
                     +" ,answer1             " 
                     +" ,answer2             " 
                     +" ,correct_answer      " 
                     +" ,state               " 
                     +" ,date_created        " 
                     +" ,date_updated        "
                     +" FROM    Game1        "
                     +" WHERE   state ='1' AND id_game1 =   "+ id.toString() ;
        try {
            Connection conn = opConnection();             
            Statement  stmt = conn.createStatement();     
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                oS = new Game1DTO(rs.getInt(1)                // Id_game1
                                ,rs.getString(2)              // question 
                                ,rs.getString(3)              // answer1
                                ,rs.getString(4)              // answer2
                                ,rs.getInt(5)                 // correct_answer          
                                ,rs.getInt(6)                 // state        
                                ,rs.getString(7)              // date_created      
                                ,rs.getString(8));            // date_update
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    @Override
    public List<Game1DTO> readall() throws Exception {
        List <Game1DTO> lst = new ArrayList<>();
        String query =" SELECT id_game1       " 
                     +" ,question             " 
                     +" ,answer1              " 
                     +" ,answer2              " 
                     +" ,correct_answer       " 
                     +" ,state                " 
                     +" ,date_created         " 
                     +" ,date_updated         "
                     +" FROM    Game1         "
                     +" WHERE   state ='1'    ";

        try {
            Connection conn = opConnection();           
            Statement  stmt = conn.createStatement();     
            ResultSet rs   = stmt.executeQuery(query);    
            while (rs.next()) {
                Game1DTO s = new Game1DTO(rs.getInt(1)                    // id_game1
                                            ,rs.getString(2)              // question 
                                            ,rs.getString(3)              // answer1
                                            ,rs.getString(4)              // answer2
                                            ,rs.getInt(5)                 // correct_answer          
                                            ,rs.getInt(6)                 // state        
                                            ,rs.getString(7)              // date_created      
                                            ,rs.getString(8));            // date_update
             lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return lst; 
    }

    @Override
    public boolean created(Game1DTO entity) throws Exception {
        String query = " INSERT INTO Game1 (question, answer1, answer2, correct_answer) VALUES (?)";
        try {
            Connection        conn  = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getQuestion());
            pstmt.setString(2, entity.getAnswer1());
            pstmt.setString(3, entity.getAnswer2());
            pstmt.setInt(4, entity.getCorrect_answer());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(Game1DTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Game1 SET question = ?, answer1 = ?, answer2 = ?, correct_answer = ?, date_updated = ? WHERE id_game1 = ?";
        try {
            Connection          conn = opConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getQuestion());
            pstmt.setString(2, entity.getAnswer1());
            pstmt.setString(3, entity.getAnswer2());
            pstmt.setInt(4, entity.getCorrect_answer());
            pstmt.setString(5, dtf.format(now).toString());
            pstmt.setInt(6, entity.getId_game1());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE Game1 SET state = ? WHERE id_game1 = ?";
        try {
            Connection          conn = opConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM Game1 "
                     +" WHERE   state ='A' ";
        try {
            Connection conn = opConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}

