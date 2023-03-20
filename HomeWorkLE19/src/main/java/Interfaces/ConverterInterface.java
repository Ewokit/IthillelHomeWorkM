package Interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
public interface ConverterInterface {
    String convert(String str) throws JsonProcessingException;
}
