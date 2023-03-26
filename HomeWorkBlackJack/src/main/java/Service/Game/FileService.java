package Service.Game;

import java.io.File;
import java.nio.file.Path;

public interface FileService {
    Path getPath();
    void writeFile(File file, boolean app, String str);
    String readFile(Path path);
}
