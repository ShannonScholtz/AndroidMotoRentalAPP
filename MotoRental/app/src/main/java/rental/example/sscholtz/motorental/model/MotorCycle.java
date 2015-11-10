package rental.example.sscholtz.motorental.model;

import java.util.List;

/**
 * Created by Shannon on 2015-09-24.
 */
public class MotorCycle {

    private Long id;
    private String SerialNumber;
    private String Make;
    private String Model;
    private String year;
    private MotorBikeConditionEmbeddable motorBikeConditionEmbeddable;
   private EngineTypeEmbeddable engineTypeEmbeddable;
    private List<Rental> rentals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public MotorBikeConditionEmbeddable getMotorBikeConditionEmbeddable() {
        return motorBikeConditionEmbeddable;
    }

    public void setMotorBikeConditionEmbeddable(MotorBikeConditionEmbeddable motorBikeConditionEmbeddable) {
        this.motorBikeConditionEmbeddable = motorBikeConditionEmbeddable;
    }

    public EngineTypeEmbeddable getEngineTypeEmbeddable() {
        return engineTypeEmbeddable;
    }

    public void setEngineTypeEmbeddable(EngineTypeEmbeddable engineTypeEmbeddable) {
        this.engineTypeEmbeddable = engineTypeEmbeddable;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public String toString() {
        return "MotorCycle{" +
                "Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
