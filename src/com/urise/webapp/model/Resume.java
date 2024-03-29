package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;

    // Unique identifier
    private  String uuid;

    private  String fullName;



    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);



    private final Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);


    public Resume() {
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "fullName must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");

        this.uuid = uuid;
        this.fullName = fullName;
    }


    public Resume(String fullName) {
        this.uuid = UUID.randomUUID().toString();
        this.fullName=fullName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;
        Resume resume = (Resume) o;
        return Objects.equals(getUuid(), resume.getUuid()) && Objects.equals(fullName, resume.fullName) && Objects.equals(contacts, resume.contacts) && Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), fullName, contacts, sections);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }



    @Override
    public String toString() {
        return uuid+ '(' + fullName+')';
    }

    @Override
    public int compareTo(Resume o) {
        int cmp =  fullName.compareTo(o.fullName);
        return cmp != 0? cmp:uuid.compareTo(o.uuid);

    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }
    public Section getSection(SectionType type) {
        return sections.get(type);
    }
    public Map<SectionType, Section> getSection(){
        return sections;
    }

    public void addContact(ContactType type, String value) {
       contacts.put(type, value);
    }

    public void addSection(SectionType type, Section section ) {
       sections.put(type, section);
    }




}
