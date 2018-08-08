package pukepai.test;

import java.util.ArrayList;

public class Player {
	public int id;
	public String name;
	public ArrayList<Card> selectedCards;
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		this.selectedCards = new ArrayList<>();
	}
	
	public String toString() {
		return "ID: " + this.id +  ", Name:" + this.name;
	}
 
	public void addCard(Card card) {
		this.selectedCards.add(card);
	}
	
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (!(o instanceof Player)) {
			return false;
		}
		Player player = (Player)o;
		return this.id == player.id;
	}
}
