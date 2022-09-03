package Task1;

public class ContractualEmployee extends Employee implements EmployeeService{

    public ContractualEmployee(int empId, String empName, double empSalary) {
        super(empId, empName, empSalary);
    }

    public ContractualEmployee(int empId, String empName){
        super(empId, empName);
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
