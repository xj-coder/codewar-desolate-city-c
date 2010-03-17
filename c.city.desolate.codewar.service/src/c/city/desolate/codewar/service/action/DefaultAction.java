package c.city.desolate.codewar.service.action;
/**
 * 基础Action
 * 所有Action都要继承此Action,并实现抽象方法
 * @author Administrator
 *
 */
public class DefaultAction {

	public byte[] defaultMethod(Object[] params){
		
		return new byte[]{0};
	}
}
