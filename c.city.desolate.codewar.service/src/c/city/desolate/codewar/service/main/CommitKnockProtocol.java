package c.city.desolate.codewar.service.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import c.city.desolate.codewar.service.util.ActionXMLParse;


/**
 * @author jhs
 * @see 协议处理
 */
public class CommitKnockProtocol {
    /**
     * 协议提交
     * 
     * @param data
     * @throws UnsupportedEncodingException 
     */
    public byte[] commint(byte[] data) throws UnsupportedEncodingException{
    	byte[] result = null;
    	String className = null;
    	String[] commands = new String(data,Properties.ENCODING).split("/");
    	
    	//验证commands完整性
    	if(commands.length<3){
    		return new byte[]{0};
    		//[TODO]提示信息不完整
    	}
    	
    	if(verifyHead(commands[0])){
    		if((className = chooseAction(commands)) != null){
    			if((result = ExecuteMethod(className,commands))==null){
    				//[TODO]提示action中没有定义指定方法
    			}
    		}else{
    			//[TODO]提示action未定义
    		}
    	}else{
    		//[TODO]提示登入验证失败
    	}
    	
    	return result;
    }

    private byte[] ExecuteMethod(String className, String[] commands) {
    	String[] params = commands[2].split("-");
    	String[] values = new String[params.length-1];
    	for(int i=1;i<params.length;i++){
    		values[i-1] = params[i];
    	}
    	Class<?> _class;
	    try {
			_class = Class.forName(className);
			Object obj = _class.newInstance();
			Method[] methods = _class.getMethods();
			
			for (Method method : methods) {
			    if(method.getName().equals(params[0])){
			    	return (byte[]) method.invoke(obj, values);
			    }
			}
			return (byte[]) _class.getMethod("defaultMethod"
					, new Class<?>[]{Object[].class}).invoke(obj, values);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
     * 根据action.xml得到action处理类
     */
    private String chooseAction(String[] commands) {
		return ActionXMLParse.getActionClass(commands[1]);
	}

	/**
     * 验证消息合法性
     * 
     * @param verifyHead
     * @return
     */
    private boolean verifyHead(String verifyHead) {
	// TODO[JHS][添加功能] [验证消息合法性]
	if (verifyHead == null) {
	    return false;
	}
	return true;
    }

    /**
     * 向客户端发送信息
     * 
     * @throws IOException
     */
    public void sendMessage(OutputStream os, byte[] message)
	    throws IOException {
    	os.write(message);
    	os.flush();
    }
}
