package organization;

public class Main {

    public static void main(String[] args) {

        Department financeDepartment = new Department("Finance");

        Employee employee1 = new Employee("Harry", "Potter", "Auror", 24000);
        Employee employee2 = new Employee("Ron", "Weasley", "Auror", 21000);

        financeDepartment.hireEmployee(employee1);
        financeDepartment.hireEmployee(employee2);

        System.out.println("Total employees: " + financeDepartment.totalEmployees());
        System.out.println("Total salary: " + financeDepartment.totalSalary());

    //    financeDepartment.removeEmployee("Potter", "Harry", "Auror");

        Employee employeeToRemove = financeDepartment.employeeReference("Harry", "Potter");
        financeDepartment.removeEmployee(employeeToRemove.getLastName(), employeeToRemove.getFirstName(), employeeToRemove.getJobTitle());

        System.out.println("Total employees: " + financeDepartment.totalEmployees());

        Employee newEmployee1 = new Employee("Hermione", "Granger", "Minister for Magic", 35000);
        financeDepartment.hireEmployee(newEmployee1);

        System.out.println("Total employees after new joiners: " + financeDepartment.totalEmployees());

        Employee newEmployee2 = new Employee("George", "Weasley", "Weasleys' Wizard Wheezes", 30000);
        financeDepartment.hireEmployee(newEmployee2);

        Employee[] sortedEmployees = financeDepartment.sortedEmployees();

        System.out.println("Sorted employees:");
        for(Employee employee: sortedEmployees) {
            System.out.println(employee);
        }
    }
    }

