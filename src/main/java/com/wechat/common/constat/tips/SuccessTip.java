package com.wechat.common.constat.tips;

/**
 * 返回给前台的成功提示
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:05:22
 */
public class SuccessTip extends Tip{
	
	public SuccessTip(){
		super.code = 200;
		super.message = "操作成功";
	}

	public SuccessTip(int code, Object data){
		this.code = code;
		this.setData(data);
	}


	public SuccessTip(int code, String message,Object data){
		this.code = code;
		this.setData(data);
		this.message = message;
	}
}
