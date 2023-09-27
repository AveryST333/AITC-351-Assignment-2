package assignment2;

/**@author Avery Smith-Thompson
 * @since 2023-09-14
 * Contains main method that manages making a new calender object, all user inputs and print statements
 */
//imported library to allow user to make inputs
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

//TO DO:
//
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
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m");

        System.out.print("Current date: " + event.currentDate + "\n");
        System.out.print("Enter the email address: ");
        String creator = userInput.nextLine();
        event.setCreator(creator, pattern);

        //welcome statement, displaying name using getName and ask for a date and time
        System.out.print("\nWelcome to your calender "+ event.getCreator() + "!\nEnter a date and time " +  "Format ex.: 2010-09-12 12:00 (24 Hour time): ");
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
        //child class inputs (Meeting)
        System.out.print("Do you want to add a meeting? (yes/no): ");
        String addMeeting = userInput.nextLine();
        if (addMeeting.equals("yes")){
            //asks user for number of participants
            Meeting meeting = new Meeting();
            String participants[] = new String[25];
            System.out.print("\nHow many participants would you like to include? (Max size of 25): ");
            int numberParticipants = userInput.nextInt();
            userInput.nextLine();
            for(int i = 0; i < numberParticipants; i++){
                System.out.print("Enter names of participants: ");
                String partiNames = userInput.nextLine();
                participants[i] = partiNames;
            }
            meeting.setParticpants(participants);
            System.out.print("\nEnter room ID (Example: AB001): ");
            String room = userInput.nextLine();
            meeting.setRoom(room);
            //ASK FOR TOWNHALL

            System.out.print("\n" + event.getCreator() + "\'s calender event. \nDate and time: " + event.getDate() + "\nDescription: " + event.getDesc() + "\nDuration: " + event.getDuration());
            if (event.getRecurring() == true){
                System.out.print("\nRecurring: Yes");
            }
            else{System.out.print("\nRecurring: No");}
            System.out.print("\nEnding time: " + event.getEnd());
            System.out.print("\nMeeting ID: " + meeting.getRoom());
            System.out.print("\nParticipants: ");
            for (String participant : meeting.getParticipants()){
                if (participant != null){
                    System.out.print(participant + ", ");
                }
            }
            
        }
        else{
            //ASK FOR DEADLINE
            //ASK FOR BIRTHDAY
            //enter code to ask for other child classes
            
            System.out.print("\n" + event.getCreator() + "\'s calender event. \nDate and time: " + event.getDate() + "\nDescription: " + event.getDesc() + "\nDuration: " + event.getDuration());
            if (event.getRecurring() == true){
                System.out.print("\nRecurring: Yes");
            }
            else{System.out.print("\nRecurring: No");}
            System.out.print("\nEnding time: " + event.getEnd());
            //closes user input
            userInput.close();
        }
        userInput.close();
    }
}
