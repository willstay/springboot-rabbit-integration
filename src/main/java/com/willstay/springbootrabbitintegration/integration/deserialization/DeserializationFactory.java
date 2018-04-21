package com.willstay.springbootrabbitintegration.integration.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.willstay.springbootrabbitintegration.rest.domain.AbstractCar;
import com.willstay.springbootrabbitintegration.rest.domain.Suv;
import com.willstay.springbootrabbitintegration.rest.domain.Truck;

import java.io.IOException;
import java.nio.file.Path;

public class DeserializationFactory {
    private final Path path;
    private final Class className;

    public DeserializationFactory(Path path, Class className) {
        this.path = path;
        this.className = className;
    }

    public AbstractCar deserialize(){
        ObjectMapper objectMapper = new ObjectMapper();
        if (className.equals(Truck.class)){
            try {
                return objectMapper.readValue(path.toFile(),Truck.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (className.equals(Suv.class)){
            try {
                return objectMapper.readValue(path.toFile(),Suv.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new DeserializeCarException();
    }
}
