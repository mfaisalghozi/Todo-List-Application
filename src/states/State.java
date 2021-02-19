package states;

import mediator.TodoMediator;

public abstract class State {
	TodoMediator mediator;
	public State(TodoMediator mediator) {
		this.mediator = mediator;
	}
	
	public abstract boolean onCheck();
	public abstract boolean onUncheck();
}
