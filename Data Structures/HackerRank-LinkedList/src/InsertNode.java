
public class InsertNode {

	Node head;
	static class Node{
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
			
		}
	}

	public void append(int new_data) {
		
		Node new_node = new Node(new_data);
		
		if(head == null) {
			head = new Node(new_data);
			return;
		}
		new_node.next = null;
		
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		return;
	}
	
	public void printLit() {
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		InsertNode list = new InsertNode();
		
		list.append(10);
		list.append(25);
		
		list.printLit();
		//Node second = new Node(10);
		
	}

}
