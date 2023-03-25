package Service.Game.Impl;

import Service.Game.FileService;
import Service.log.ErrorService;
import Service.log.Impl.ErrorServiceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class FileServiceImpl implements FileService {
    private final ErrorService ERROR_SERVICE;
    private final ResourceBundle RESOURCE_BUNDLE;

    public FileServiceImpl(ResourceBundle resourceBundle){
        this.RESOURCE_BUNDLE = resourceBundle;
        this.ERROR_SERVICE = new ErrorServiceImpl(resourceBundle);
    }

    @Override
    public Path getPath() {
        return Path.of(System.getProperty("user.der"));
    }

    @Override
    public void writeFile(File file, boolean app, String str) {
        try {
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file, app);
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        } catch (IOException exception){
            ERROR_SERVICE.ioException(exception);
        }
    }

    @Override
    public String readFile(Path path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            stream.forEach(s -> stringBuilder.append(s).append("\n"));
        } catch (IOException exception){
            ERROR_SERVICE.ioException(exception);
        }
        return stringBuilder.toString();
    }
}
