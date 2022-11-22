package view;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

final public class RadioButtonTypeAccount extends JRadioButton implements IView, IColleague {
	private static final long serialVersionUID = 6370523961137812426L;
	private IMediator mediator;
	
	public RadioButtonTypeAccount(String text, String action) {
		super();
		setText(text);
		setActionCommand(action);
		addMouseListener(new SymMouse());
	}
	
	private class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			RadioButtonTypeAccount.this.mouseClicked(event);
		}
	}

	private void mouseClicked(java.awt.event.MouseEvent event) {
		this.setSelected(true);
		if(this.mediator == null) {
			JOptionPane.showMessageDialog(this.getParent(), "The mediator for this radio was not set!", "Warning: null mediator found", JOptionPane.WARNING_MESSAGE);
			return;
		}
		this.mediator.informOtherColleagues(this);
	}
	
	@Override public void setMediator(IMediator mediator) {
		this.mediator = mediator;
	}

	@Override public void update() {
		this.setSelected(false);
	}

}
