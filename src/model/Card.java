package model;

import java.time.LocalDate;

public abstract class Card {
    private LocalDate expirationDate;
    private String cardNumber;
    private String cvv;

    public Card(LocalDate expirationDate, String cardNumber, String cvv) {
        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
