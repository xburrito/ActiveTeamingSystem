package Model;// package Model;

public class Group {

  private int group_ID;
  private String group_Name;
  private String group_Leader;
  private int member_count;

  // Default Constructor
  public Group(){
    group_ID = 0;
    group_Name = null;
    group_Leader = null;
  }

  // Constructor with parameters
  public Group(int group_ID, String group_Name, String group_Leader){
    this.group_ID = group_ID;
    this.group_Name = group_Name;
    this.group_Leader = group_Leader;
  }

  // Getters
  public int getGroup_ID(){
    return group_ID;
  }

  public String getGroupName(){
    return group_Name;
  }

  public String getGroupLeader(){
    return group_Leader;
  }

  public int getMemberCount(){
    return member_count;
  }

  // Setters
  public void setGroup_ID(int group_ID){
    this.group_ID = group_ID;
  }

  public void setGroupName(String group_Name){
    this.group_Name = group_Name;
  }

  public void setGroupLeader(String group_Leader){
    this.group_Leader = group_Leader;
  }

  public void setMemberCount(int member_count){
    this.member_count = member_count;
  }

}
