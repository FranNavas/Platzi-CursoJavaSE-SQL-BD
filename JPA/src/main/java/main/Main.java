package main;

import util.UtilEntity;
import entity.Employee;

import jakarta.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery("SELECT e from Employee e", Employee.class).getResultList();
        System.out.println("-----Listar todos-----");
        employees.forEach(System.out::println);

        System.out.println("----Buscar uno----");
        int employeeId = 3;
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empleado encontrado: " + employee);

        /*
        System.out.println("----Crear un empleado----");
        Employee newEmployee = new Employee();
        newEmployee.setFirst_name("Fran");
        newEmployee.setPaSurName("Navas");
        newEmployee.setMaSurname("Martin de Pozuelo");
        newEmployee.setEmail("francisconavas@mediagenesis.net");
        newEmployee.setSalary((float) 60000);
        em.getTransaction().begin();
        em.persist(newEmployee);

        // Iniciando la transaccion
        em.getTransaction().commit();
        System.out.println("Nuevo empleado creado " + newEmployee);
        em.close();
         */

        System.out.println("----Actualizar----");
        int employeeToUpdateId = 2;
        Employee employeeToUpdate = em.find(Employee.class, employeeToUpdateId);
        System.out.println("Empleado a modificar: " + employeeToUpdate);
        employeeToUpdate.setPaSurName("LaHostia");
        employeeToUpdate.setSalary((float)97000);

        // Iniciando la transaccion de actualizacion
        em.getTransaction().begin();
        em.merge(employeeToUpdate);
        em.getTransaction().commit();
        System.out.println("Empleado actualizado: " + employeeToUpdate);
        // em.close();

        System.out.println("----Eliminar-----");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        // Iniciado la transaccion para la eliminacion
        System.out.println("Empleado eliminado: " + employeeToDelete);
        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        System.out.println("Empleado eliminado: " + employeeToDelete);
        em.close();
    }
}

