package Implements;

import Interfaces.ConverterInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.util.Map;

public class YamlConverterService implements ConverterInterface {
    @Override
    public String convert(String str) throws JsonProcessingException {
        try {
            Map[] maps = new Yaml(new Constructor(Map[].class)).load(str);
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(maps);
        } catch (JsonProcessingException processingException){
            throw new RuntimeException(processingException);
        }
    }
}
