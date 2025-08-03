package linkedListImple;

public class LinkedList<T>{
	class Node{
		T data;
		Node next;
		
		Node(T data) {
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	public LinkedList() {
		Node head=null;
	}
	
	
	public void insertAtEnd(T data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = newNode;
	}


	public void insertAtBegining(T data) {
		
		Node newNode = new Node(data);
		
		if(head==null) {
			head = newNode;
		}
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAtPosition(int pos, T data) {
		if(pos == 0) {
			insertAtBegining(data);
			return;
		}
		Node newNode = new Node(data);
		
		Node current = head;
		for(int i=1; i<pos && current!=null; i++) {
			current = current.next;
		}
		
		if(current==null) {throw new IndexOutOfBoundsException("Position out of bound!!!");}
		
		newNode.next = current.next;
		current.next = newNode;
	}
	
	public void deleteFromStart() {
		if(head==null) {
			return;
		}
		head = head.next;
	}
	
	public void deleteFromEnd() {
		if(head==null || head.next == null) {
			head = null;
			return;
		}
		Node current = head;
		while(current.next.next!=null) {
			current = current.next;;
		}
		current.next = null;
	}
	
	public void deleteAtPos(int pos) {
		if(head == null) {
			return;
		}
		
		if(pos == 0) {
			deleteFromStart();
			return;
		}
		
		Node current = head;
		for(int i=1; i< pos && current != null; i++) {
			current = current.next;
		}
		
		if(current == null) {
			throw new IndexOutOfBoundsException("Position out of bound!!!");
		}
		current.next = current.next.next;
	}
	
	
	public void display() {
		Node temp = head;
		
		System.out.print("Head");
		while(temp!=null) {
			System.out.print(" -> "+temp.data);
			temp = temp.next;
		}
		System.out.print(" Null");
		System.out.println("\n");
	}

	
}
