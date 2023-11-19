package organization;

public class Department {

    private String departmentName;
    private Employee[] employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new Employee[0];
    }

    public Department(Employee[] employees) {
        this.employees = employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int totalEmployees() {
        return this.employees.length;
    }

    public double totalSalary() {
        double sum = 0;
        for (int i = 0; i < this.employees.length; i++) {
            sum = sum + employees[i].getSalary();
        }
        return sum;
    }

    public Employee employeeReference(String firstName, String lastName) {
        for (Employee employee: employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        return null;
    }

    public void removeEmployee(String lastName, String firstName, String jobTitle) {
        Employee employeeToRemove = null;
        int index = 0;
        for (Employee employee: employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName) && employee.getJobTitle().equals(jobTitle)) {
                employeeToRemove = employee;
                break;
            }
            index++;
        }

        Employee[] newEmployeesList = new Employee[this.employees.length - 1];

        int j = 0;
        for (int i = 0; i < this.employees.length; i++) {
            if(i == index) {
                continue;
            }
            else {
                newEmployeesList[j] = this.employees[i];
                j++;
            }
        }

        this.employees = newEmployeesList;
    }

    public void hireEmployee(Employee newJoiner){
        if (this.employees.length == 0) {
            this.employees = new Employee[]{newJoiner};
        }
        else {
            Employee[] newEmployees = new Employee[this.employees.length + 1];
            for (int i = 0; i < this.employees.length; i++) {
                newEmployees[i] = this.employees[i];
            }
            newEmployees[newEmployees.length - 1] = newJoiner;
            this.employees = newEmployees;
        }
    }

    public Employee[] sortedEmployees() {
        Employee[] sortedEmployees = employees.clone();
        Employee temp;

        for (int i = 0; i < sortedEmployees.length - 1; i++) {
            for (int j = 0; j < sortedEmployees.length - i - 1; j++) {
                if (compareStrings(sortedEmployees[j].getLastName(), sortedEmployees[j + 1].getLastName()) > 0) {
                    //when the difference is positive -> swap elements (due to the ASCII code)
                    temp = sortedEmployees[j];
                    sortedEmployees[j] = sortedEmployees[j + 1];
                    sortedEmployees[j + 1] = temp;
                }
                else {
                    if (sortedEmployees[j].getLastName().equals(sortedEmployees[j + 1].getLastName()))
                        if (compareStrings(sortedEmployees[j].getFirstName(), sortedEmployees[j + 1].getFirstName()) > 0) {
                            temp = sortedEmployees[j];
                            sortedEmployees[j] = sortedEmployees[j + 1];
                            sortedEmployees[j + 1] = temp;
                        }
                }
            }
        }
        return sortedEmployees;
    }
    private int compareStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            int difference = str1.charAt(i) - str2.charAt(i);
            if (difference != 0) {
                return difference;
            }
        }
        return str1.length() - str2.length();
    }
}
