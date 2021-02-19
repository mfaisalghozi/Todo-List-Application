package states;

import mediator.TodoMediator;

public class EnableBtnState extends State {

	public EnableBtnState(TodoMediator mediator) {
		super(mediator);
	}

	@Override
	public boolean onCheck() {
		return true;
	}

	@Override
	public boolean onUncheck() {
		mediator.changeState(new DisableBtnState(mediator));
		return false;
	}

}
