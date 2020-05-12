package Model;

// Message/Notification
public class Message {
    String messageType; // application or request for group collaboration
    String messageDate;
    String senderUsername;
    Application application;
    String Note;

    //parameterized costructor
    public Message(String messageType, String messageDate, String senderUsername, Application application, String note) {
        this.messageType = messageType;
        this.messageDate = messageDate;
        this.senderUsername = senderUsername;
        this.application = application;
        Note = note;
    }

    // setters and getters


    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageType='" + messageType + '\'' +
                ", messageDate='" + messageDate + '\'' +
                ", senderUsername='" + senderUsername + '\'' +
                ", application=" + application +
                ", Note='" + Note + '\'' +
                '}';
    }
} // Message