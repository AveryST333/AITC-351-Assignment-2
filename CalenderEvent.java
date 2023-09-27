package assignment2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*To Do List:
- FINISH DATE AND TIME
- FINISH END DATE
- NOTE: ALL SHOULD BE DONE USING THE JAVA.TIME COMMANDS
*/

/**@author Avery Smith-Thompson
 * @since 2023-09-14
 * Contains the parent class called CalenderEvent and its attributes
 */
public class CalenderEvent {
    /**
     * Default constructor
     */
    public CalenderEvent(){
        currentDate = LocalDateTime.now();
        creator = "Not available";
        date = null;
        desc = "Not available";
        duration = -1;
        valid = false;
    }
    //name and date are variables that are being passed down to child classes
    /**
     * Overloaded constructor
     * @param currentDate
     * @param creator
     * @param date
     * @param desc
     * @param duration
     * @param valid
     */
    public CalenderEvent(LocalDateTime currentDate, String creator, LocalDateTime date, String desc, int duration, boolean valid){
        this.currentDate = currentDate;
        this.creator = creator;
        this.date = date;
        this.desc = desc;
        this.duration = duration;
        this.valid = valid;
    }

    public LocalDateTime currentDate;
    protected String creator;
    protected LocalDateTime date;
    private String desc;
    protected int duration; 
    private boolean valid; //used to validate whether recurring has the correct input

    //setters
    /**
     * Setter for email of the user of the calender.
     * If the user's email doesnt match the regex then the code ends and returns
     * @param creator
     */
    public void setCreator(String creator, String pattern){
        //compiles the regular expression for comparison
        //Reference for code was used
            //Source: https://www.w3schools.com/java/java_regex.asp
        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(creator);
        boolean validEmail = matcher.find();
        if (validEmail){
            this.creator = creator;
        }
        else{
            this.creator = "";
        }
    }
    /**
     * Setter for description of the event.
     * @param desc
     */
    public void setDesc(String desc){
        //if desc is over 100 characters, do not accept. and remove consecutive spaces in the string
        if (desc.length() <= 100){
            //Referenced code for to remove white space, code above the source
                //Source: https://www.baeldung.com/java-string-remove-whitespace
            desc = desc.replaceAll("\\s+", " ");
            //removes leading and trailing whitespaces
            desc = desc.trim();
            this.desc = desc;
        }
        else{
            return;
        }
    }
    /**
     * Setter for the user's entered date and time
     * @param userDate
     */
    public void setDate(String userDate, DateTimeFormatter format){
        //References used for code below
            //Source: https://howtodoinjava.com/java/date-time/java-localdatetime-class/
        LocalDateTime date = LocalDateTime.parse(userDate, format);
        boolean beforeCurr = date.isBefore(currentDate);
        if (!beforeCurr){
            this.date = date;
        }
        else{
            return;
        }
    }
    //setDuration and setRecurring contain validation checks for the values entered
    /**
     * Setter for duration
     * Validation check is needed for int that is passed in.
     * Business Rule: Can't accept negative integers and only in minutes.
     * @param duration
     */
    public void setDuration(int duration){
        if (duration < 0) {
            return;
        }
        else{
            this.duration = duration;
        }
    }
    /**
     * Setter for valid which varifies if the user entered the right input, yes or no, and set the boolean depending on whether the string is yes or no
     * @param recurring
     */
    public void setRecurring(String recurring){ //Business Rule: Only accepts true or false as an option
        //strings have to be compared with .equals and .equalsIgnoreCase, can't use "=="
        if (recurring.equalsIgnoreCase("yes")){
            this.valid = true;
        }
        if (recurring.equalsIgnoreCase("no")){
            this.valid = false;
        }
        //default value of a boolean is always set to false, so valid remains false and code exits
        else{
            return;
        }
    }
    /**
     * Method that returns the name of user
     * @return Name of the user
     */
    public String getCreator(){
        if (creator == ""){
            return "";
        }
        else{
            return creator;
        }
    }
    /**
     * Method that returns the description of the event
     * @return Description of the event
     */
    public String getDesc(){
        return desc;
    }
    /**
     * Method that returns the date and time of the event
     * @return Date and time of event
     */
    public LocalDateTime getDate(){
        return date;
    }
    /**
     * Method that returns the end date event 
     * @return end date of the event
     */
    public LocalDateTime getEnd(){
        if (date == null){
            return null;
        }
        else{
            LocalDateTime end = date.plusMinutes(duration);
            return end;
        }
    }
    /**
     * Method that returns the duration of the event
     * @return Duration of the event as an int
     */
    public int getDuration(){
        return duration;
    }
    /**
     * Method that returns a boolean to verify if the event is recurring or not
     * @return A boolean specifying if the event is recurring
     */
    public boolean getRecurring(){
        return valid;
    }
}
