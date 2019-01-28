package util;

import entities.Message;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public  class LogMessageToFile {

    private FileWriter writer;
    private static final String FILENAME = "doctorcall.log.txt";

    //Open the file or create it if not found
    public void initTextFile() throws  DoctorCallException{
        try {
            writer = new FileWriter(FILENAME, true);
        } catch (IOException ex) {
            throw new DoctorCallException(ex.getMessage(), ex);
        }
    }

    public  void writeToTextFile(Message msg) throws DoctorCallException {
        try {
            writer.append(msg.getMessageId()+ ", "+ msg.getSender().getUsername()
                    + " , " + msg.getRecipient().getUsername()
                    + " , " + msg.getMessageBody() + " , "
                    + msg.getCreationDate()
            );
        } catch (IOException ex) {
            throw new DoctorCallException(ex.getMessage(), ex);
        }
    }
    
    public  void writeToTextFile(Long mid, String sender, String recipient, String messageBody, Timestamp creationDate) throws DoctorCallException {
        try {
            writer.append(mid+ ", "+ sender
                    + " , " + recipient
                    + " , " + messageBody + " , "
                    + creationDate
            );
        } catch (IOException ex) {
            throw new DoctorCallException(ex.getMessage(), ex);
        }
    }
    
   

}
