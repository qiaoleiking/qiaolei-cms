package com.qiaolei.common;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
    * @ClassName: Md5
    * @Description: 加盐操作
    * @author Administrator
    * @date 2019年11月18日
    *
 */
public class Md5 {
	
	public static String password(String password,String salt){
		return DigestUtils.md5Hex(password + "::::"+salt );
	}
	
}
