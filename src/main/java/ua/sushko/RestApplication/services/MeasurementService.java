package ua.sushko.RestApplication.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.sushko.RestApplication.models.Measurement;
import ua.sushko.RestApplication.repositories.MeasurementRepository;
import ua.sushko.RestApplication.util.MeasurementValidator;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }
    public List<Measurement> findAll() {return measurementRepository.findAll(); }

    @Transactional
    public void addMeasurement(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    public void enrichMeasurement(Measurement measurement) {
        //Самі знаходимо сенсор по імені і вставляємо об'єкт з Hibernate persistence context.
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()).get());
        measurement.setMeasurementDateTime(LocalDateTime.now());
    }

}
