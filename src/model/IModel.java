package model;

public interface IModel {
    public void attachView();
    public void detachView();
    public void notifyViews();
    public void save();
    public void delete();
}
