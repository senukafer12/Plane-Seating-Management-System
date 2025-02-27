import java.io.File; //importing File class from java.io package for file operations
import java.io.FileWriter; //importing FileWriter class from java.io package for writing to files
import java.io.IOException; //importing IOException class from java.io package for handling IO errors
import java.io.PrintWriter; //importing PrintWriter class from java.io package for writing formatted text to a file

public class Ticket { //declaration of Ticket class

    private char row; //declaration of private instance variable for storing row
    private int seat; //declaration of private instance variable for storing seat number
    private int price; //declaration of private instance variable for storing price
    private Person person; //declaration of private instance variable for storing person information

    public Ticket (char row, int seat, int price, Person person) { //constructor for initializing Ticket object with row, seat, price, and person information
        this.row = row; //assigning provided row to the instance variable
        this.seat = seat; //assigning provided seat number to the instance variable
        this.price = price; //assigning provided price to the instance variable
        this.person = person; //assigning provided person information to the instance variable
    }

    public char getRow() { //getter method for retrieving row
        return this.row; //returning the value of the row instance variable
    }

    public int getSeat() { //getter method for retrieving seat number
        return this.seat; //returning the value of the seat instance variable
    }

    public int getPrice() { //getter method for retrieving price
        return this.price; //returning the value of the price instance variable
    }

    public Person getPerson() { //getter method for retrieving person information
        return this.person; //returning the person object
    }

    public void setRow(char row) { //setter method for updating row
        this.row = row; //updating the value of the row instance variable
    }

    public void setSeat(int seat) { //setter method for updating seat number
        this.seat = seat; //updating the value of the seat instance variable
    }

    public void setPrice(int price) { //setter method for updating price
        this.price = price; //updating the value of the price instance variable
    }

    public void setPerson(Person person) { //setter method for updating person information
        this.person = person; //updating the person object
    }

    public void TicketInformation() { //method for printing ticket information
        //printing row, seat number, and price of the Ticket object
        System.out.println("Row        : " + getRow() +
                "\nSeat Number: " + getSeat() +
                "\nSeat Price : £" + getPrice() );
        person.PersonInformation(); //calling PersonInformation method to print person information
    }

    public void save() { //method to save ticket information to a file
        String filename = row + Integer.toString(seat) + ".txt"; //generating filename based on row and seat number
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) { //using try-with-resources to automatically close resources
            writer.println("Ticket Information:"); //writing ticket information to file
            writer.println("Row: " + row);
            writer.println("Seat Number: " + seat);
            writer.println("Price: £" + price);
            writer.println();
            writer.println("Passenger Information:");
            writer.println("Name: " + person.getName());
            writer.println("Surname: " + person.getSurname());
            writer.println("Email: " + person.getEmail());
            System.out.println("Ticket information saved to " + filename); //confirmation message
        } catch (IOException e) { //handing IO exception
            System.out.println("Error saving ticket information to file: " + e.getMessage()); //error message
        }
    }

    public void deleteFile() { //method to delete the file associated with the ticket
        String filename = row + Integer.toString(seat) + ".txt"; //generating file name based on row and seat number
        File file = new File(filename); //creating file object
        if (file.exists()) { //checking if file exists
            if (file.delete()) { //deleting the file
                System.out.println("File " + filename + " deleted successfully."); //success message
            } else {
                System.out.println("Failed to delete file " + filename + "."); //failure message
            }
        } else {
            System.out.println("File " + filename + " does not exist."); //file not found message
        }
    }
}
