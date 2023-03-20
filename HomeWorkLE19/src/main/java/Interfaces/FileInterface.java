package Interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileInterface {
    List<File> files(Path path) throws IOException;
    void fileWrite(File file, boolean app, String str) throws IOException;
    String readFile(Path path);
    boolean fileFormat(File file, String str);
    String fileName(File file);
}
