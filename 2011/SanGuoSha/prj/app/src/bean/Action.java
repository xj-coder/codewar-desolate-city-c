package bean;

/**
 * 
 * @author JHS
 * 
 *         �����������������������A���������B����,���ж�������һ��ִ�н��
 * 
 */
public class Action {

	/*
	 * ��<����A>��<����B>���һ��"Ч��(EFFECT )"(<����B>�ɽ��ܵ�)
	 */
	public static int DO_EFFECT = 0x1;
	/*
	 * Ҫ��<����A>��<����B>���һ��"Ч��(EFFECT )"(<����B>�ɽ��ܵ�)
	 */
	public static int ASK_EFFECT = 0x2;
	/*
	 * ��<����A>��<����B>ʵʩһ��"����(ACTION)"
	 */
	public static int DO_ACTION = 0x3;
	/*
	 * Ҫ��<����A>��<����B>ʵʩһ��"����(ACTION)"
	 */
	public static int ASK_ACTION = 0x4;
	/*
	 * ��<����A>��<����B>���һ��"��(CARD)"
	 */
	public static int DO_CARD = 0x5;
	/*
	 * Ҫ��<����A>��<����B>���һ��"��(CARD)"
	 */
	public static int ASK_CARD = 0x6;

	private int actionType;
	private Actor actorA;
	private Actor actorB;

	private Effect effect;
	private Card card;
	private Action action;

	public int getActionType() {
		return actionType;
	}

	public void setActionType(int actionType) {
		this.actionType = actionType;
	}

	public Actor getActorA() {
		return actorA;
	}

	public void setActorA(Actor actorA) {
		this.actorA = actorA;
	}

	public Actor getActorB() {
		return actorB;
	}

	public void setActorB(Actor actorB) {
		this.actorB = actorB;
	}

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
}
