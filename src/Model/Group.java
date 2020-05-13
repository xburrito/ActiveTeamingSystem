package Model;// package Model;

import java.util.List;
import java.util.StringJoiner;

public class Group {

  private String group_ID;
  private String group_Name;
  private String group_Leader;
  private List<User> groupMembersList;

  // Default Constructor
  public Group(){
    group_ID = null;
    group_Name = null;
    group_Leader = null;
    groupMembersList = null;
  }

  // Constructor with parameters
  public Group(String group_ID, String group_Name, String group_Leader, List<User> groupMembersList){
    this.group_ID = group_ID;
    this.group_Name = group_Name;
    this.group_Leader = group_Leader;
    this.groupMembersList = groupMembersList;
  }

  // Getters
  public String getGroupID(){
    return group_ID;
  }

  public String getGroupName(){
    return group_Name;
  }

  public String getGroupLeader(){
    return group_Leader;
  }

  public String getGroup_ID() {
    return group_ID;
  }

  public String getGroup_Name() {
    return group_Name;
  }

  public void setGroup_Name(String group_Name) {
    this.group_Name = group_Name;
  }

  public String getGroup_Leader() {
    return group_Leader;
  }

  public void setGroup_Leader(String group_Leader) {
    this.group_Leader = group_Leader;
  }

  public List<User> getGroupMembersList() {
    return groupMembersList;
  }

  public void setGroupMembersList(List<User> groupMembersList) {
    this.groupMembersList = groupMembersList;
  }

  // Setters
  public void setGroup_ID(String group_ID){
    this.group_ID = group_ID;
  }

  public void setGroupName(String group_Name){
    this.group_Name = group_Name;
  }

  public void setGroupLeader(String group_Leader){
    this.group_Leader = group_Leader;
  }

  public boolean findMember(String username){
    for (User member : groupMembersList) {
      if (member.getUserName().equals(username)){
        return true;
      }
    }
    return false;
  }



  // utility methods, Note: they are automatically used for GUI Lists Views
  public String toString() {
    return "\n" + "[" + group_Name + ", " + group_Leader + ", " + membersToString() + "]";
  }

  // returns list of members in form of a string
  public String membersToString(){
    System.out.println(groupMembersList==null);
    StringJoiner joiner = new StringJoiner("-");
    for(User user: groupMembersList){
      joiner.add(user.getUserName());
    }
    return joiner.toString();
  }

} // end Group