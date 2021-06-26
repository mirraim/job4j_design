package ru.job4j.lsp.mistakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;

public class CheckInRegistration extends Registration {

    public CheckInRegistration(BufferedReader reader, Writer writer) {
        super(reader, writer);
    }

    @Override
    public void requestDoc(User user) throws IOException {
        requestPassport(user);
    }
}
