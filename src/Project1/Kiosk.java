package Project1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

    public void run() {
        System.out.println("Library Kiosk running.");
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        String number = "";
        StringTokenizer st = null;
        for (; !command.equals("Q"); command = sc.nextLine()){
            st = new StringTokenizer(command, ",");
            switch (st.nextToken()){
                case "A":
                    if (st.countTokens() != 2){
                        // TODO: Unmatched variables number
                        continue;
                    }
                    String name = st.nextToken();
                    Date date = new Date(st.nextToken());
                    if (!date.isValid()){
                        System.out.println("Invalid Date!");
                        continue;
                    }
                    lib.add(new Book(name, date));
                    System.out.println(name + " added to the Library.");
                    break;
                case "R":
                    if (st.countTokens() != 1){
                        // TODO: Unmatched variables number
                        continue;
                    }
                    number = st.nextToken();
                    if (!lib.remove(new Book(number))){
                        System.out.println("Unable to remove, the library does not have this book.");
                        continue;
                    }
                    System.out.println("Book# " + number + " removed.");
                    break;
                case "O":
                    if (st.countTokens() != 1){
                        // TODO: Unmatched variables number
                        continue;
                    }
                    number = st.nextToken();
                    if (!lib.checkOut(new Book(number))){
                        System.out.println("Book#" + number + " is not available.");
                        continue;
                    }
                    System.out.println("You've checked out Book#" + number + ". Enjoy!");
                    break;
                case "I":
                    if (st.countTokens() != 1){
                        // TODO: Unmatched variables number
                        continue;
                    }
                    number = st.nextToken();
                    if (!lib.returns(new Book(number))){
                        System.out.println("Unable to return Book#" + number + ".");
                        continue;
                    }
                    System.out.println("Book#" + number + " return has completed. Thanks!");
                    break;
                case "PA":
                    if (st.countTokens() != 0){
                        // TODO: Unmatched variables number
                        continue;
                    }
                    if (lib.getNumBooks() == 0){
                        System.out.println("Library catalog is empty.");
                    } else {
                        lib.print();
                    }
                    break;
                case "PD":
                    if (st.countTokens() != 0){
                        // TODO: Unmatched variables number
                        continue;
                    }
                    if (lib.getNumBooks() == 0){
                        System.out.println("Library catalog is empty.");
                    } else {
                        lib.printByDate();
                    }
                    break;
                case "PN":
                    if (st.countTokens() != 0){
                        // TODO: Unmatched variables number
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