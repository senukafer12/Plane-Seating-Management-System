public class Person { //declaration of Person class

    private String name; //declaration of private instance variable for storing name
    private String surname; //declaration of private instance variable for storing surname
    private String email; //declaration of private instance variable for storing email

    public Person (String name, String surname, String email) { //constructor for initializing Person object with name, surname, and email
        this.name = name; //assigning provided name to the instance variable
        this.surname = surname; //assigning provided surname to the instance variable
        this.email = email; //assigning provided email to the instance variable
    }

    public String getName() { //getter method for retrieving name
        return this.name; //returning the value of the name instance variable
    }

    public String getSurname() { //getter method for retrieving surname
        return this.surname; //returning the value of the surname instance variable
    }

    public String getEmail() { //getter method for retrieving email
        return this.email; //returning the value of the email instance variable
    }

    public void setName(String name) { //setter method for updating name
        this.name = name; //updating the value of the name instance variable
    }

    public void setSurname(String surname) { //setter method for updating surname
        this.surname = surname; //updating the value of the surname instance variable
    }

    public void setEmail(String email) { //setter method for updating email
        this.email = email; //updating the value of the email instance variable
    }

    public void PersonInformation() { //method for printing Person information
        //printing name, surname, and email of the Person object
        System.out.println("Name   : " + getName() +
                "\nSurname: " + getSurname() +
                "\nE-mail : " + getEmail() );
    }
}
