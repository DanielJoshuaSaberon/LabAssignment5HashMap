package LabAssignment5HashMap;
import java.io.*;
import java.util.*;
public class EmployeeDA {
    private HashMap<String, Employee> employeeMap;
    public EmployeeDA() throws FileNotFoundException {
        employeeMap = new HashMap<>();
        readEmployee();
    }
    //
    private void readEmployee() throws FileNotFoundException{
            //
            Scanner employeeFile = new Scanner(new FileReader("C:\\Users\\Josh\\IdeaProjects\\JoshSpace\\src\\LabAssignment5HashMap\\emp.csv"));
            employeeFile.nextLine();
            //
            while (employeeFile.hasNextLine()) {
                String empLineData = employeeFile.nextLine();
                String[] empLineDataSpecific = empLineData.split(",");
                //
                Employee employee = new Employee();
                employee.setEmpNo(empLineDataSpecific[0].trim());
                employee.setLastName(empLineDataSpecific[1].trim());
                employee.setFirstName(empLineDataSpecific[2].trim());
                //
                employeeMap.put(empLineDataSpecific[0].trim(), employee);
            }
            employeeFile.close();
    }
    public Employee getEmployees(String empNo) {
        return employeeMap.get(empNo);
    }
}


