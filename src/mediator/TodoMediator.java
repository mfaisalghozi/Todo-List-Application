package mediator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;


import states.DisableBtnState;
import states.State;
import states.color.DarkModeState;
import states.color.LightModeState;
import states.color.StateColor;
import thread.color.ThreadColor;
import ui.Actions;
import ui.TodoInput;
import ui.Todos;
import ui.TodoFrame;

public class TodoMediator {
	private StateColor clrState;
	private State btnState;
	private TodoInput todoInput;
	private Todos todos;
	private Actions actions;
	private TodoFrame TodoFrame;
	
	private boolean changeColor = false;
	private boolean color = true;	
	private int done = 0;
	
	public TodoMediator() {
		ThreadColorCheck();
		TodoFrame = new TodoFrame(this);
		btnState = new DisableBtnState(this);
		clrState = new LightModeState(this);
		createGUI();
	}
	
	//TIME CHECK FOR COLOR CHANGE
	public void ThreadColorCheck() {         
         //USING TIMER
         Timer timer = new Timer();
         timer.schedule(new ThreadColor(this),1000,1000);
	}
	
	
	//COLOR STATE
	public void changeColorState(StateColor state) {
		this.clrState = state;
	}
	
	public StateColor getColorState() {
		return clrState;
	}
	
	//BUTTON STATE
	public void changeState(State state) {
		this.btnState = state;
	}
	
	public State getState() {
		return btnState;
	}
	
	
	//GUI FUNCTION HANDLER
	public void addTodo(String text) {
		changeColor = true;
		todos.addTodo(text);
		TodoFrame.pack();
	}

	public void doneTodos() {
		todos.done();
		updateTitle();
		TodoFrame.pack();
	}
	
	public void updateDone(int totalDone) {
		done = done + totalDone;
	}
	
	public void updateTitle() {
		TodoFrame.setTitle("Done: " + done);
	}

	public void removeTodos() {
		todos.remove();
		TodoFrame.pack();
	}

	public void enableButton() {
		this.getState().onCheck();
		actions.enableButton();
	}

	public void disableButton() {
		this.getState().onUncheck();
		actions.disableButton();
	}
	
	
	//CHANGE COLOR HANDLING
	public void setChangeColor(boolean col) {
		changeColor = col; 
	}
	
	public void changeColor() {
		if(changeColor) {
			if(color) {
				this.getColorState().onDark();
			}else {
				this.getColorState().onLight();
			}
			color = !color;
		}
	}
	
	// DARK => 0 || true
	public void darkMode() {
		TodoFrame.configFrameColor(0);
		todoInput.setBackground(Color.BLACK);
		todos.setBackground(Color.BLACK);
		actions.setBackground(Color.BLACK);
		todos.changeColor(0);
	}
	
	//  LIGHT => 1 || false
	public void lightMode() {
		TodoFrame.configFrameColor(1);
		todoInput.setBackground(Color.WHITE);
		todos.setBackground(Color.WHITE);
		actions.setBackground(Color.WHITE);
		todos.changeColor(1);
	}
	
	//Creating GUI
	public void createGUI() {
		updateTitle();
		
		todoInput = new TodoInput(this);
		TodoFrame.add(todoInput, BorderLayout.NORTH);

		todos = new Todos(this);
		TodoFrame.add(todos, BorderLayout.CENTER);

		actions = new Actions(this);
		TodoFrame.add(actions, BorderLayout.SOUTH);	
		
		TodoFrame.configFrame();
	}
	
	
}
