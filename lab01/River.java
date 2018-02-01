package lab01;

public class River extends BodyOfWater {
	private BodyOfWater flowsInto;
	private int riverLength;
	public River(String aName, BodyOfWater flInto, int len) {
		super(aName);
		flowsInto = flInto;
		riverLength = len;
	}
	public BodyOfWater getFlowsInto() {
		return flowsInto;
	}
	public String flowsOutTo() {
		if(flowsInto instanceof River) {
			return ((River)flowsInto).flowsOutTo();
		}
		else {
			return ((BodyOfWater)flowsInto).getName();
		}
	}
}
