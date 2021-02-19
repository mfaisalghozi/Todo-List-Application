package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mediator.TodoMediator;

public class TodoInput extends JPanel implements ActionListener, KeyListener {
	
	private JTextField text;
	private JButton add;
	
	private TodoMediator mediator;
	
	private boolean changeColor = false;

	public TodoInput(TodoMediator mediator) {
		this.mediator = mediator;

		text = new JTextField(20);
		add = new JButton("Add");

		this.add(text);
		this.add(add);
		
		text.addKeyListener(this);
		add.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!e.getSource().equals(add)) {
			return;
		}

		String todoText = this.text.getText();
		mediator.addTodo(todoText);
		this.text.setText("");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int str = e.getKeyCode();
		if(str == 78) {
			mediator.setChangeColor(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int str = e.getKeyCode();
		if(str == 78) {
			mediator.setChangeColor(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
