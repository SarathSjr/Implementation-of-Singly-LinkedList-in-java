package linkedListImple;

public class LinkedListCall {
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		
		
		for(int i=5; i<=100; i+=5) {
			list.insertAtEnd(i);
		}
		list.display();
		
		list.deleteAtPos(5);
		list.display();
		
		list.deleteFromEnd();
		list.display();
		
		list.deleteFromStart();
		list.display();
		
	}
}
