package ua.sushko.RestApplication.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.sushko.RestApplication.models.Sensor;
import ua.sushko.RestApplication.services.SensorService;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;
    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> aClass) {return Sensor.class.equals(aClass); }

    @Override
    public void validate(Object o, Errors errors) {
        Sensor sensor = (Sensor) o;
        if (sensorService.findByName(sensor.getName()).isPresent())
            errors.rejectValue("name", "Сенсор з таким ім'ям існує!");
    }
}
