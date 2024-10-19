import model.Employee;
import repository.EmployeeRepository;
import repository.Repository;
import util.DatabaseConnection;
import model.Employee;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
            Connection myConn = DatabaseConnection.getInstance();
            Repository<Employee> repository = new EmployeeRepository();

            // Mostrar todos los registros
            repository.findAll().forEach(System.out::println);

            // Mostrar un registro
            System.out.println(repository.getById(3));

            //Insertar un registro
            System.out.println("-----Insertando un empleado----");
            Employee employee = new Employee();
            employee.setFirst_name("Diego");
            employee.setPa_surname("Pimentel");
            employee.setMa_surname("Gutierrez");
            employee.setEmail("diego@example.com");
            employee.setSalary((float) 19000);
            employee.setCurp("AE7825369852125487");
            repository.save(employee);
            System.out.println("-----Nuevo empleado insertado----");
            repository.findAll().forEach(System.out::println);


            // Actualizando un empleado
            System.out.println("----Actualizamos un empleado----");
            Employee employeeUpdate = new Employee();
            employeeUpdate.setId(7);
            employeeUpdate.setFirst_name("Diego");
            employeeUpdate.setPa_surname("Pimentel");
            employeeUpdate.setMa_surname("Rodriguez");
            employeeUpdate.setEmail("diego@example.com");
            employeeUpdate.setSalary((float) 21000);
            repository.save(employeeUpdate);
            System.out.println("-----Empleado actualizado----");
            repository.findAll().forEach(System.out::println);

            // Elimimando empleado
            System.out.println("--Empleado eliminaro--");
            repository.delete(6);
            repository.findAll().forEach(System.out::println);
    }
}