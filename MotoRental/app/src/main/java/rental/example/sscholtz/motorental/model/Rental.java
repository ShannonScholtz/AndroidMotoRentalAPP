package rental.example.sscholtz.motorental.model;

import java.util.List;

/**
 * Created by Enthused Dragon on 2015/09/23.
 */
public class     Rental {
        private Long id;
        private String pickUpDate;
        private String returnDate;
        private List<PaymentMethod> paymentMethod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public List<PaymentMethod> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<PaymentMethod> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
