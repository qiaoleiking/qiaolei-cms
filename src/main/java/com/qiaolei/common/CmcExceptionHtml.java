package com.qiaolei.common;
/**
 * 
    * @ClassName: CmcExceptionHtml
    * @Description:在HTML页面展示抛出的异常
    * @author Administrator
    * @date 2019年11月22日
    *
 */
public class CmcExceptionHtml extends RuntimeException{

	
	    /**
	    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	    */
	    
	private static final long serialVersionUID = 3751790087617971417L;

	
	public CmcExceptionHtml(String msg){
		super(msg);
	}
	
}
