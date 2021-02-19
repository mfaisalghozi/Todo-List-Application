package ui;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mediator.TodoMediator;

public class Todos extends JPanel {
	private boolean btnEnable;
	private int done;
	private int currColor = 1;
	
	private TodoMediator mediator;

	private Vector<Todo> todos;

	
	public Todos(TodoMediator mediator) {
		this.mediator = mediator;
		this.todos = new Vector<>();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		displayTodos();
	}
	
	//CHANGE COLOR 
	public void changeColor(int color) {
		Vector<Todo> newTodos = new Vector<>();
		currColor = color;
		if(color == 1) {
			//CHANGE TO LIGHT MODE
			for(Todo todo : todos) {
				todo.lightMode();
				newTodos.add(todo);
			}
		}else {
			//CHANGE TO DARK MODE
			for (Todo todo : todos) {
				todo.darkMode();
				newTodos.add(todo);
			}
		}
		//ADD NEW COLOR
		this.todos = newTodos;
		displayTodos();
	}


	//ENABLE HANDLER
	public void check() {
		btnEnable = false;
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				btnEnable = true;
				break;
			}
		}
		if(btnEnable == true) enableBtn();
		else disableBtn();
	}
	
	public void enableBtn() {
		mediator.enableButton();		
	}
	
	public void disableBtn() {
		mediator.disableButton();
	}
	
	//ACTION HANDLER METHOD
	public void addTodo(String text) {
		Todo td = new Todo(text,this);
		if(currColor == 1) {
			td.lightMode();
		}else {
			td.darkMode();
		}
		todos.add(td);
		displayTodos();
	}
	
	public void done() {
		Vector<Todo> newTodos = new Vector<>();
		done = 0;
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				done++;
				continue;
			}
			newTodos.add(todo);
		}
		
		//check list
		if(newTodos.isEmpty() || !newTodos.isEmpty()) {
			disableBtn();
		}
		
		this.todos = newTodos;
		mediator.updateDone(done);
		displayTodos();
	}

	public void remove() {
		Vector<Todo> newTodos = new Vector<>();
		for (Todo todo : todos) {
			if (todo.isChecked()) {
				continue;
			}
			newTodos.add(todo);
		}
		
		//check list
		if(newTodos.isEmpty() || !newTodos.isEmpty()) {
			disableBtn();
		}
		
		this.todos = newTodos;
		displayTodos();
	}

	//DISPLAY
	private void displayTodos() {
		removeAll();
		for (Todo todo : todos) {
			this.add(todo);
		}
	}
	
	
	
}
