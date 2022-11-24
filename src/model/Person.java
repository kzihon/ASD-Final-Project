package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import interfaces.IPerson;
import view.IView;

public class Person extends Customer implements IPerson {
	List<IView> observers;
    private LocalDate birthdate;

    protected Person(String name, String email,  LocalDate birthdate, String street, String city, String state, String zip) {
        super(name, email, street, city, state, zip);
        this.birthdate = birthdate;
        this.observers = new ArrayList<>();
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public void sendEmail(String message) {
        System.out.println("Email: " + message + ". Sent to " + this.getEmail());
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
