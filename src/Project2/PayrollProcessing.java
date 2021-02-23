package Project2;

public class PayrollProcessing {

    public void run() {
        System.out.println("Library Kiosk running.");

        Library lib = new Library();            // Library instance
        Scanner sc = new Scanner(System.in);    // Scanner instance; Scan from console
        String command = sc.nextLine();         // Stores the first command from console
        String number = "";                     // Stores the number of the book if necessary
        StringTokenizer st = null;              // StringTokenizer variable without initial value

        // Stop the loop when the command is Q; Get next line and store it in command variable each loop
        for (; !command.equals("Q"); command = sc.nextLine()){

            st = new StringTokenizer(command, ",");     // ST instance with console input

            switch (st.nextToken()){            // switch-case for different command
                case "A":                       // Add
                    if (st.countTokens() != 2){ // Check that the number of parameters is correct
                        System.out.println("Invalid command!");
                        continue;
                    }

                    String name = st.nextToken();   // Get book's name
                    Date date = new Date(st.nextToken());   // Get book's publication date
                    if (!date.isValid()){           // Check if the date is valid
                        System.out.println("Invalid Date!");
                        continue;
                    }

                    lib.add(new Book(name, date));  // Add this book into the library
                    System.out.println(name + " added to the Library.");
                    break;

                case "R":                       // Remove
                    if (st.countTokens() != 1){
                        System.out.println("Invalid command!");
                        continue;
                    }

                    number = st.nextToken();
                    if (!lib.remove(new Book(number))){
                        System.out.println("Unable to remove, the library does not have this book.");
                        continue;
                    }
                    System.out.println("Book# " + number + " removed.");
                    break;

                case "O":                       // Check out
                    if (st.countTokens() != 1){
                        System.out.println("Invalid command!");
                        continue;
                    }

                    number = st.nextToken();
                    if (!lib.checkOut(new Book(number))){
                        System.out.println("Book#" + number + " is not available.");
                        continue;
                    }
                    System.out.println("You've checked out Book#" + number + ". Enjoy!");
                    break;

                case "I":                       // Return
                    if (st.countTokens() != 1){
                        System.out.println("Invalid command!");
                        continue;
                    }

                    number = st.nextToken();
                    if (!lib.returns(new Book(number))){
                        System.out.println("Unable to return Book#" + number + ".");
                        continue;
                    }
                    System.out.println("Book#" + number + " return has completed. Thanks!");
                    break;

                case "PA":                      // Print (PA)
                    if (st.countTokens() != 0){
                        System.out.println("Invalid command!");
                        continue;
                    }

                    if (lib.getNumBooks() == 0){
                        System.out.println("Library catalog is empty.");
                    } else {
                        lib.print();
                    }
                    break;

                case "PD":                      // Print (PD)
                    if (st.countTokens() != 0){
                        System.out.println("Invalid command!");
                        continue;
                    }

                    if (lib.getNumBooks() == 0){
                        System.out.println("Library catalog is empty.");
                    } else {
                        lib.printByDate();
                    }
                    break;

                case "PN":                      // Print (PN)
                    if (st.countTokens() != 0){
                        System.out.println("Invalid command!");
                        continue;
                    }

                    if (lib.getNumBooks() == 0){
                        System.out.println("Library catalog is empty.");
                    } else {
                        lib.printByNumber();
                    }
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
        System.out.println("Kiosk session ended.");
    }
}
