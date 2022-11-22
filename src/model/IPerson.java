package model;

import java.time.LocalDate;

public interface IPerson {
    public LocalDate getBirthdate();
    public void sendEmail(String message);
}
