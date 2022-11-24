package dao;

import java.util.List;

import interfaces.IPerson;
import model.IModel;

public class DefaultPersonDAO implements DAO {

	@Override
	public void persist(IModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(IModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public IModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(IModel model) {
		// TODO Auto-generated method stub

	}
	
	static public IPerson getByEmail(String email) {
		return null;
	}

}
