package model;

/**
 *
 * Factory to create a customer
 * @author Group 3
 */
public abstract class CustomerFactory {

    /**
     * Concrete customer factory
     *
     * @param name customer's name
     * @param email customer's
     * @param street
     * @param city
     * @return
     */
    public abstract   Customer createCustomer(String name, String street, String city, String state, String zip, String email);



}
