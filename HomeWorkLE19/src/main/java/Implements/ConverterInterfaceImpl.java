package Implements;
import Interfaces.ConverterInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.yaml.snakeyaml.Yaml;
import com.fasterxml.jackson.databind.ObjectMapper;
import Exception.JsonException;

import java.util.Map;

public class ConverterInterfaceImpl implements ConverterInterface{
    @Override
    public String convert(String str) throws JsonProcessingException {
        try{
            return new Yaml().dump(new ObjectMapper().readValue(str, Map[].class));
        } catch (JsonProcessingException processingException){
            throw new JsonException();
        }
    }
}
