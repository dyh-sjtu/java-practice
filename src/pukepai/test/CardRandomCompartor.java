package pukepai.test;

import java.util.Comparator;

public class CardRandomCompartor implements Comparator<Card> {
	
	/**
	 * 随机洗牌
	 * @param card1
	 * @param card2
	 * @return
	 */
	@Override
	public int compare(Card card1, Card card2) {
		Double random = Math.random();
		return random > 0.5 ? 1 : random < 0.5 ? -1 : 0;
	}
}
