package com.oracle.list;
// When-ever traversing(print and movement) is used  , use while (n!=null); for delete and add use while(n.next!=null)
public class DoubleLinkedList {

	private Node head;
	
	private static class Node {
		int data;
		Node next;
		Node prev;
		
		Node(int data)
		{
			this.data=data;
			next = null;
			prev =null;
		}
	}
	
	public void add (int data)
	{
		Node node = new Node(data);
		if(head==null) {
			head=node;
			return;
		}
		
		Node n = head;
		while(n.next!=null)
		{
			n = n.next;
		}
		
		n.next= node;
		node.prev=n;		
		
	}
	
	public void delete( int data) {
		if(head.data == data) {
			head=head.next;
		    head.prev=null;
		}
		Node n = head;
		
		while(n.next!=null)
		{
			if(n.next.data==data)
			{
				n.next = n.next.next;
				
				if(n.next!=null)
					n.next.prev=n;
				
			}
			
			n = n.next;
		}
		
	}
	
	public String traverserList() {
		
		Node n = head;
		Node prevs=null;
		StringBuilder sb = new StringBuilder();
		sb.append("Forward:");
		
		
		while(n!=null)
		{
			sb.append(n.data);
			sb.append(",");
			prevs = n;
			n = n.next;
		}
		
		sb.append("Backward:");
		while(prevs!=null)
		{
			sb.append(prevs.data);
			sb.append(",");
			prevs=prevs.prev;
		}
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		Node n = head;
		while(n!=null) {
			
			sb.append(n.data);
			sb.append(",");
			n = n.next;
		}
		
		return sb.toString();
		
	}
}
