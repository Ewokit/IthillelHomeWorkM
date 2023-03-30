import Service.HibService;
import Service.HibServiceImpl;

public class RunnerHib {
    public static void main(String[] args) {
        HibService hibService = new HibServiceImpl();
        hibService.studentsName(" ");
        hibService.studentId(30);
    }
}
