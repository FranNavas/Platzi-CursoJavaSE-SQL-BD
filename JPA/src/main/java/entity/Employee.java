package entity;

import jakarta.persistence.*;

@Entity
@Table(name="employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "pa_Surname")
    private String pa_Surname;

    @Column(name = "ma_Surname")
    private String ma_Surname;

    private String email;

    private Float salary;

    public Employee() {
    }

    public Employee(int id, String first_name, String pa_SurName, String ma_Surname, String email, Float salary) {
        this.id = id;
        this.first_name = first_name;
        this.pa_Surname = pa_SurName;
        this.ma_Surname = ma_Surname;
        this.email = email;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPaSurName() {
        return pa_Surname;
    }

    public void setPaSurName(String pa_Surname) {
        this.pa_Surname = pa_Surname;
    }

    public String getMa_Surname() {
        return ma_Surname;
    }

    public void setMaSurname(String ma_Surname) {
        this.ma_Surname = ma_Surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + first_name + '\'' +
                ", paSurName='" + pa_Surname + '\'' +
                ", maSurname='" + ma_Surname + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}

