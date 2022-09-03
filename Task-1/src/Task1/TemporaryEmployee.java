package Task1;

public class TemporaryEmployee extends Employee implements EmployeeService{

    public TemporaryEmployee(int empId, String empName, double empSalary) {
        super(empId, empName, empSalary);
    }

    public TemporaryEmployee(int empId, String empName) {
        super(empId, empName);
    }
    @Override
    public double getBonus(){
        return 0;
    }
    @Override
    public boolean getProvidentStatus(){
        return false;
    }
}
