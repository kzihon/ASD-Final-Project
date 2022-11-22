package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.IModel;

abstract public class ListView extends JTable implements IView {
	private static final long serialVersionUID = -2596634554218077128L;
	private DefaultTableModel tableModel;
	private JTable internalTable;
	
	IModel model;
	
	
	public ListView() {
		this.tableModel = new DefaultTableModel();
		this.internalTable = new JTable(this.tableModel);
	}
	
	protected JTable getTable() {
		return this.internalTable;
	}
	
	public void addColumn(String columnTitle) {
		this.tableModel.addColumn(columnTitle);
	}
	
	public boolean doesAnItemHaveBeenSelected() {
		return this.internalTable.getSelectionModel().getMinSelectionIndex() >=0;
	}
	
	public int getPositionOfTheSelectedItem() {
		return this.internalTable.getSelectionModel().getMinSelectionIndex();
	}
	
	public void addAnItem(Object ...valuesForColumns) {
		Object[] rowData = new Object[valuesForColumns.length];
		int index = 0;
		for(Object value: valuesForColumns) rowData[index++] = value;
		this.tableModel.addRow(rowData);
	}
	
	abstract public void update();

}
