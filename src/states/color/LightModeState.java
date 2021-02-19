package states.color;

import mediator.TodoMediator;

public class LightModeState extends StateColor {

	public LightModeState(TodoMediator mediator) {
		super(mediator);
	}

	@Override
	public void onLight() {
		//STAY ON LIGHT
	}

	@Override
	public void onDark() {
		//CHANGE TO DARK
		mediator.changeColorState(new DarkModeState(mediator));
		mediator.darkMode();
	}

}
