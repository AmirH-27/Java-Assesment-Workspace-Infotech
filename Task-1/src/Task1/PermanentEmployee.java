package Task1;

public class PermanentEmployee extends Employee implements EmployeeService{

    public PermanentEmployee(int empId, String empName, double empSalary) {
        super(empId, empName, empSalary);
    }

    public PermanentEmployee(int empId, String empName) {
        super(empId, empName);
    }
    @Override
    public double getBonus(){
        return getEmpSalary()/2;
    }

    @Override
    public boolean getProvidentStatus() {
        return true;
    }
}
