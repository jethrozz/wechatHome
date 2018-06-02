package com.wechat.model;

/**
 */
public enum SubjectEnum {
	YUWEN(1,"语文"),
	SHUXUE(2,"数学"),
	YINGYU(3,"英语"),
	ZHENGZHI(4,"政治"),
	LISHI(5,"历史"),
	DILI(6,"地理"),
	HUAXUE(7,"化学"),
	WULI(8,"物理"),
	SHENGWU(9,"生物");


	private String name ;
	private int index ;

	SubjectEnum( int index , String name ){
		this.name = name ;
		this.index = index ;
	}

	public String getName() {
		return name;
	}
	public int getIndex(){
		return index;
	}
	//根据课程名字获取对应的编码
	public static int getCodeByName(String company) {
		for (SubjectEnum c : SubjectEnum.values()) {
			if (c.getName().equals(company.trim())) {
				return c.index;
			}
		}
		return 0;
	}
	//根据编码获取对应的名字
	public static String getNameByCode(int code) {
		for (SubjectEnum c : SubjectEnum.values()) {
			if (c.getIndex() == code) {
				return c.getName();
			}
		}
		return null;
	}
}
