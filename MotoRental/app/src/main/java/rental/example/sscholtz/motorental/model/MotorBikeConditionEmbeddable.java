package rental.example.sscholtz.motorental.model;

/**
 * Created by Shannon on 2015-09-24.
 */
public class MotorBikeConditionEmbeddable {

    private String OdometreReading;
    private String Gas;
    private String BikeCondition;

    private MotorBikeConditionEmbeddable()
    {

    }

    public MotorBikeConditionEmbeddable(String odometreReading, String gas, String bikeCondition) {
        OdometreReading = odometreReading;
        Gas = gas;
        BikeCondition = bikeCondition;
    }

    public String getOdometreReading() {
        return OdometreReading;
    }

    public void setOdometreReading(String odometreReading) {
        OdometreReading = odometreReading;
    }

    public String getGas() {
        return Gas;
    }

    public void setGas(String gas) {
        Gas = gas;
    }

    public String getBikeCondition() {
        return BikeCondition;
    }

    public void setBikeCondition(String bikeCondition) {
        BikeCondition = bikeCondition;
    }
}
