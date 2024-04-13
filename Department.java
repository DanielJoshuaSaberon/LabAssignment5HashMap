package LabAssignment5HashMap;
import java.util.HashMap;

public class Department {
    private String deptCode;
    private String deptName;

    private Double depTotalSalary = 0.00;
    private HashMap <String, Employee> employeeMap;

    public Department() {
        employeeMap = new HashMap<>();
    }

    public void setDeptCode(String depCode) {
        this.deptCode = depCode;
    }

    public void setDeptName(String depName) {
        this.deptName = depName;
    }

    public void setDepTotalSalary(Double depTotalSalary) {
        this.depTotalSalary = depTotalSalary;
    }

    public void setEmployeeMap(HashMap<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public Double getDepTotalSalary() {
        return depTotalSalary;
    }

    public HashMap<String, Employee> getEmployeeMap() {
        return employeeMap;
    }
}