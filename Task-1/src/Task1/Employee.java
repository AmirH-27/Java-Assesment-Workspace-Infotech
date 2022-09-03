package Task1;

public class Employee implements EmployeeService{
    private int empId;
    private String empName;
    private double empSalary = 15000;

    public Employee(int empId, String empName, double empSalary){
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
    }
    public Employee(int empId, String empName){
        this.empId = empId;
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    @Override
    public double getBonus() {
        return 0;
    }

    @Override
    public boolean getProvidentStatus() {
        return false;
    }
}
