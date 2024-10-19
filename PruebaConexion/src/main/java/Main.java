import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "G10b4lP455");
            System.out.println("Conexión establecida");
            myStamt = myConn.createStatement();
            myRes = myStamt.executeQuery("select * from employees");
            while (myRes.next()) {
                System.out.println(myRes.getString("first_name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al conectar con la base de datos");
        }

    }
}
