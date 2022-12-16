public class Student {
    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private String dateBD;
    private String address;
    private String phonenum;
    private String faculty;
    private String course;
    private String group;

    public Student(String id, String surname, String name, String patronymic, String dateBD, String address, String phonenum, String faculty, String course, String group){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateBD = dateBD;
        this.address = address;
        this.phonenum = phonenum;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }
    public String getFaculty(){
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public String getDateBD(){
        return dateBD;
    }
    public void setDateBD(String dateBD){
        this.dateBD = dateBD;
    }
    public String getGroup(){
        return group;
    }
    public void setGroup(String group){
        this.group = group;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPatronymic(){
        return patronymic;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getPhonenum(){
        return phonenum;
    }
    public void setPhonenum(String phonenum){
        this.phonenum = phonenum;
    }
}
