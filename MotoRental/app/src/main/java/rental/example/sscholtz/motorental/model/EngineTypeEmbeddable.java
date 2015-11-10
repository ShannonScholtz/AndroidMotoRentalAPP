package rental.example.sscholtz.motorental.model;

/**
 * Created by Shannon on 2015-09-24.
 */
public class EngineTypeEmbeddable {

    private String EngineSerialNumber;
    private String EngineSize;
    private String FuelType;

    private EngineTypeEmbeddable()
    {

    }

    public EngineTypeEmbeddable(String engineSerialNumber, String engineSize, String fuelType) {
        EngineSerialNumber = engineSerialNumber;
        EngineSize = engineSize;
        FuelType = fuelType;
    }

    public String getEngineSerialNumber() {
        return EngineSerialNumber;
    }

    public void setEngineSerialNumber(String engineSerialNumber) {
        EngineSerialNumber = engineSerialNumber;
    }

    public String getEngineSize() {
        return EngineSize;
    }

    public void setEngineSize(String engineSize) {
        EngineSize = engineSize;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }


}
