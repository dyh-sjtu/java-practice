package pukepai.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	public ArrayList<Card> cards;
	public ArrayList<Player> players;
	public Game() {
		this.cards = new ArrayList<>();
		this.players = new ArrayList<>();
	}
	
	/**
	 * 创建扑克牌
	 */
	public void initCards() {
		System.out.println("-----------创建扑克牌--------------");
		String[] numbers = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] colors = new String[]{"红桃", "黑桃", "梅花", "方片"};
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				cards.add(new Card(colors[i], numbers[j]));
			}
		}
		System.out.println("-----------扑克牌创建成功！--------------");
		System.out.println(cards.toString());
	}
	
	/**
	 * 洗牌
	 */
	public void randomCars() {
		System.out.println("-----------开始洗牌！--------------");
		cards.sort(new CardRandomCompartor());
		System.out.println("-----------洗牌结束！--------------");
		System.out.println(cards.toString());
	}
	
	/**
	 * 初始化玩家两人
	 */
	public void initPlayers() {
		Scanner scanner = new Scanner(System.in);
		int i = 1;
		do {
			System.out.println("请输入第" + i + "位玩家的ID和姓名");
			while (true) {
				try {
					System.out.println("请输入玩家ID: ");
					int id = scanner.nextInt();
					if (players.contains(new Player(id, null))) {
						throw new Exception();
					}
					System.out.println("请输入玩家姓名: ");
					String name = scanner.next();
					players.add(new Player(id, name));
					break;
				}catch(InputMismatchException e){
					scanner = new Scanner(System.in);
					//这个必须有，不然就是死循环了
					System.out.println("请输入整数类型的ID!");
				} catch (Exception e) {
					System.out.println("该ID已存在，请重新输入玩家ID");
				}
			}
			i++;
		}while (i < 3);
		for(Player player: players){
			System.out.println("---欢迎玩家："+player.name);
		}
	}
	
	/**
	 * 发牌
	 */
	public void disPatch() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < players.size(); j++) {
				System.out.println("玩家" + players.get(j).name + "拿牌");
				players.get(j).addCard(cards.get(i));
				cards.remove(0);
				System.out.println("玩家" + players.get(j).name + "拿第" + i + "张牌");
			}
		}
		System.out.println(cards.size());
		System.out.println("-----------发牌结束！--------------");
	}
	
	/**
	 * 比较牌的大小
	 */
	public void compareCard() {
		for (int i =0; i < players.size(); i++) {
			players.get(i).selectedCards.sort(null);
			System.out.println("玩家" + players.get(i).name + "的最大手牌为" + players.get(i).selectedCards.get(1));
		}
		int res = players.get(0).selectedCards.get(1).compareTo(players.get(1).selectedCards.get(1));
		String winner = res > 0 ? players.get(0).name : players.get(1).name;
		System.out.println("-----------玩家" + winner + "获胜-----------");
	}
	
	/**
	 * 最后展示手牌
	 */
	public void showCards() {
		System.out.println("-----------玩家手牌展示--------------");
		System.out.println(players.get(0)+" 手牌: "+players.get(0).selectedCards);
		System.out.println(players.get(1)+" 手牌: "+players.get(1).selectedCards);
	}
	
	public static void main(String[] args) {
	    Game game = new Game();
	    game.initCards();
	    game.randomCars();
	    game.initPlayers();
	    game.disPatch();
	    game.compareCard();
	    game.showCards();
	    System.out.println("-----------游戏结束-----------");
	}
}
