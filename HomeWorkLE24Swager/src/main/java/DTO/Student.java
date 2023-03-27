package DTO;

import java.util.UUID;

public class Student {
    private UUID uuid;
    private String name;
    private int idGroup;
    private String date;

    @Override
    public String toString() {
        return "Student{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", idGroup=" + idGroup +
                ", date='" + date + '\'' +
                '}';
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student(){

    }
}
