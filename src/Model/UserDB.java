package Model;

public class UserDB {

    private int DOB;
    private int dateJoined;
    private int userID;
    private String password;
    private String email;
    private String username;
    private String lname;
    private String fname;
    private int repScore;
    private String status;

    // Constructor
    public UserDB(){
        DOB = 0;
        dateJoined = 0;
        userID = 0;
        password = null;
        email = null;
        username = null;
        lname = null;
        fname = null;
        repScore = 0;
        status = null;
    }

    // Constructor with parameters
    public UserDB(int DOB, int dateJoined, int userID, String password, String email, String username, String lname, String fname, int repScore, String status){
        this.DOB = DOB;
        this.dateJoined = dateJoined;
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.username = username;
        this.lname = lname;
        this.fname = fname;
        this.repScore = repScore;
        this.status = status;
    }

    // Getters
    public int getDOB(){
        return DOB;
    }
    public int getDateJoined(){
        return dateJoined;
    }
    public int getUserID(){
        return userID;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public String getUserName(){
        return username;
    }
    public String getLastName(){
        return lname;
    }
    public String getFirstName(){
        return fname;
    }
    public int getRepScore(){
        return repScore;
    }
    public String getStatus(){
        return status;
    }

    // Setters
    public void setDOB(int DOB){
        this.DOB = DOB;
    }
    public void setDateJoined(int dateJoined){
        this.dateJoined = dateJoined;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setUserName(String username){
        this.username = username;
    }
    public void setLastName(String lname){
        this.lname = lname;
    }
    public void setFirstName(String fname){
        this.fname = fname;
    }
    public void setRepScore(int repScore){
        this.repScore = repScore;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
