import util.DatabaseConnection;
import model.Employee;
import repository.EmployeeRepository;
import repository.Repository;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try(Connection myConn = DatabaseConnection.getInstance()){
            if(myConn.getAutoCommit()){
                myConn.setAutoCommit(false);
            }
            try{
                Repository<Employee> repository = new EmployeeRepository(myConn);
                System.out.println("----Insertar un nuevo cliente-----");
                Employee employee = new Employee();
                employee.setFirst_name("Gregorio");
                employee.setPa_surname("Marañon");
                employee.setMa_surname("Rodriguez");
                employee.setEmail("gregorio@example.com");
                employee.setSalary((float)21000);
                employee.setCurp("AMEC23659874123654");
                repository.save(employee);
                myConn.commit();
            } catch (SQLException e) {
                myConn.rollback();
                throw new SQLException(e);
            }
        }
    }
}
