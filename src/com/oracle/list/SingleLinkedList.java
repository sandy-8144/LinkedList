package com.oracle.list;

public class SingleLinkedList {

	private Node head;
	
	private static class Node {
		int data;
		Node next;
		
		Node(int data)
		{
			this.data=data;
			next=null;
		}
		
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
