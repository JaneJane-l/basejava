package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;

import java.io.DataInputStream;
import java.io.IOException;

public class ContactElementProcessor implements DataStreamSerializer.ElementProcessor {

    private final DataInputStream dis;
    private final Resume resume;

    public ContactElementProcessor(DataInputStream dis, Resume resume) {
        this.dis = dis;
        this.resume = resume;
    }

    @Override
    public void process() throws IOException {
        resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());

    }
}
