package controller;

import view.IView;

public interface IController {
    public void add(IView view);
    public void update(IView view);
    public void get(IView view);
    public void delete(IView view);
}
