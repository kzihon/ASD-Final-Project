package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.IController;

final public class InterestAction extends JButton {
	private static final long serialVersionUID = 1215265835720157451L;
	
	private InterestDialog modal;
	private IController controller;
	
	private class InterestDialog extends JDialog implements IView {
		private static final long serialVersionUID = -4233769132548895495L;
		
		JScrollPane scrollPanel = new JScrollPane();
		JTextField textField_PARAGRAPH = new JTextField();
		
		private JButton JButton_OK = new JButton();
		private JButton JButton_Cancel = new JButton();
		
		public InterestDialog(MainFrame parent, String title, String paragraph) {
			super(parent);
			setTitle("Add compamy account");
			setModal(true);
			getContentPane().setLayout(null);
			setSize(300,140);
			setVisible(false);
			
			getContentPane().add(scrollPanel);
			scrollPanel.setBounds(24,24,280,100);
			
			textField_PARAGRAPH.setText(paragraph);
			scrollPanel.getViewport().add(textField_PARAGRAPH);
			textField_PARAGRAPH.setBounds(0, 0, 275,95);
			
			JButton_OK.setText("OK");
			JButton_OK.setActionCommand("OK");
			getContentPane().add(JButton_OK);		
			JButton_OK.setBounds(36,84,84,24);
			
			JButton_Cancel.setText("Cancel");
			JButton_Cancel.setActionCommand("Cancel");
			getContentPane().add(JButton_Cancel);
			JButton_Cancel.setBounds(156,84,84,24);
			
			//{{REGISTER_LISTENERS
			DialogAction lSymAction = new DialogAction();
			JButton_OK.addActionListener(lSymAction);
			JButton_Cancel.addActionListener(lSymAction);
			//}}
		}
		
		private class DialogAction implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Object object = event.getSource();
				if (object == JButton_OK) JButtonOK_actionPerformed(event);
				else if (object == JButton_Cancel) JButtonCalcel_actionPerformed(event);
			}
		}

		private void JButtonOK_actionPerformed(ActionEvent event) {
			if(InterestAction.this.controller == null) {
				JOptionPane.showMessageDialog(JButton_OK, "The controller to handle this request was not set!", "Warning: null controller found", JOptionPane.WARNING_MESSAGE);
				return;
			}
			InterestAction.this.controller.add(this);
		}

		private void JButtonCalcel_actionPerformed(ActionEvent event) {
			dispose();
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
			
		}
	}
	
	public InterestAction(MainFrame pageParent, String actionTitle, String paragraph) {
		super();
		setText(actionTitle);

		this.modal = new InterestDialog(pageParent, actionTitle, paragraph);		
		this.addActionListener(new SymAction());
	}
	
	private class SymAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			InterestAction.this.actionPerformed(event);
		}
	}
	
	public void setController(IController controller) {
		this.controller = controller;
	}

    private void actionPerformed(ActionEvent event) {
    	if(this.controller == null) {
			JOptionPane.showMessageDialog(this, "The controller to handle this request was not set!", "Warning: null controller found", JOptionPane.WARNING_MESSAGE);
			return;
		}
		this.modal.setBounds(430, 50, 300, 140);
		this.modal.setVisible(true);
	}
}
