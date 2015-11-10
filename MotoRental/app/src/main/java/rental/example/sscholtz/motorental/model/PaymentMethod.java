package rental.example.sscholtz.motorental.model;

/**
 * Created by Enthused Dragon on 2015/09/23.
 */
public class PaymentMethod {
    private Long id;
    private String PaymentType;
    private double Price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
