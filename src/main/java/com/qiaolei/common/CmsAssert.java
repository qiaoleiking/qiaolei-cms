package com.qiaolei.common;
/**
 * 
    * @ClassName: CmsAssert
    * @Description: 自定义断言
    * @author Administrator
    * @date 2019年11月18日
    *
 */
public class CmsAssert {
	
	public static void AssertTrue(boolean express,String msg){
		if(!express){
			throw new CmcException(msg);
		}
	}
}
