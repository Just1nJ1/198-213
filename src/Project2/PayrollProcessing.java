package Project2;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * (...)
 * @author Haochen Ji, Yichen Chen
 */
public class PayrollProcessing {

    public void run() {
        System.out.println("Payroll Processing starts.");

        Company company = new Company();            // Library instance
        Scanner sc = new Scanner(System.in);    // Scanner instance; Scan from console
        String input = sc.nextLine();         // Stores the first command from console
        String number = "";                     // Stores the number of the book if necessary
        StringTokenizer st = null;              // StringTokenizer variable without initial value

        // Stop the loop when the command is Q; Get next line and store it in command variable each loop
        for (; !input.equals("Q"); input = sc.nextLine()){

            st = new StringTokenizer(input, " ");     // ST instance with console input
            String command = st.nextToken();
            String name;
            String department;
            Date date;
            int salary;

            switch (command){                   // switch-case for different command
                case "AP":                      // Add Part time employee
                    if (st.countTokens() != 4){ // Check that the number of parameters is correct
                        System.out.println("Invalid command!");
                        continue;
                    }

                    name = st.nextToken();
                    department = st.nextToken();
                    date = new Date(st.nextToken());
                    double payrate = Double.parseDouble(st.nextToken());
                    if (!date.isValid()){           // Check if the date is valid
                        System.out.println(date.toString() + " is not a valid date!");
                        continue;
                    }

                    if (payrate < 0){
                        System.out.println("Pay rate cannot be negative.");
                        continue;
                    }

                    if (!(department.equals("ECE") || department.equals("CS") || department.equals("IT"))){
                        System.out.println("invalid department code.");
                        continue;
                    }

                    if (!company.add(new Parttime(new Profile(name, department, date), payrate))){
                        System.out.println("Employee is already in the list.");
                        continue;
                    }
                    System.out.println("Employee added.");
                    break;

                case "AF":                      // Add Full time employee
                    if (st.countTokens() != 4){ // Check that the number of parameters is correct
                        System.out.println("Invalid command!");
                        continue;
                    }

                    name = st.nextToken();
                    department = st.nextToken();
                    date = new Date(st.nextToken());
                    salary = Integer.parseInt(st.nextToken());

                    if (!date.isValid()){           // Check if the date is valid
                        System.out.println(date.toString() + " is not a valid date!");
                        continue;
                    }

                    if (salary < 0){
                        System.out.println("Salary cannot be negative.");
                        continue;
                    }

                    if (!(department.equals("ECE") || department.equals("CS") || department.equals("IT"))){
                        System.out.println("invalid department code.");
                        continue;
                    }

                    if (!company.add(new Fulltime(new Profile(name, department, date), salary))){
                        System.out.println("Employee is already in the list.");
                        continue;
                    }
                    System.out.println("Employee added.");
                    break;

                case "AM":                      // Add Full time employee
                    if (st.countTokens() != 5){ // Check that the number of parameters is correct
                        System.out.println("Invalid command!");
                        continue;
                    }

                    name = st.nextToken();
                    department = st.nextToken();
                    date = new Date(st.nextToken());
                    salary = Integer.parseInt(st.nextToken());
                    int roles = Integer.parseInt(st.nextToken());

                    if (!date.isValid()){           // Check if the date is valid
                        System.out.println(date.toString() + " is not a valid date!");
                        continue;
                    }

                    if (salary < 0){
                        System.out.println("Salary cannot be negative.");
                        continue;
                    }

                    if (!(department.equals("ECE") || department.equals("CS") || department.equals("IT"))){
                        System.out.println("invalid department code.");
                        continue;
                    }

                    if (roles < 1 || roles > 3){
                        System.out.println("invalid management code.");
                        continue;
                    }

                    if (!company.add(new Management(new Profile(name, department, date), salary, roles))){
                        System.out.println("Employee is already in the list.");
                        continue;
                    }
                    System.out.println("Employee added.");
                    break;

                case "R":
                    if (company.getNumEmployee() == 0){
                        System.out.println("Employee database is empty.");
                        break;
                    }

                    if (st.countTokens() != 3){ // Check that the number of parameters is correct
                        System.out.println("Invalid command!");
                        continue;
                    }

                    name = st.nextToken();
                    department = st.nextToken();
                    date = new Date(st.nextToken());

                    if (!company.remove(new Employee(new Profile(name, department, date)))){
                        System.out.println("Employee does not exist.");
                        continue;
                    }

                    System.out.println("Employee removed.");
                    break;

                case "C":
                    if (company.getNumEmployee() == 0){
                        System.out.println("Employee database is empty.");
                        break;
                    }

                    if (st.countTokens() != 0){ // Check that the number of parameters is correct
                        System.out.println("Invalid command!");
                        continue;
                    }

                    company.processPayments();

                    System.out.println("Calculation of employee payments is done.");
                    break;

                case "S":
                    if (company.getNumEmployee() == 0){
                        System.out.println("Employee database is empty.");
                        break;
                    }

                    if (st.countTokens() != 4){ // Check that the number of parameters is correct
                        System.out.println("Invalid command!");
                        continue;
                    }

                    name = st.nextToken();
                    department = st.nextToken();
                    date = new Date(st.nextToken());
                    int hours = Integer.parseInt(st.nextToken());

                    if (!date.isValid()){           // Check if the date is valid
                        System.out.println(date.toString() + " is not a valid date!");
                        continue;
                    }

                    if (hours < 0){
                        System.out.println("Working hours cannot be negative.");
                        continue;
                    }

                    if (hours > 100){
                        System.out.println("Invalid Hours: over 100.");
                        continue;
                    }

                    if (!(department.equals("ECE") || department.equals("CS") || department.equals("IT"))){
                        System.out.println("invalid department code.");
                        continue;
                    }

                    if (!company.setHours(new Parttime(new Profile(name, department, date), hours))){
                        System.out.println("Employee does not exist.");
                        continue;
                    }
                    System.out.println("Employee added.");
                    break;

                case "PA":
                    if (company.getNumEmployee() == 0){
                        System.out.println("Employee database is empty.");
                        break;
                    }

                    company.print();
                    break;

                case "PH":
                    if (company.getNumEmployee() == 0){
                        System.out.println("Employee database is empty.");
                        break;
                    }

                    company.printByDate();
                    break;

                case "PD":
                    if (company.getNumEmployee() == 0){
                        System.out.println("Employee database is empty.");
                        break;
                    }

                    company.printByDepartment();
                    break;

                default:
                    System.out.println("Command '" + command + "' not supported!");
            }
        }
        System.out.println("Payroll Processing completed.");
    }
}
