package com.oracle.stack;

public class Stack {

	protected Node top;
	
	private static class Node {
		Node next;
		int data;
		
		Node(int data){
			
			this.next=null;
			this.data=data;
		}
		
	}
	
	
	public int pop() {
		if(top==null)
			throw new NullPointerException();
		Node temp = top.next;
		int data = top.data;;
		top = temp;
		return data;
		
		
	}
	
	
	public void push(int data) {
		Node node = new Node(data);
		if(top==null) {
			top = node;
			return;
		}
		
		node.next=top;
		top = node;
		
	}
	
	public boolean isEmpty() {
		return top==null;
		
	}
	public int peek() {
		if(isEmpty())
			throw new IllegalStateException();
		return top.data;
	}
	
	@Override
	public String toString() {
		
		Node node = top;
		StringBuilder sb = new StringBuilder();
		while(node!=null)
		{
			sb.append(node.data);
			sb.append(",");
			node = node.next;
		}
		
		return sb.toString();
	}
}
