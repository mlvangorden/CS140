package projectview;

import javax.swing.Timer;

public class StepControl {
	private static final int TICK = 500;
	private boolean autoStepOn = false;
	private Timer timer;
	private ViewMediator mediator;
	
	public StepControl(ViewMediator mediator) {
		this.mediator = mediator;
	}
	
	boolean isAutoStepOn() {
		return autoStepOn;
	}
	
	void setAutoStepOn(boolean step) {
		autoStepOn = step;
	}
	
	void toggleAutoStep() {
		autoStepOn = !autoStepOn;
	}
	
	void setPeriod(int period) {
		timer.setDelay(period);
	}
	
	void start() {
		timer = new Timer(TICK, e -> {if(autoStepOn) mediator.step();});
		timer.start();
	}
}
