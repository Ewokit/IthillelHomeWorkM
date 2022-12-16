public class StudentProc {
    private static Student[] dataBase = StudentBase.createDataBase();

    public void showListFaculty(String faculty) {
        System.out.println("\nFaculty:" + faculty);
        for (int i = 0; i < dataBase.length; i++) {
            if (faculty.equals(dataBase[i].getFaculty())) {
                System.out.println(dataBase[i].toString());
            }
        }
    }

    public void showListFandC(String faculty, int course) {
        System.out.println("\nFaculty:" + faculty + "\nCourse:" + course + "\n");
        for (int i = 0; i < dataBase.length; i++) {
            if (faculty.equals(dataBase[i].getFaculty())) {
                if (course == Integer.parseInt(dataBase[i].getCourse())) {
                    System.out.println(dataBase.toString());
                }
            }
        }
    }
    public void showListStYear(int year){
        System.out.println("\nYear:" + year);
        for (int i = 0; i < dataBase.length; i++){
            String[] array = dataBase[i].getDateBD().split("");
            if (year <= Integer.parseInt(array[array.length - 1])){
                System.out.println(dataBase[i].toString());
            }
        }
    }
    public void showListStGroup(String group){
        System.out.println("\nGroup:" + group);
        for (int i = 0; i < dataBase.length; i++){
            if (group.equals(dataBase[i].getGroup())){
                System.out.println(dataBase[i].toString());
            }
        }

    }
}