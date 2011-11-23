package bean;

/**
 * 
 * @author JHS
 * 
 *         动作：动作可以由任意对象A向任意对象B进行,所有动作都有一个执行结果
 * 
 */
public class Action {

	/*
	 * 由<对象A>对<对象B>添加一个"效果(EFFECT )"(<对象B>可接受的)
	 */
	public static int DO_EFFECT = 0x1;
	/*
	 * 要求<对象A>对<对象B>添加一个"效果(EFFECT )"(<对象B>可接受的)
	 */
	public static int ASK_EFFECT = 0x2;
	/*
	 * 由<对象A>对<对象B>实施一个"动作(ACTION)"
	 */
	public static int DO_ACTION = 0x3;
	/*
	 * 要求<对象A>对<对象B>实施一个"动作(ACTION)"
	 */
	public static int ASK_ACTION = 0x4;
	/*
	 * 由<对象A>向<对象B>打出一张"牌(CARD)"
	 */
	public static int DO_CARD = 0x5;
	/*
	 * 要求<对象A>向<对象B>打出一张"牌(CARD)"
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
