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
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="employee_id")
    private Long employeeId;

    @Column(name="firstname")
    private String firstname;

    @Column(name="cell_phone")
    private String cellphone;

    @OneToOne(mappedBy="employee", cascade= CascadeType.ALL)
    private EmployeeDetail employeeDetail;

    public Employee() {
    }

    public Employee(String firstname, String cellphone, EmployeeDetail employeeDetail) {
        this.firstname = firstname;
        this.cellphone = cellphone;
        this.employeeDetail = employeeDetail;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }
}
