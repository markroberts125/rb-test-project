package config;

import client.FileTableField;
import io.cucumber.java.ParameterType;

public class ParameterTypes {
    @ParameterType(".*")
    public FileTableField fileTableField(String field) {
        return FileTableField.valueOf(field.replace(" ", ""));
    }
}
