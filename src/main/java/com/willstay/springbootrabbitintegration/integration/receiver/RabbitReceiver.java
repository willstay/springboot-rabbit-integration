package com.willstay.springbootrabbitintegration.integration.receiver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

import com.willstay.springbootrabbitintegration.integration.deserialization.DeserializationFactory;
import com.willstay.springbootrabbitintegration.integration.folderpaths.FolderPaths;
import com.willstay.springbootrabbitintegration.rest.domain.AbstractCar;
import com.willstay.springbootrabbitintegration.rest.domain.Suv;
import com.willstay.springbootrabbitintegration.rest.domain.Truck;
import com.willstay.springbootrabbitintegration.rest.service.SuvService;
import com.willstay.springbootrabbitintegration.rest.service.TruckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitReceiver {
    @Autowired
    private SuvService suvService;

    @Autowired
    private TruckService truckService;

    public void receiveMessage(String message) throws IOException {
        log.info(LocalDate.now() + ": " + message);
        saveToBase(message);
    }

    public void saveToBase(String message) throws IOException {
        String pathName;
        Class className;
        if (message.equals("trucks done")) {
            pathName = FolderPaths.TRUCKS_PATH;
            className = Truck.class;
        } else if (message.equals("suvs done")) {
            pathName = FolderPaths.SUV_PATH;
            className = Suv.class;
        } else {
            throw new RuntimeException();
        }

        Stream<Path> carStream = Files.walk(Paths.get(pathName));
        carStream.filter(Files::isRegularFile).forEach(path -> {
            DeserializationFactory deserializationFactory = new DeserializationFactory(path, className);
            AbstractCar abstractCar = deserializationFactory.deserialize();
            if (abstractCar instanceof Truck) {
                truckService.save((Truck) abstractCar);
            } else if (abstractCar instanceof Suv) {
                suvService.save((Suv) abstractCar);
            }
        });
    }
}
