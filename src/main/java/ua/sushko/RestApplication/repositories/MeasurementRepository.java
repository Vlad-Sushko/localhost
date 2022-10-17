package ua.sushko.RestApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sushko.RestApplication.models.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
