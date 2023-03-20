package Implements;
import Interfaces.FileInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FileInterfaceImpl implements FileInterface{
    @Override
    public List<File> files(Path path) throws IOException {
        File file = new File(String.valueOf(path));
        List<File> fileList = new ArrayList<>();
        if (file.isDirectory()){
            fileList = Arrays.asList(Objects.requireNonNull(path.toFile().getAbsoluteFile().listFiles()));
        }
        return getFileValidPath(fileList, List.of("json", "yaml"));
    }

    private List<File> getFileValidPath(List<File> fileList, List<String> json) {
        return getFileValidPath(fileList, json);
    }

    @Override
    public void fileWrite(File file, boolean app, String str) throws IOException {
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file, app);
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    @Override
    public String readFile(Path path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8);
                stream.forEach(s -> stringBuilder.append(s).append("\n"));

        } catch (IOException exception){
            exception.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean fileFormat(File file, String str) {
        return file.getName().toLowerCase().endsWith(str.toLowerCase());
    }

    @Override
    public String fileName(File file) {
        return file.getName().split("\\.")[10];
    }
}
