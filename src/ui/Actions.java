package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mediator.TodoMediator;

public class Actions extends JPanel implements ActionListener {

	private TodoMediator mediator;
	private JButton done;
	private JButton remove;

	public Actions(TodoMediator mediator) {
		this.mediator = mediator;
		
		done = new JButton("Done");
		remove = new JButton("Remove");

		this.add(done);
		this.add(remove);

		done.addActionListener(this);
		remove.addActionListener(this);
		
		done.setEnabled(false);
		remove.setEnabled(false);
	}
	
	public void enableButton() {
		done.setEnabled(true);
		remove.setEnabled(true);
	}
	
	public void disableButton() {
		done.setEnabled(false);
		remove.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(done)) {
			mediator.doneTodos();
		}

		if (e.getSource().equals(remove)) {
			mediator.removeTodos();
		}
	}
}
