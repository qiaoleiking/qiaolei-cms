package com.qiaolei.common;

import java.io.Serializable;

/*
 * 
    * @ClassName: MsgResult
    * @Description: 用于前后端交互的协议
    * @author Administrator
    * @date 2019年11月13日
    *
 */
public class MsgResult implements Serializable{
	
	private Integer result;
	private String errorMsg;
	private Object data;
	
	public MsgResult(Integer result, String errorMsg, Object data) {
		super();
		this.result = result;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	public MsgResult() {
		super();
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
}











