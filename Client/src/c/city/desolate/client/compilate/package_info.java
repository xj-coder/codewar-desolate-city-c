/**
 * <PRE>
 * 这是一个IDE扩展包.
 * 其中有三中类
 * 1)扩展编译
 * 		比如 :如果希望该平台支持Java语言，可在这个包中新建一个包java,在其中至少添加一个Java类，
 * 		该类必须继承Code的某个子类,
 * 		这个子类已经实现了Code中除了compilate()、initialization()和run()这三个抽象方法方法以外的所有抽象方法
 * 		该类必须实现这三个为实现的方法
 * 2)扩展外观及功能
 * 		这种类直接继承Code,本身还是个抽象类,无法实例化.
 * 		实现Code中除了compilate()、initialization()和run()这三个抽象方法方法以外的所有抽象方法
 * 		也可添加自己的功能,
 * 		这种扩展无法编译源代码,
 * 3)扩展外观及功能并实现编译
 *		这种情况不应该常见，情况是：
 *		该类继承Code或Code的子类,
 *		若直接继承与Code类,则实现Code类中的所有抽象方法
 *		若继承与Code的子类,则实现该子类的 	compilate()、initialization()和run(),并覆盖了该子类的其他方法
 *		该情况不提倡出现	
 *
 * 并在ides-config.xml中配置相关信息
 * </PRE>
 * @author Desolate.City.C
 */
package c.city.desolate.client.compilate;

