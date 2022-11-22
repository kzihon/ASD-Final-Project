package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.IController;

abstract public class FinancialOperationModalView extends JDialog implements IView {
	private static final long serialVersionUID = -5928761689396415117L;
	
	private IController controller;
	
	//{{DECLARE_CONTROLS
	JLabel JLabelAccountNumber = new javax.swing.JLabel();
	JLabel JLabelAmount = new javax.swing.JLabel();
	JTextField JTextField_AccountNumber = new javax.swing.JTextField();
	JButton JButton_OK = new javax.swing.JButton();
	JButton JButton_Cancel = new javax.swing.JButton();
	JTextField JTextField_Amount = new javax.swing.JTextField();
	//}}
	
	public FinancialOperationModalView(MainFrame parent, String operationTitle, String accountLabelTitle, String accountNumber) {
		super(parent);
		setTitle(operationTitle);
		setModal(true);
		getContentPane().setLayout(null);
		setSize(300,140);
		setVisible(false);

		JLabelAccountNumber.setText(accountLabelTitle);
		getContentPane().add(JLabelAccountNumber);
		JLabelAccountNumber.setForeground(java.awt.Color.black);
		JLabelAccountNumber.setBounds(12,12,48,24);
		
		JLabelAmount.setText("Amount");
		getContentPane().add(JLabelAmount);
		JLabelAmount.setForeground(java.awt.Color.black);
		JLabelAmount.setBounds(12,48,48,24);
		
		JTextField_AccountNumber.setEditable(false);
		getContentPane().add(JTextField_AccountNumber);
		JTextField_AccountNumber.setBounds(84,12,144,24);
		JTextField_AccountNumber.setText(accountNumber);
		
		getContentPane().add(JTextField_Amount);
		JTextField_Amount.setBounds(84,48,144,24);
		
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);		
		JButton_OK.setBounds(36,84,84,24);
		
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);

		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		//}}
	}
	
	class SymAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK) JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel) JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(ActionEvent event) {
		if(this.controller == null) {
			JOptionPane.showMessageDialog(JButton_OK, "The controller to handle this request was not set!", "Warning: null controller found", JOptionPane.WARNING_MESSAGE);
			return;
		}
        this.controller.add();
        dispose();
	}

	void JButtonCalcel_actionPerformed(ActionEvent event) {
		dispose();
	}
	
	public void setController(IController controller) {
		this.controller = controller;
	}
	
	public String getAmount() {
		return JTextField_Amount.getText();
	}
	
	public String getAccountNumber() {
		return JTextField_AccountNumber.getText();
	}
	
	public void update() {
		
	}
}
