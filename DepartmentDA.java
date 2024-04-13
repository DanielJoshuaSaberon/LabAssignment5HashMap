package LabAssignment5HashMap;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class DepartmentDA {
    private Map<String, Department> departmentMap;
    private EmployeeDA employeeDA;
    public DepartmentDA() throws IOException {
        this.employeeDA = new EmployeeDA();
        this.departmentMap = new HashMap<>();
        //
        Scanner departmentFile = new Scanner(new FileReader("C:\\Users\\Josh\\IdeaProjects\\JoshSpace\\src\\LabAssignment5HashMap\\dep.csv"));
        departmentFile.nextLine();
        while (departmentFile.hasNext()) {
            String departmentLineData = departmentFile.nextLine();
            String[] departmentLineDataSpecific = departmentLineData.split(",");
            //
            Department department = departmentMap.get(departmentLineDataSpecific[0].trim());
            //
            if (department == null) {
                department = new Department();
                department.setDeptCode(departmentLineDataSpecific[0].trim());
                department.setDeptName(departmentLineDataSpecific[1].trim());
                //
                departmentMap.put(departmentLineDataSpecific[0].trim(), department);
            }
            //
            readDepEmp(department);
            printDepartment(department);
        }
        departmentFile.close();
    }


    private void readDepEmp(Department department) throws FileNotFoundException {
        Scanner depEmpFile = new Scanner(new FileReader("C:\\Users\\Josh\\IdeaProjects\\JoshSpace\\src\\LabAssignment5HashMap\\deptemp.csv"));
        while (depEmpFile.hasNext()) {
            String depEmpLineData = depEmpFile.nextLine();
            String[] depEmpLineDataSpecific = depEmpLineData.split(",");
            //
            if (depEmpLineDataSpecific[0].trim().equals(department.getDeptCode())) {
                Employee employee = employeeDA.getEmployees(depEmpLineDataSpecific[1].trim());
                //
                if (employee != null) {
                    employee.setSalary(Double.parseDouble(depEmpLineDataSpecific[2]));
                    department.getEmployeeMap().put(depEmpLineDataSpecific[1].trim(), employee);
                    department.setDepTotalSalary(department.getDepTotalSalary() + employee.getSalary());
                }
            }
        }
        depEmpFile.close();
    }

    public void printDepartment(Department department) {
        DecimalFormat Dcml = new DecimalFormat("###,###,###.00");
        System.out.println("Department code: " + department.getDeptCode());
        System.out.println("Department name: " + department.getDeptName());
        System.out.println("Department total salary: " + Dcml.format(department.getDepTotalSalary()));
        System.out.println("---------------------Details -------------------------");
        System.out.printf("%-10s%-25s%-5s%n", "EmpNo", "Employee Name", "Salary");
        //
        for (Map.Entry<String, Employee> entryMap : department.getEmployeeMap().entrySet()) {
            System.out.printf("%-10s%-25s%-5s%n", entryMap.getKey(),
                    entryMap.getValue().getLastName() + ", " + entryMap.getValue().getFirstName(), Dcml.format(entryMap.getValue().getSalary()));
        }
        System.out.println();
    }
}