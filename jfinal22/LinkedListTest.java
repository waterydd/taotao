import java.util.*;

/**
 * 简单创建两个链表
 *合并它们，然后从第二个链表中每隔1个元素删除一个，最后测试removeAll方法。
 * 
 * @author Administrator
 *
 */


public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> a = new LinkedList<>();
		a.add("A");
		a.add("B");
		a.add("C");
		
		List<String> b = new LinkedList<String>();
		
		b.add("D");
		b.add("E");
		b.add("F");
		
		ListIterator<String> at = a.listIterator();
		Iterator<String> bt = b.iterator();
		
		while(bt.hasNext()){
			if(at.hasNext())
				at.next();
			at.add(bt.next());
		}
		
		System.out.println(a);
		//重新给个迭代器
		bt = b.iterator();
		while(bt.hasNext()){
			bt.next();
			if(bt.hasNext()){
				bt.next();
				bt.remove();
			}
		}
		System.out.println(b);
		//此时b链表为[D,F]
		a.removeAll(b);
		System.out.println(a);
	}
	

}
