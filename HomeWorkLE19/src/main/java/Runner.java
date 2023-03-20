import Implements.ConverterInterfaceImpl;
import Implements.FileInterfaceImpl;
import Implements.YamlConverterService;
import Interfaces.ConverterInterface;
import Interfaces.FileInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.time.LocalDateTime;

public class Runner {
    private static final String YAML = "yaml";
    private static final String JSON = "json";
    private static final FileInterface FILE_INTERFACE = new FileInterfaceImpl();

    public static void main(String[] args) throws IOException {
        Path path = Path.of(System.getProperty("user"));
        if (args.length > 0){
            path = Path.of(args[0]);
        }
        action(path);
    }

    private static void action(Path path) throws IOException {
        List<File> fileList = FILE_INTERFACE.files(path);
        File file = new File(path.toString(), "/result");
        file.mkdir();
        for (File file1 : fileList) {
            ConverterInterface converterInterface;
            int start = Math.toIntExact(System.nanoTime());
            String str;
            String log = "IS-NOT-POSSIBLE";
            long sizeFile = Files.size(file.toPath());

            if (FILE_INTERFACE.fileFormat(file, YAML)){
                converterInterface = new YamlConverterService();
                str = converterInterface.convert(FILE_INTERFACE.readFile(file.toPath()));
                File dFile = new File(file, FILE_INTERFACE.fileName(file)+ ".json");
                System.out.println("convert YAML - JSON done");

                FILE_INTERFACE.fileWrite(dFile, false, str);
                log = createLog(file, dFile, start, sizeFile);
            } else if (FILE_INTERFACE.fileFormat(file, JSON)){
                converterInterface = new ConverterInterfaceImpl();
                str = converterInterface.convert(FILE_INTERFACE.readFile(file.toPath()));
                File dFile = new File(file, FILE_INTERFACE.fileName(file) + ".yaml");
                System.out.println("convert JSON - YAML done");

                FILE_INTERFACE.fileWrite(dFile, false, str);
                log = createLog(file, dFile, start, sizeFile);
            }
            FILE_INTERFACE.fileWrite(new File(file, "log.txt"), true, log);
        }
    }
    private static String createLog(File file, File dFile, long start, long sizeFile){
        return "DATA: ".concat(String.valueOf(LocalDateTime.now()))
                .concat("--FROM:").concat(file.getName())
                .concat("--TO:").concat(dFile.getName())
                .concat("--TIME:").concat(Long.toString(System.nanoTime() - start))
                .concat("--FILE_SIZE:").concat(String.valueOf(sizeFile))
                .concat("\n");
    }
}
