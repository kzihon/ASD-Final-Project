package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

final public class CreationalAction extends JButton {
	private static final long serialVersionUID = 1215265835720157451L;
	
	private CreationalOperationModalView modalView;
	
	public CreationalAction(String actionTitle, CreationalOperationModalView modalView) {
		super();
		setText(actionTitle);
		this.modalView = modalView;
		
		this.addActionListener(new SymAction());
	}
	
	private class SymAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CreationalAction.this.actionPerformed(event);
		}
	}

    private void actionPerformed(ActionEvent event) {
		this.modalView.setBounds(430, 50, 300, 400);
		this.modalView.setVisible(true);
	}
}
