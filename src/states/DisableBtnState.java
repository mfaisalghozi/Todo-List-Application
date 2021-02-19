package states;

import mediator.TodoMediator;

public class DisableBtnState extends State {

	public DisableBtnState(TodoMediator mediator) {
		super(mediator);
	}

	@Override
	public boolean onCheck() {
		mediator.changeState(new EnableBtnState(mediator));
		return false;
	}

	@Override
	public boolean onUncheck() {
		return true;
	}

}
