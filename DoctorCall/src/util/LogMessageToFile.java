package util;

import home.Message;
import java.io.FileWriter;
import java.io.IOException;

public class LogMessageToFile {

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

    public void writeToTextFile(Message msg) throws DoctorCallException {
        try {
            writer.append(msg.getMessageId()+ ", "
                    + msg.getSender().getUsername()
                    + " , " + msg.getRecipient().getUsername()
                    + " , " + msg.getMessageBody() + " , "
                    + msg.getCreationDate()
            );
        } catch (IOException ex) {
            throw new DoctorCallException(ex.getMessage(), ex);
        }
    }

}
