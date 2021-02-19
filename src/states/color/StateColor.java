package states.color;

import mediator.TodoMediator;

public abstract class StateColor {
	TodoMediator mediator;
	public StateColor(TodoMediator mediator) {
		this.mediator = mediator;
	}
	
	public abstract void onLight();
	public abstract void onDark();
}
