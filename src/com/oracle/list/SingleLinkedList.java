package com.oracle.list;

public class SingleLinkedList {

	private Node head;
	
	public static class Node {
		public int data;
	public 	Node next;
		
		Node(int data)
		{
			this.data=data;
			next=null;
		}
		
	}
	
	public Node getHead() {
		return head;
	}
	public void add(int data) {
		Node node = new Node(data);
		Node n=head;
		
		if(head==null) {
			head=node;
			return;
		}
		while(n.next!=null)
		{
			n = n.next;
		}
		n.next=node;
		return;					
	}
	
	public void addFirst(int data) {
		Node node = new Node(data);
		if(head==null)
			head = node;
		
		node.next=head;
		head=node;
		
	}
	
	
	public Node mergeSortedList( Node head1, Node head2) {
		// Merge two sorted list in O(n)
		
		if(head1==null && head2==null)
			return null;
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		
		Node temp = new Node(-1);
		Node head = temp;
		while(head1!=null && head2!=null) {
			
			if(head1.data < head2.data) {
				head.next=head1;
				head1 = head1.next;
				
			}else {
				
				head.next=head2;
				head2 = head2.next;
			}
			
			head = head.next;
			
		}
		
		if(head1!=null)
			head.next = head1;
		if(head2!=null)
			head.next=head2;
		
		return temp.next;
		
	}
	
	public void delete(int data)
	{
		Node n = head;		
		if(n.data == data)
			head = n.next;
		
		while(n!=null && n.next!=null)
		{
			if(n.next.data==data)
			{				
				n.next=n.next.next;
			}
			n = n.next;
		}
		
	}
	
	public void reverseList() {
		
		Node temp = reverseList(head);
		temp.next=null;
		/*head = reverseList(head);*/
	}
	
	private Node reverseList(Node root) {
		
		
		if(root.next!=null) {
		reverseList(root.next);
		root.next.next=root;
		return root;
		} else {
			head=root;
			return head;
		}
		
		/*if(root ==null || root.next==null)
			return root;
		
		 reverseList(root.next);
		root.next.next=root;*/
		
		
	}
	
	public void removeDuplicates() {
		Node node = head;
		
		
		while(node.next!=null)
		{
			if(node.data==node.next.data)
			{
				node.next=node.next.next;
				
			}
			else {
				node = node.next;
			}
			
			
		}
		
	}
	
	public void addInSortedList(int data)
	{
		Node newNode = new Node(data);
		Node node = head;
		if(node==null || node.data==data)
		{
			newNode.next=node;
			node = newNode;
			return;
		}
		
		while(node.next!=null && node.next.data < data) {
			node = node.next;
		}
		
		newNode.next = node.next;
		node.next = newNode;
		
		
	}
	
	public int getMiddle() {
		
		Node node = head;
		if(head==null)
			return -1;
		Node slow = node;
		Node fast = node;
		
		while(fast!=null && fast.next!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		/*if(fast!=null)
			slow = slow.next;*/
		return slow.data;
	}
	
	
	public boolean compareList(Node secondList) {
		
		if(this.head == null && secondList ==null)
			return true;
		if(head==null || secondList ==null)
			return false;
		
		Node first = head;
		Node second = secondList;
		
		while(first!=null || second!=null) {
			
			if(first.data!=second.data)
				return false;
			first= first.next;
			second=second.next;
		}
		
		if(first==null && second==null)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		Node n = head;
		
		while(n!=null)
		{
			sb.append(n.data);
			sb.append(",");
			n = n.next;
		}
		
		
		return sb.toString();
	}
	
}
