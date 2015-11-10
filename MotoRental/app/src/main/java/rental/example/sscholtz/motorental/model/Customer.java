package rental.example.sscholtz.motorental.model;

import java.util.List;

/**
 * Created by Enthused Dragon on 2015/09/23.
 */
public class Customer implements Person{
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private AddressEmbeddable addressEmbeddable;
    private List<Rental> rentals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressEmbeddable getAddressEmbeddable() {
        return addressEmbeddable;
    }

    public void setAddressEmbeddable(AddressEmbeddable addressEmbeddable) {
        this.addressEmbeddable = addressEmbeddable;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

}
