package eci.cvds.ecisanitas.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctors")
public class Doctor {
    private String id;
    private String name;
    private String specialty;
    private String contact;

    public String getId() {
        return id;
    }  

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }  

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
