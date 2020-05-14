package Model;

public class Project {
    String projectName;
    String projectGroup;
    int projectScore;

    // parameterized constructor
    public Project(String projectName, String projectGroup, int projectScore) {
        this.projectName = projectName;
        this.projectGroup = projectGroup;
        this.projectScore = projectScore;
    }

    // Getters and Setters
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectGroup() {
        return projectGroup;
    }

    public void setProjectGroup(String projectGroup) {
        this.projectGroup = projectGroup;
    }

    public int getProjectScore() {
        return projectScore;
    }

    public void setProjectScore(int projectScore) {
        this.projectScore = projectScore;
    }

    // to string for displayal
    @Override
    public String toString() {
        return projectName + ", " + projectGroup + ", " + projectScore;
    }


} // end Project
