package task5.messages;

public class SendFileRequest implements ClientMessage{
    public final String fileName;
    public final byte[] data;

    public SendFileRequest(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }
}
