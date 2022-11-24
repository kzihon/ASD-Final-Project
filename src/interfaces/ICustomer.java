package interfaces;

import java.util.List;

import model.Address;
import model.IModel;

public interface ICustomer extends IModel {
	String getName();
	void setName(String name);
	String getEmail();
	void setEmail(String email);
	List<IAccount> getAccounts();
	Address getAddress();
	void setAddress(Address address);
	void sendEmail(String message);
}
