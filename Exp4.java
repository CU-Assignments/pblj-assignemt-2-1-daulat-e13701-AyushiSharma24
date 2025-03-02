import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class Exp4 {
    private ArrayList<Employee> employeeList;

    public Exp4() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        employeeList.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!\n");
    }

    public void updateEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (Employee emp : employeeList) {
            if (emp.id == id) {
                System.out.print("Enter new Name: ");
                emp.name = sc.nextLine();

                System.out.print("Enter new Salary: ");
                emp.salary = sc.nextDouble();

                System.out.println("Employee updated successfully!\n");
                return;
            }
        }
        System.out.println("Employee not found!\n");
    }

    public void removeEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to remove: ");
        int id = sc.nextInt();

        for (Employee emp : employeeList) {
            if (emp.id == id) {
                employeeList.remove(emp);
                System.out.println("Employee removed successfully!\n");
                return;
            }
        }
        System.out.println("Employee not found!\n");
    }

    public void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (Employee emp : employeeList) {
            if (emp.id == id) {
                System.out.println("Employee Found: " + emp);
                return;
            }
        }
        System.out.println("Employee not found!\n");
    }

    public void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found!\n");
            return;
        }
        System.out.println("Employee List:");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Exp4 app = new Exp4();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1) Add Employee");
            System.out.println("2) Update Employee");
            System.out.println("3) Remove Employee");
            System.out.println("4) Search Employee");
            System.out.println("5) Display All Employees");
            System.out.println("6) Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: app.addEmployee(sc); break;
                case 2: app.updateEmployee(sc); break;
                case 3: app.removeEmployee(sc); break;
                case 4: app.searchEmployee(sc); break;
                case 5: app.displayEmployees(); break;
                case 6: System.out.println("Exiting..."); sc.close(); return;
                default: System.out.println("Invalid choice! Try again.\n");
            }
        }
    }
}
