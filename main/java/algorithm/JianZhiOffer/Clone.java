package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/7/27 8:40
 * <p>
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone {
	public RandomListNode clone(RandomListNode pHead) {
		if (pHead == null){
			return null;
		}
		RandomListNode current = pHead;

		/*
		* 如果一开始只是单纯的先构造一个复制的没有设置random的链表，那么新的链表的random就完全与旧链表的random失去了联系
		* 无法通过原来链表的random对新链表的random进行设置
		*
		* 由于random本身是没有规则的，我们无法只通过random来设置random，设置random也需要用到next，考虑在random和next之间建立联系
		*
		* 所以考虑在每一个原节点后复制一个新节点，那么再次遍历的时候，获取新节点的random就可以转化为源节点的random的next
		* */
		while (current!=null){
			RandomListNode newNode = new RandomListNode(current.label);
			newNode.next = current.next;
			current.next = newNode;
			current = current.next.next;
		}
		current = pHead;
		while (current!=null){
			current.next.random = current.random==null?null:current.random.next;
			current = current.next.next;
		}
		current =pHead.next;
		RandomListNode oldCurrent = pHead;
		RandomListNode newHead = pHead.next;
		while (oldCurrent!=null){
			oldCurrent.next = current.next;
			oldCurrent = oldCurrent.next;
			current.next = oldCurrent==null?null:oldCurrent.next;
			current = current.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		RandomListNode node = new RandomListNode(-1);
		RandomListNode head = node;
		int i =2;
		while (i<6){
			node.next = new RandomListNode(i++);
			node = node.next;
		}
		System.out.println(head.next);

		Clone solution = new Clone();
		System.out.println(solution.clone(head.next)==head.next);
	}
}

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}

	@Override
	public String toString() {
		if (next == null){
			return String.valueOf(label);
		}
		return label +"->"+ next.toString();
	}
}
