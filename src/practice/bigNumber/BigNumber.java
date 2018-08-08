package practice.bigNumber;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigNumber {
	public static void main(String[] args) {
		/**
		 * BigDecimal类
		 */
		BigDecimal a = BigDecimal.valueOf(2.0);
		BigDecimal b = BigDecimal.valueOf(3.0);
		System.out.println(a.divide(b, RoundingMode.HALF_UP));
		
		/**
		 * BigInteger类
		 */
		BigInteger c = BigInteger.valueOf(3);
		BigInteger d = BigInteger.valueOf(4);
		System.out.println(c.divide(d));
	}
}
