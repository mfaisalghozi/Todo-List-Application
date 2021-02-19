package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Todo extends JPanel  {
	private Todos todos;
	private Border border;
	private JLabel label;
	private JCheckBox checkbox;

	public Todo(String text, Todos todos) {
		this.todos = todos;
	
		this.setPreferredSize(new Dimension(350, 30));

		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
		this.setLayout(new BorderLayout());

		checkbox = new JCheckBox();
		this.add(checkbox, BorderLayout.WEST);

		label = new JLabel(text);
		this.add(label, BorderLayout.CENTER);
		
		checkbox.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent arg0) {
		        if (checkbox.isSelected()) {
		            todos.check();
		        }else {
		        	todos.check();	   
		        }
		    }
		});

	}
	
	public void darkMode() {
		border = BorderFactory.createLineBorder(Color.WHITE, 1);
		this.setBorder(border);
		this.setBackground(Color.BLACK);
		checkbox.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		
	}
	
	public void lightMode() {
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		this.setBorder(border);
		this.setBackground(Color.WHITE);
		checkbox.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
	}
	
	public boolean isChecked() {
		return checkbox.isSelected();
	}
}
