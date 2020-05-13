package Model;

public class Referral {
    String referrerUsername;
    String referrerStatus;
    String referrerinviteeEmail;

    public Referral(String referrerUsername, String referrerStatus, String referrerinviteeEmail) {
        this.referrerUsername = referrerUsername;
        this.referrerStatus = referrerStatus;
        this.referrerinviteeEmail = referrerinviteeEmail;
    }

    public String getReferrerUsername() {
        return referrerUsername;
    }

    public void setReferrerUsername(String referrerUsername) {
        this.referrerUsername = referrerUsername;
    }

    public String getReferrerStatus() {
        return referrerStatus;
    }

    public void setReferrerStatus(String referrerStatus) {
        this.referrerStatus = referrerStatus;
    }

    public String getReferrerinviteeEmail() {
        return referrerinviteeEmail;
    }

    public void setReferrerinviteeEmail(String referrerinviteeEmail) {
        this.referrerinviteeEmail = referrerinviteeEmail;
    }
}
