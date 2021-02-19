package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import mediator.TodoMediator;

public class TodoFrame extends JFrame {
	
	private TodoMediator mediator;
	
	public TodoFrame(TodoMediator mediator) {
		this.mediator = mediator;
	}
	
	//MAIN CONFIG
	public void configFrame() {
		Action act = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mediator.changeColor();
			}
		};
		
		this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("N"), "pressed");
        this.getRootPane().getActionMap().put("pressed", act);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
	}
	
	//COLOR CONFIG
	public void configFrameColor(int color) {
		if(color==0) {
			//SET DARKMODE FRAME
			this.getContentPane().setBackground(Color.BLACK);
		}else {
			//SET LIGHTMODE FRAME
			this.getContentPane().setBackground(Color.WHITE);
		}
		
	}

}
