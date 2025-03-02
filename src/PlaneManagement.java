import java.util.Scanner; //importing Scanner class for user input

public class PlaneManagement {
    private static Scanner scanner = new Scanner(System.in); //Scanner object for user input
    private static int [][] planeSeats = {              //2D array representing the seating arrangement of the plane
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //row A
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},       //row B
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},       //row C
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //row D
    };
    private static int[] getInputs() { //get row and seat number input from the user
        System.out.print("Enter a row number (A-D): "); //prompting user to enter a row letter
        char rowLetter; //variable to store row letter input
        int rowIndex;   //variable to store row index
        do { //loop to ensure valid row input from the user
            rowLetter = scanner.next().toUpperCase().charAt(0); //read row input and converting it to uppercase
            rowIndex = rowLetter - 'A'; //calculating row index based on the input letter (ASCII is used)
            if (rowIndex < 0 || rowIndex >= planeSeats.length) {  //check if row index is out of bounds
                System.out.println("Invalid row number. Please enter a valid row (A-D).");
                System.out.println();
                System.out.print("Enter a row number (A-D): "); //prompting user again for row input
            }
        } while (rowIndex < 0 || rowIndex >= planeSeats.length); //loop until valid row input is received

        System.out.print("Enter a seat number (1-" + planeSeats[rowIndex].length + "): "); //prompting user to enter  a seat number within the valid range for the selected row
        int seatNumber;  //variable to store seat number input
        int columnIndex = -1; //variable to store column index (seat index)
        do { //loop to ensure valid seat input from the user
            try {
                seatNumber = scanner.nextInt(); //reading user input for seat number
                columnIndex = seatNumber - 1; //calculating column index based on the input seat number
                if (columnIndex < 0 || columnIndex >= planeSeats[rowIndex].length) { //check if seat index is out of bounds
                    System.out.println("Invalid seat number. Please enter a valid seat number (1-" + planeSeats[rowIndex].length + ").");
                    System.out.println();
                    System.out.print("Enter a seat number (1-" + planeSeats[rowIndex].length + "): "); //prompting user again for seat input
                }
            } catch (Exception e) { //validating the seat number
                System.out.println("Please enter a number between (1-" + planeSeats[rowIndex].length + ")");
                System.out.println();
                System.out.print("Enter a seat number (1-" + planeSeats[rowIndex].length + "): "); //prompting user  again for seat input
                scanner.nextLine(); //clearing the input buffer
            }
        }  while (columnIndex < 0 || columnIndex >= planeSeats[rowIndex].length); //loop until valid seat input is received
        int [] arr2 = {rowIndex, columnIndex};
        return arr2; //returning an array containing row index and column index (seat index)
    }
    static Ticket[][] ticketArr = {                                                               //2D array to store Ticket objects corresponding to each seat
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null}, //row A
            {null, null, null, null, null, null, null, null, null, null, null, null},             //row B
            {null, null, null, null, null, null, null, null, null, null, null, null},             //row C
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null}, //row D
    };

    public static void main(String[] args) {
        System.out.println(); //prints an empty line
        System.out.println("Welcome to the Plane Management application"); //welcome message for the user
        boolean flag = false; //flag to control the loop execution

        //loop to display menu option and handle user input
        do {
            try {
                System.out.println();
                //Display menu options
                System.out.print(
                        "************************************************* \n" +
                                "*                 MENU OPTIONS                  * \n" +
                                "************************************************* \n" +
                                "\t 1) Buy a Seat\n" +
                                "\t 2) Cancel a Seat\n" +
                                "\t 3) Find first available\n" +
                                "\t 4) Show seating plan\n" +
                                "\t 5) Print tickets information and total sales\n" +
                                "\t 6) Search ticket\n" +
                                "\t 0) Quit\n" +
                                "************************************************* \n" +
                                "Please select an option: ");

                int select_seats = scanner.nextInt(); //read user input for menu option selection
                switch (select_seats) { //switch case to perform actions based on user-selected option
                    case 0: //quit
                        flag = true; //setting flag to exit the loop
                        break;
                    case 1: //buy a seat
                        buy_seat(); //calling method to buy a seat
                        break;
                    case 2: //cancel a seat
                        cancel_seat(); //calling method to cancel a seat
                        break;
                    case 3: //find first available
                        find_first_available(); //calling method to find the first available seat
                        break;
                    case 4: //show seating plan
                        show_seating_plan(); //calling method to show seating plan
                        break;
                    case 5: //print tickets information and total price
                        print_tickets_info(); //calling method to print ticket information
                        break;
                    case 6: //search ticket
                        search_ticket(); //calling method to search for a specific seat
                        break;
                    default: //handling invalid menu option
                        System.out.println("Please enter a valid option given to you");
                        break;
                }

            } catch (Exception e) { //handling exception for invalid input
                System.out.println("Please Enter a valid option");
                scanner.nextLine(); //clear
            }
        } while (!flag); //loop until the flag is true (user chooses to quit)
    }

    private static void buy_seat() { //method to buy a seat
        System.out.println("Buy a Seat:"); //prompting the user for seat purchase
        int[] arr3 = getInputs(); //get row and seat input from the user
        int rowIndex = arr3[0];
        int columnIndex = arr3[1];
        int seatNumber = columnIndex + 1; //calculating seat number based on column index
        char rowLetter = (char) (rowIndex + 'A'); //calculating row letter based on row index

        scanner.nextLine(); //clearing the input buffer
        if (planeSeats[rowIndex][columnIndex] == 0) { //checking if the seat is available for booking
            planeSeats[rowIndex][columnIndex] = 1; //marking the seat as booked in the planeSeats array

            //prompt for user to enter their name, surname, and email
            System.out.print("Enter your Name   : ");
            String name = scanner.nextLine();
            System.out.print("Enter your Surname: ");
            String surname = scanner.nextLine();
            System.out.print("Enter your E-mail : ");
            String email = scanner.nextLine();

            Person newPerson = new Person(name, surname, email); //create a new Person object with user details

            //calculating ticket price based seat number (column)
            int price;
            if (seatNumber <= 5) {
                price = 200;
            } else if (seatNumber <= 9) {
                price = 150;
            } else {
                price = 180;
            }

            Ticket newTicket = new Ticket(rowLetter, seatNumber, price, newPerson); //create a new Ticket object with seat details and person information

            newTicket.save(); //saving ticket information
            ticketArr[rowIndex][columnIndex] = newTicket; //storing ticket object in ticket array(ticketArr)

            System.out.println("Your seat is successfully booked"); //confirmation message for successful booking
        } else {
            System.out.println("This seat is already booked. Please book another seat."); //seat is already booked
        }
    }

    private static void cancel_seat() { //method to cancel a seat
        System.out.println("Cancel a Seat:"); //prompting user for seat cancellation
        int[] arr4 = getInputs(); //getting row and seat number input from the user
        int rowIndex = arr4[0];
        int columnIndex = arr4[1];

        if (planeSeats[rowIndex][columnIndex] == 1) { //checking if the seat is booked
            planeSeats[rowIndex][columnIndex] = 0; //setting the seat status as available
            System.out.println("Seat is successfully canceled.");

            if (ticketArr[rowIndex][columnIndex] != null) {
                ticketArr[rowIndex][columnIndex].deleteFile(); //deleting the corresponding Ticket object if it exists
                ticketArr[rowIndex][columnIndex] = null;
            }
        } else {
            System.out.println("Cannot be canceled. This seat is not booked."); //displaying a message if the seat is not booked
        }
    }

    private static void find_first_available() { //method to find the first available seat
        System.out.println("Find the first available seat:"); //prompting user to find the first available seat
        for (int i = 0; i < planeSeats.length; i++) { //looping through the planeSeats array to find the first available seat
            for (int j = 0; j < planeSeats[i].length; j++) { //looping through the planeSeats array to find the first available seat
                if (planeSeats[i][j] == 0) { //checking if the seat is available
                    char row_letter = (char) ('A' + i); //calculating the row letter
                    System.out.println("Seat " + row_letter + (j + 1) + " is available"); //displaying the available seat
                    return;
                }
            }
        }
        System.out.println("All Seats have been reserved. We apologize for any inconvenience this may cause "); //displaying if all seats are reserved
    }

    private static void show_seating_plan() { //method to display the seating plan
        System.out.println("The Seating Plan: ( 'O' available, 'X' booked )"); //prompting user to show seating plan
        System.out.println();
        for (int i = 0; i < planeSeats.length; i++) { //looping through the planeSeats array to display the seating plan
            for (int j = 0; j < planeSeats[i].length; j++) { //looping through the planeSeats array to display the seating plan
                if (planeSeats[i][j] == 0) { //checking if the seat is available or booked
                    System.out.print(" O "); //displaying 'O' for available seats
                }
                else {
                    System.out.print(" X "); //displaying 'X' for booked seats
                }
            }
            System.out.println(); //moving to the next row
            System.out.println();
        }
    }

    private static void print_tickets_info() { //method to print ticket information
        System.out.println("Tickets Information:"); //prompting user to print ticket information
        int totalPrice = 0; //initializing a variable to store the total price
        for (int i = 0; i < planeSeats.length; i++) { //looping through the planeSeats array to get ticket information
            for (int j = 0; j < planeSeats[i].length; j++) { //looping through the planeSeats array to get ticket information
                if (ticketArr[i][j] != null) { //checking if a ticket exists for the seat
                    ticketArr[i][j].TicketInformation(); //printing ticket information
                    System.out.println();
                    totalPrice = totalPrice + ticketArr[i][j].getPrice(); //adding ticket price to total price
                }
            }
        }
        System.out.println("Your Total Price is: £" + totalPrice); //displaying the total price
    }

    private static void search_ticket() {}
}