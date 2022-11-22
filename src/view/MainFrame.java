package view;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JPanel;

abstract public class MainFrame extends JFrame implements IView {
	private static final long serialVersionUID = -8034570039932382815L;
	
	protected ListView dataListView;
	protected JScrollPane scrollContainer;
	protected JPanel pageContainer;
	
	public MainFrame(String pageTitle) {
		this.setTitle(pageTitle);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(640,480);
		setVisible(false);		
		
		this.pageContainer = new JPanel();
		this.pageContainer.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, this.pageContainer);
		this.pageContainer.setBounds(0,0,576,310);
		
		this.scrollContainer = new JScrollPane();
		this.scrollContainer.setBounds(12,92,444,160);
		
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}
	
	public void setListView(ListView listView) {
		this.scrollContainer.getViewport().add(listView.getTable());
        listView.getTable().setBounds(0, 0, 420, 0);
	}
	
	abstract public void update();
	
	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == MainFrame.this) MainFrame_windowClosing(event);
		}
	}

	void MainFrame_windowClosing(WindowEvent event) {
		MainFrame_windowClosing_Interaction(event);
	}

	void MainFrame_windowClosing_Interaction(WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}
	
	void exitApplication() {
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {}
	}

}
