import java.sql.*;

public class LeerCrearDatos {
    public static void main(String[] args) {
        Connection myConn = null;
        PreparedStatement myStamt = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "G10b4lP455");
            System.out.println("Conexión establecida");

            String sql = "INSERT INTO employees (first_name, pa_surname) VALUES (?, ?)";
            myStamt = myConn.prepareStatement(sql);
            myStamt.setString(1, "Fran");
            myStamt.setString(2, "Navas");

            int rowAffected = myStamt.executeUpdate();

            if (rowAffected > 0) {
                System.out.println("Se ha creado un nuevo empleado");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al conectar con la base de datos");
        }

    }
}
