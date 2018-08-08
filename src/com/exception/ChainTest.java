package com.exception;

public class ChainTest {
	public static void main(String[] args) {
		ChainTest chainTest = new ChainTest();
		try {
			chainTest.test2();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦");
		}
	}
	
	public void test1() throws DefineException{
		throw new DefineException("喝车别开酒");
	}
	
	public void test2() {
		try{
			test1();
		}catch (DefineException e) {
//			e.printStackTrace();
			RuntimeException runtimeException = new RuntimeException("司机一滴酒，亲人两行泪~~~");
			runtimeException.initCause(e);
			throw runtimeException;
		}
 	}
}
