package Data_Access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Data_Helper_Sqlite {
    private static String Bd_Path = "jdbc:sqlite:database\\MathSpark.sqlite";
    private static Connection conexion = null;

    protected Data_Helper_Sqlite() {
    }

    protected static synchronized Connection opConnection() throws SQLException {
        try {
            if (conexion == null) {
                System.out.println("eeeeeeeeeeeeee");
                conexion = DriverManager.getConnection(Bd_Path);
            }
        } catch (SQLException e) {
            throw e;
        }
        return conexion;
    }

    protected static void closeConnection() throws SQLException {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException es) {
            throw es;
        }
    }
}