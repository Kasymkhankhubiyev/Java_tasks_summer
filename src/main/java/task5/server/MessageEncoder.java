package task5.server;

import task5.messages.Message;

public interface MessageEncoder {
    byte[] encodeMessage(Message message);
    Message decodeMessage(byte[] data);
}
