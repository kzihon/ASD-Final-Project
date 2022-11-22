package dao;

import model.IModel;

import java.util.List;

public interface DAO {
    public void create(IModel model);
    public void update(IModel model);
    public IModel get();
    public List<IModel> getAll();
    public void delete();
}
