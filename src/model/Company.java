package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.ICompany;
import view.IView;

public class Company extends Customer implements ICompany {
    private int numberOfEmployees;
	List<IView> observers;

    protected Company(String name, String email, int numberOfEmployees,String street, String city, String state, String zip) {
        super(name, email, street,city,state,zip);
        this.numberOfEmployees = numberOfEmployees;
        this.observers = new ArrayList<>();
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public void sendEmail(String message) {
    	System.out.println("Email sent to " + this.getEmail());
    }
    
    @Override
	public void notifyViews() {
		for(IView observer: this.observers) observer.update();
	}

	@Override
	public void attachView(IView view) {
		this.observers.add(view);		
	}

	@Override
	public void detachView(IView view) {
		this.observers.remove(view);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
}
