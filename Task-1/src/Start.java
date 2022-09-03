import Task1.*;
import java.util.*;
public class Start {
    public static void main(String[] args) {
        Employee e1 = new PermanentEmployee(1, "Rahim", 80000);
        Employee e2 = new ContractualEmployee(2, "Karim", 20000);
        Employee e3 = new TemporaryEmployee(3, "Habib");

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        for (Employee e : employeeList) {
            System.out.println("Employee ID: "+e.getEmpId()+
                    " Employee Name: "+ e.getEmpName()+
                    " Employee Bonus: "+ e.getBonus());
        }
        System.out.println("------");
        for (Employee e : employeeList) {
            System.out.println("Employee ID: "+e.getEmpId()+
                    " Employee Name: "+ e.getEmpName()+
                    " Employee is eligible for Provident Fund: "+ e.getProvidentStatus());
        }
    }
}
