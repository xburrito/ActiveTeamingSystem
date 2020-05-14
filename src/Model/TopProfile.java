package Model;

public class TopProfile {
    //private String img;
    private String username;
    private int repScore;
    private String status;

    // Constructor
    public TopProfile(){
        username = null;
        repScore = 0;
        status = null;
    }

    // Constructor with parameters
    public TopProfile(String username, int repScore, String status) {
        this.username = username;
        this.repScore = repScore;
        this.status = status;
    }

    // Getters
    public String getUserName() {
        return username;
    }
    public int getRepScore() {
        return repScore;
    }
    public String getStatus() {
        return status;
    }

    // Setters
    public void setUserName(String username) {
        this.username = username;
    }
    public void setRepScore(int repScore) {
        this.repScore = repScore;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // utility methods
    public String toString() {
        String str = username + ", " + repScore + ", " + status;
        return str;
    }
}// end TopProfile
