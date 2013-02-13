package pl.itcrowd.jpaExample.OneToOne;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Users: misiek
 * Date: 2/11/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "EMPLOYEEDETAIL")
public class EmployeeDetail {

    /*    @Id
        @Column(name = "employee_id", unique = true, nullable = false)
        @GeneratedValue(generator = "gen")
        @GenericGenerator(name = "gen", strategy = "foreign")*/
    @Id
    @Column(name = "employee_id")
    @GeneratedValue
    private Long employeeId;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Employee employee;

    public EmployeeDetail() {
    }

    public EmployeeDetail(String street, String city, Employee employee) {
        this.street = street;
        this.city = city;
        this.employee = employee;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
