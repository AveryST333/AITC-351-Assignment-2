package assignment2;
/**@author Avery Smith-Thompson
 * @since 2023-09-14
 * Contains one of the child classes of CalenderEvent which is Meeting
 */
public class Meeting extends CalenderEvent{
    //an array of participants
    public Meeting(){
        super();
        //initialized the participants array to be the size of 25
        participants = new String[25];
        room = "";
    }
    protected String participants[];
    protected String room;

    /**
     * Setter for the participants
     * @param participants
     */
    public void setParticpants(String participants[]){
        this.participants = participants;
    }

    public void setRoom(){
        //set a random room id in AB001 format
        //first 2 digits should be a capitalized letter, last 3 should be ints
    }

    /**
     * Getter for the participates
     * @return an array listing the participants
     */
    public String[] getParticipants(){
        return participants;
    }
    /**
     * Getter for the room where the meeting will be held
     * @return a room ID in AB001 format
     */
    public String getRoom(){
        return room;
    }
}
