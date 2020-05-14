package Model;

import java.util.List;
import java.util.StringJoiner;

public class Poll {
    String type;
    List<User> members;
    String meetingDate;
    String meetingTime;

    public Poll(String type, List<User> members, String meetingDate, String meetingTime) {
        this.type = type;
        this.members = members;
        this.meetingDate = meetingDate;
        this.meetingTime = meetingTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    @Override
    public String toString() {
        return type + ", " + membersToString() + ", " + meetingDate + ", "+ meetingTime;
    }

    // returns list of members in form of a string
    public String membersToString(){
        System.out.println(getMembers()==null);
        StringJoiner joiner = new StringJoiner("-");
        for(User user: getMembers()){
            joiner.add(user.getUserName());
        }
        return joiner.toString();
    }
}