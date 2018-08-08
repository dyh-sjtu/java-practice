package pukepai.test;

public class Card implements Comparable<Card> {
	public String color;
	public String number;
	public Card(String color, String number) {
		this.color = color;
		this.number = number;
	}
	
	public String toString() {
		return this.color + this.number;
	}
	
	public int compareTo(Card card) {
		if (this.getNumIndex() == card.getNumIndex()) {
			return this.getColorIndex() - card.getColorIndex();
		}
		return this.getNumIndex() - card.getNumIndex();
	}
	
	
	public int getNumIndex() {
		String[] numbers = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i].equals(number)) {
				return i;
			}
		}
		return -1;
	}
	
	public int getColorIndex() {
		String[] colors = new String[]{"红桃", "黑桃", "梅花", "方片"};
		for (int j = 0; j < colors.length; j++){
			if(colors[j].equals(color)) {
				return j;
			}
		}
		return -1;
	}
}
