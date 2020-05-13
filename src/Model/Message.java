package Model;

// Message/Notification
public class Message {
    String messageType; // collab or normal
    String messageDate;
    String senderUsername;
    String receiverUsername;
    String Note;


    //parameterized costructor
    public Message(String messageType, String messageDate, String senderUsername, String receiverUsername, String note) {
        this.messageType = messageType;
        this.messageDate = messageDate;
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
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

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
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
                ", receiverUsername=" + receiverUsername +
                ", Note='" + Note + '\'' +
                '}';
    }
} // Message