import java.sql.*;

public class ActualizarEliminarDatos {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "G10b4lP455");
            System.out.println("Conexión establecida");

            myStamt = myConn.createStatement();
            int rowAffected = myStamt.executeUpdate("UPDATE employees " + "SET email='francisconavas@gmail.com' " + "WHERE first_name='Fran' ");

            myRes = myStamt.executeQuery("SELECT * FROM employees ");
            while (myRes.next()) {
                System.out.println(myRes.getString("first_name")+ "," + myRes.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al conectar con la base de datos");
        }

    }
}
