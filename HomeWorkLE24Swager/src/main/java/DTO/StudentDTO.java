package DTO;

import lombok.Data;

@Data
public class StudentDTO {
    private int id;
    private String name;
    private int idGroup;
    private String date;

    public StudentDTO(int id, String name, int idGroup, String date) {
        this.id = id;
        this.name = name;
        this.idGroup = idGroup;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
