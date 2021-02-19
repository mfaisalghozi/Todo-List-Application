package states.color;

import mediator.TodoMediator;

public class DarkModeState extends StateColor {

	public DarkModeState(TodoMediator mediator) {
		super(mediator);
	}

	@Override
	public void onLight() {
		//CHANGE TO LIGHT
		mediator.changeColorState(new LightModeState(mediator));
		mediator.lightMode();
	}

	@Override
	public void onDark() {
		//STAY DARK
	}

}
