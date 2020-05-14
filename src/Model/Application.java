package Model;

// this class represents the application submitted by the visitor
public class Application {
    String submissionDate;
    String applicantName;
    String applicantEmail;
    String applicantDOB;
    String applicantUsername;
    String applicantPassword;
    String applicantReferrer;
    String applicantReferrerStatus;

    // parameterized constructor
    public Application(String submissionDate, String applicantDOB, String applicantPassword, String applicantName, String applicantUsername, String applicantEmail, String applicantReferrer, String applicantReferrerStatus) {
        this.submissionDate = submissionDate;
        this.applicantDOB = applicantDOB;
        this.applicantPassword = applicantPassword;
        this.applicantName = applicantName;
        this.applicantUsername = applicantUsername;
        this.applicantEmail = applicantEmail;
        this.applicantReferrer = applicantReferrer;
        this.applicantReferrerStatus = applicantReferrerStatus;
    }

    // Getters and Setters

    public String getApplicantPassword() {
        return applicantPassword;
    }

    public void setApplicantPassword(String applicantPassword) {
        this.applicantPassword = applicantPassword;
    }

    public String getApplicantDOB() {
        return applicantDOB;
    }

    public void setApplicantDOB(String applicantDOB) {
        this.applicantDOB = applicantDOB;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantUsername() {
        return applicantUsername;
    }

    public void setApplicantUsername(String applicantUsername) {
        this.applicantUsername = applicantUsername;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantReferrer() {
        return applicantReferrer;
    }

    public void setApplicantReferrer(String applicantReferrer) {
        this.applicantReferrer = applicantReferrer;
    }

    public String getApplicantReferrerStatus() {
        return applicantReferrerStatus;
    }

    public void setApplicantReferrerStatus(String applicantReferrerStatus) {
        this.applicantReferrerStatus = applicantReferrerStatus;
    }

    // utility methods
    public String toString() {
        return submissionDate + ", " + applicantName + ", " + applicantEmail + ", " + applicantDOB + ", " + applicantUsername + ", " + applicantPassword + ", " + applicantReferrer + ", " + applicantReferrerStatus;
    }


} // end Application