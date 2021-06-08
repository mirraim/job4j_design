package ru.job4j.dip;

public class MessageManager {
    Store accepted;
    Store sent;

    public MessageManager(Store accepted, Store sent) {
        this.accepted = accepted;
        this.sent = sent;
    }

    public Message accept(Input input) {
        Message mess = input.accept();
        accepted.add(mess);
        return mess;
    }

    public boolean sent(Output output, Message message) {
        output.send(message);
        return true;
    }
}
