package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import interfaces.IEntry;
import view.IView;

public abstract class Entry implements IEntry {
	final private List<IView> observers;
    private double amount;
    private LocalDate date;

    public Entry(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
        this.observers = new ArrayList<>();
    }
    
    public double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public abstract void execute();
    
    @Override final public void notifyViews() {
		for(IView observer: this.observers) observer.update();
	}

	@Override final public void attachView(IView view) {
		this.observers.add(view);		
	}

	@Override final public void detachView(IView view) {
		this.observers.remove(view);
	}
}
