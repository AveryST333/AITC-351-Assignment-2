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

    /**
     * Setter for room ID
     * @param room
     */
    public void setRoom(String room){
        String patternRoomNumber = "^[A-Z]{2}?[0-9]{3}?$";
        if (!room.matches(patternRoomNumber)){
            return;
        }
        else{
            this.room = room;
        }
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
