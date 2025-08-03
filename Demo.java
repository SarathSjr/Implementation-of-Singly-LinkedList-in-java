package Demo;

import java.util.Iterator;

public class Demo {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.inserAtPos(0, 20);
		list.inserAtPos(1, 30);
		list.inserAtPos(2, 40);
		list.insertAtBeginning(10);
		list.inserAtPos(4, 50);
//		list.reverse();
		
		int res = list.search(20);
		if(res == 1 ) {System.out.println("At "+res+"st position.");}
		else if(res == 2 ) {System.out.println("At "+res+"nd position.");}
		else if(res == 3 ) {System.out.println("At "+res+"rd position.");}
		else {
			System.out.println("At "+res+"th position.");
		}
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
	}
}

class LinkedList<T> implements Iterable<T>{
	Node head;
	
	class Node{
		T data;
		Node next;
		
		Node(T data) {
			this.data = data;
			next = null;
		}
	}
	
	LinkedList() {
		head = null;
	}

	
	public int search(T i) {
		Node temp = head;
		int pos = 0;
		
		while(temp != null) {
			if(temp.data.equals(i)) {
				return pos;
			}
			temp = temp.next;
			pos++;
		}
		return -1;
	}
	

	public void reverse() {
		Node prev = null;
		Node current = head;
		Node next = head.next;
		
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		head = prev;
		
	}


	public void delete(int pos) {
		if(head == null) {
			throw new IndexOutOfBoundsException("List is empty!!!");
		}
		
		if(pos == 0) {
			head = head.next;
			return;
		}
		
		Node temp = head;
		Node prev = null;
		
		for(int i=1; i<=pos; i++) {
			prev = temp;
			temp = temp.next;
		}
		
		prev.next = temp.next;
		temp.next = null;
		
	}


	public void inserAtPos(int pos, T val) {
		
		if(pos < 1) { insertAtBeginning(val); return;}
		
		Node newNode = new Node(val);
		Node temp = head;
		
		for(int i=1; i<pos; i++) {
			temp = temp.next;
			if(temp == null) {
				throw new IllegalArgumentException();
			}
		}
		
		newNode.next = temp.next;
		temp.next = newNode;
		
	}

	public void insertAtBeginning(T val) {
		Node newNode = new Node(val);
		
		if(head == null) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	
	
	public void display() {
		Node temp = head;
		
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}


	@Override
	public Iterator<T> iterator() {
		return new Iterator<>() {

			Node temp = head;
			@Override
			public boolean hasNext() {
				return temp != null;
			}

			@Override
			public T next() {
				T val = temp.data;
				temp = temp.next;
				return val;
			}

		};
	}



}