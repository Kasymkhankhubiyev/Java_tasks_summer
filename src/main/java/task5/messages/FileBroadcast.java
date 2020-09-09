package task5.messages;

public class FileBroadcast implements ServerMessage{
    public final String username;
    public final String fileName;
    public final byte[] data;

    public FileBroadcast(String username, String fileName, byte[] data) {
        this.username = username;
        this.fileName = fileName;
        this.data = data;
    }
}
