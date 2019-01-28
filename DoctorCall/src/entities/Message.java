package entities;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;


public class Message {
    private long messageId;
    private User sender;
    private User recipient;
    private String messageBody;
    private Timestamp creationDate; //here we take the date from the mysqlDB using sql.Date

    public Message() {
    }

    //Getters and Setters
    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        if (this.messageId != other.messageId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Message{" + "messageId=" + messageId + ", sender=" + sender + ", recipient=" + recipient + ", messageBody=" + messageBody + ", creationDate=" + creationDate + '}';
    }

  

    
    
    

   

   
    
    
    
    
    
    
}
