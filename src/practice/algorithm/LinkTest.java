package practice.algorithm;

/**
 * 丢手帕问题
 */
public class LinkTest {
	public static void main(String[] args) {
		CycleLink cycleLink = new CycleLink();
		cycleLink.setLen(9);
		cycleLink.createLink();
		cycleLink.show();
		cycleLink.setK(2);
		cycleLink.setM(2);
		cycleLink.play();
	}
}


/**
 * 构建环形链表
 */
class Child {
	int no;
	Child nextChild = null; // 该节点的下一个指针
	
	public Child(int no) {
		this.no = no;
	}
}

class CycleLink{
	/**
	 * 指向第一个元素
	 */
	Child firstChild = null;
	Child temp = null;
	int len = 0;
	int k = 0;
	int m = 0;
	
	/**
	 * 设置链表大小
	 * @param len
	 */
	public void setLen(int len) {
		this.len = len;
	}
	
	/**
	 * 设置从第几个人开始数数
	 */
	public void setK(int k) {
		this.k = k;
	}
	
	/**
	 * 设置m,隔几个人丢手帕
	 */
	public void setM(int m) {
		this.m = m;
	}
	
	public void play() {
		// 设置临时指针
		Child temp = this.firstChild;
		// 先开始找到数数的人
		for (int i = 1; i < k; i++) {
			temp = temp.nextChild;
		}
		
		// 数m下
		while (this.len != 1) {
			for (int j = 0; j < m-1; j++) {
				temp = temp.nextChild;
			}
			
			// 将数到m的小孩移出链表
			temp.nextChild = temp.nextChild.nextChild;
			// 将出去那个元素的下一个元素设置为当前开始数的元素
			temp = temp.nextChild.nextChild;
			// 链表长度减一
			this.len--;
			System.out.println("还剩" + this.len + "个元素" + "分别为: >>>>>>");
			this.show();
		}
		
		// 输出最后一个元素
		System.out.println("最后出去的元素" + temp.no);
	}
	
	/**
	 * 初始化环形链表
	 */
	public void createLink() {
		for (int i = 1; i <= len; i++) {
			if(i == 1) {
				Child ch = new Child(i);  // 设置第一个元素，临时指针和第一个元素同时指向第一个元素
				this.firstChild = ch;
				this.temp = ch;
			}else {
				if (i == len) { // 最后一个元素要重新指向第一个元素
					Child ch = new Child(i);
					temp.nextChild = ch;
					ch.nextChild = firstChild;
				}else {
					Child ch = new Child(i);  // 临时指针的下一个元素指向第当前元素， 同时，临时指针指向当前元素
					temp.nextChild = ch;
					temp = ch;
				}
			}
			
		}
	}
	
	public void show() {
		Child temp = this.firstChild;
		do {
			System.out.println(temp.no + "----");
			temp = temp.nextChild;
		}while (temp != firstChild);
	}
}