package assignment2;

/**@author Avery Smith-Thompson
 * @since 2023-09-14
 * Contains main method that manages making a new calender object, all user inputs and print statements
 */
//imported library to allow user to make inputs
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

//TO DO:
//-ISSUE WITH DATE, CODE CRASHES DUE TO FORMAT AND PARSE 
//-ADD A DO-WHILE LOOP TO LOOP THROUGH UNTIL THE USER WANTS TO QUIT
public class Assignment2 {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        //creates a new calender event
        CalenderEvent event = new CalenderEvent();
        //
        //Regular Expression
            //Source: https://www.baeldung.com/java-email-validation-regex
        String pattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        //Format for date and time
            //Source: https://howtodoinjava.com/java/date-time/java-localdatetime-class/
        DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-LLL-dd h:mm a");

        System.out.print("Current date: " + event.currentDate + "\n");
        System.out.print("Enter the email address: ");
        String creator = userInput.nextLine();
        event.setCreator(creator, pattern);

        //welcome statement, displaying name using getName and ask for a date and time
        System.out.print("\nWelcome to your calender "+ event.getCreator() + "!\nEnter a date and time " +  "Format ex.: 2010-9-12 12:00 (24 Hour time): ");
        String date = userInput.nextLine();
        event.setDate(date, format);
        //ask user for the description of the event
        System.out.print("\nDescription of event: ");
        String desc = userInput.nextLine();
        event.setDesc(desc);
        //asks for duration and if it is recurring or not
        System.out.print("Duration of event (In minutes): ");
        int duration = userInput.nextInt();
        userInput.nextLine();
        event.setDuration(duration);
        System.out.print("Is this a recurring event? (yes/no): ");
        String recurring = userInput.nextLine();
        event.setRecurring(recurring.toLowerCase()); 

        //CHILD CLASS INPUTS:
            //ask for more inputs to lead create the child classes
            //include other prints for child class variables

        //closing statement that displays the created event information back to the user
            //include information from child classes
        System.out.print("\n" + event.getCreator() + "\'s calender event. \nDate and time: " + event.getDate() + "\nDescription: " + event.getDesc() + "\nDuration: " + event.getDuration());
        if (event.getRecurring() == true){
            System.out.print("\nRecurring: Yes");
        }
        else{System.out.print("\nRecurring: No");}
        System.out.print("\nEnding time: " + event.getEnd());
        //closes user input
        userInput.close();
    }
}
